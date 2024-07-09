package com.corpchat.CorpChat.repository;

import com.corpchat.CorpChat.dbmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryImp extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
