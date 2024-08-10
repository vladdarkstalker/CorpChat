package com.corpchat.CorpChat.controller;

import com.corpchat.CorpChat.dto.UserRegistrationDto;
import com.corpchat.CorpChat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userServiceImp;

    public RegistrationController(UserService userServiceImp) {
        super();
        this.userServiceImp = userServiceImp;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")
                                      UserRegistrationDto registrationDto) {
        try {
            userServiceImp.save(registrationDto);
        }catch(Exception e)
        {
            System.out.println(e);
            return "redirect:/registration?email_invalid";
        }
        return "redirect:/registration?success";
    }
}