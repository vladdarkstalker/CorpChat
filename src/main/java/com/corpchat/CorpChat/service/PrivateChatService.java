package com.corpchat.CorpChat.service;

import com.corpchat.CorpChat.dbmodels.PrivateChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corpchat.CorpChat.repository.PrivateChatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrivateChatService {

    @Autowired
    private PrivateChatRepository privateChatRepository;

    public List<PrivateChat> getAllPrivateChats() {
        return privateChatRepository.findAll();
    }

    public Optional<PrivateChat> getPrivateChatById(Integer id) {
        return privateChatRepository.findById(id);
    }

    public List<PrivateChat> getPrivateChatsBySenderId(Integer senderId) {
        return privateChatRepository.findBySenderId(senderId);
    }

    public List<PrivateChat> getPrivateChatsByReceiverId(Integer receiverId) {
        return privateChatRepository.findByReceiverId(receiverId);
    }

    public PrivateChat createPrivateChat(PrivateChat privateChat) {
        return privateChatRepository.save(privateChat);
    }

    public void deletePrivateChat(Integer id) {
        privateChatRepository.deleteById(id);
    }
}
