package com.corpchat.CorpChat.controller;

import com.corpchat.CorpChat.entity.User;
import com.corpchat.CorpChat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    @ResponseBody
    public List<User> searchUsers(@RequestParam("query") String query) {
        return userService.searchUsers(query);
    }
}