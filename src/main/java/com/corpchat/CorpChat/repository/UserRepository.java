package com.corpchat.CorpChat.repository;

import com.corpchat.CorpChat.dbmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
