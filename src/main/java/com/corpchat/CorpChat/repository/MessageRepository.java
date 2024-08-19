package com.corpchat.CorpChat.repository;

import com.corpchat.CorpChat.entity.Message;
import com.corpchat.CorpChat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderAndReceiver(User sender, User receiver);
    List<Message> findBySenderAndReceiverOrReceiverAndSender(User sender1, User receiver1, User sender2, User receiver2);
}
