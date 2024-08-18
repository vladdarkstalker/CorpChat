package com.corpchat.CorpChat.controller;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            return "redirect:/welcome";  // Авторизованный пользователь
        } else {
            return "redirect:/login";  // Неавторизованный пользователь
        }
    }

    @GetMapping("/welcome")
    public String pageWelcome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            String username = userDetails.getUsername();
            model.addAttribute("userName", username);
        }
        return "welcome";
    }
}
