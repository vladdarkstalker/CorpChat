package com.corpchat.CorpChat.controller;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping("/welcome")
    public String pageWelcome() { return "welcome"; }

    @GetMapping("/all")
    public String pageAll() { return "all"; }

    @GetMapping("/users")
    public String pageUsers() { return "users"; }

    @GetMapping("/admins")
    public String pageAdmins() { return "admins"; }
}
