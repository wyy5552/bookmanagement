package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Member;
import com.example.bookmanagement.service.UserService;
import com.example.bookmanagement.session.UserSession;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSession userSession;


    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Member member = userService.findByUsername(username);
        if (member != null && Objects.equals(password, member.getPassword())) {
            userSession.setUsername(username);
            model.addAttribute("username", userSession.getUsername());
            return "redirect:/home";
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.findByUsername(username) != null) {
            model.addAttribute("registrationError", "Username already exists");
            return "redirect:/login";
        }
        Member newMember = new Member();
        newMember.setUsername(username);
        newMember.setPassword(password);
        userService.save(newMember);
        return "redirect:/login";
    }
}