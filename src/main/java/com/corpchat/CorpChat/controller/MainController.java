package com.corpchat.CorpChat.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main/")
@AllArgsConstructor
public class MainController {

    @GetMapping("/welcome")
    public String pageWelcome() { return "This is unprotected welcome page!"; }

    @GetMapping("/all")
    public String pageAll() { return "This is page for all dudes!"; }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String pageUsers() { return "This is page for only users!"; }

    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String pageAdmins() { return "This is page for only admins!"; }
}
