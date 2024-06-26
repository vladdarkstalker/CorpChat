package com.corpchat.CorpChat.repository;

import com.corpchat.CorpChat.dbmodels.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByChatId(Integer chatId);
    List<Message> findBySenderId(Integer senderId);
}
