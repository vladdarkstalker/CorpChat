package com.corpchat.CorpChat.repository;

import com.corpchat.CorpChat.dbmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByMiddleName(String middleName);
    List<User> findByLogin(String login);
    List<User> findByEmail(String email);
}
