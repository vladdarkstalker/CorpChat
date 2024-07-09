package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.dbmodels.User;
import com.corpchat.CorpChat.details.UserDetailsImp;
import com.corpchat.CorpChat.repository.UserRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements UserDetailsService {

    @Autowired
    private UserRepositoryImp userRepositoryImp;

    @Override
    public UserDetailsImp loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepositoryImp.findByUsername(username);
        return user.map(UserDetailsImp::new)
                .orElseThrow(()->new UsernameNotFoundException(username + "There is not such user in REPO!"));
    }
}