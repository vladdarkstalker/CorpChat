package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.dbmodels.User;
import com.corpchat.CorpChat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corpchat.CorpChat.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}