package me.lolico.sms.controller;

import me.lolico.sms.entity.User;
import me.lolico.sms.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

/**
 * @author lolico
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String login(@AuthenticationPrincipal Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/index";
        }
        return "index";
    }

    @PostMapping("register")
    public String register(User user) throws SQLException {
        if (user.getName() != null && userService.getUserByName(user.getName()) != null) {
            return "redirect:/account/login?status=2";
        }
        userService.insertUser(user);
        return "redirect:/account/login?status=3";
    }
}
