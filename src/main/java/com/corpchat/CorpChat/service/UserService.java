package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.dto.UserRegistrationDto;
import com.corpchat.CorpChat.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    List<User> getAll();
}