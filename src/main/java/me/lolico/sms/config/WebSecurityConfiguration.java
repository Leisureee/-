package me.lolico.sms.config;

import lombok.AllArgsConstructor;
import me.lolico.sms.entity.User;
import me.lolico.sms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author lolico
 */
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();
        auth.userDetailsService(userServiceUserDetailsService())
                .passwordEncoder(passwordEncoder);
        userService.setPasswordEncoder(passwordEncoder::encode);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/webjars/**", "/image/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                    .mvcMatchers("/account/register").permitAll()
                    .mvcMatchers("/account/login").permitAll()
                    .mvcMatchers("/account/logout").permitAll()
                    .and()
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .usernameParameter("name")
                    .passwordParameter("password")
                    .loginPage("/account/login?status=4")
                    .failureUrl("/account/login?status=1")
                    .loginProcessingUrl("/account/login")
                    .and()
                .logout()
                    .logoutUrl("/account/logout")
                    .logoutSuccessUrl("/account/login");
        // @formatter:on
    }


    @SuppressWarnings("deprecation")
    @Bean
    @ConditionalOnMissingBean
    public PasswordEncoder passwordEncoder() {
        DelegatingPasswordEncoder passwordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        passwordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
        return passwordEncoder;
    }

    @Bean
    public UserDetailsService userServiceUserDetailsService() {
        return new UserServiceUserDetailsService(userService);
    }

    static class UserServiceUserDetailsService implements UserDetailsService {

        final UserService userService;
        final Logger logger = LoggerFactory.getLogger(UserServiceUserDetailsService.class);

        UserServiceUserDetailsService(UserService userService) {
            this.userService = userService;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = null;
            try {
                user = userService.getUserByName(username);
            } catch (SQLException ex) {
                logger.warn("Occurring sql exception during load user", ex);
            }
            if (user == null)
                throw new UsernameNotFoundException("Cannot find user with name '" + username + "'");
            return org.springframework.security.core.userdetails.User.builder()
                    .username(username)
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        }

    }

    static class LoginFailureHandler implements AuthenticationFailureHandler {
        final SimpleUrlAuthenticationFailureHandler delegator;

        public LoginFailureHandler(String authenticationFailureUrl) {
            delegator = new SimpleUrlAuthenticationFailureHandler(authenticationFailureUrl);
            delegator.setUseForward(true);
        }

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
            request.setAttribute("status", 1);
            // request.getSession().setAttribute("status", 1);
            delegator.onAuthenticationFailure(request, response, exception);
        }
    }

}
