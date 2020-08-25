package me.lolico.sms.controller;

import me.lolico.sms.entity.User;
import me.lolico.sms.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    UserService userService;

    @Before
    public void setUp() throws Exception {
        when(userService.getUserByName("exist")).thenReturn(new User());
        when(userService.getUserByName("notExist")).thenReturn(null);
    }

    @Test
    public void forbiddenWhenPostWithoutCsrfToken() throws Exception {
        mvc.perform(post("/account/register"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void canAccessLoginWhenNotAuthentication() throws Exception {
        mvc.perform(get("/account/login"))
                .andExpect(view().name("index"));
    }

    @Test
    public void registerFailedWhenUsernameIsNull() throws Exception {
        mvc.perform(post("/account/register").with(csrf()))
                .andExpect(redirectedUrl("/account/login?status=2"));
    }

    @Test
    public void registerFailedWhenUsernameAlreadyExists() throws Exception {
        mvc.perform(post("/account/register")
                .with(csrf()).param("name", "exist"))
                .andExpect(redirectedUrl("/account/login?status=2"));
    }

    @Test
    public void registerSuccessWhenUsernameNotExists() throws Exception {
        mvc.perform(post("/account/register")
                .with(csrf()).param("name", "notExist"))
                .andExpect(redirectedUrl("/account/login?status=3"));
    }
}