package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.entity.Message;
import com.corpchat.CorpChat.entity.User;
import com.corpchat.CorpChat.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserService userService;

    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public Message sendMessage(Long senderId, Long receiverId, String content) {
        User sender = userService.findById(senderId);
        User receiver = userService.findById(receiverId);
        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return messageRepository.save(message);
    }

    public List<Message> getChatHistory(Long userId1, Long userId2) {
        User user1 = userService.findById(userId1);
        User user2 = userService.findById(userId2);
        return messageRepository.findBySenderAndReceiverOrReceiverAndSender(user1, user2, user1, user2);
    }
}

