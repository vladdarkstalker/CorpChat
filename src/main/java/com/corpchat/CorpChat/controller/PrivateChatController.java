package com.corpchat.CorpChat.controller;

import com.corpchat.CorpChat.dbmodels.PrivateChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.corpchat.CorpChat.service.PrivateChatService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/private-chats")
public class PrivateChatController {

    @Autowired
    private PrivateChatService privateChatService;

    @GetMapping
    public List<PrivateChat> getAllPrivateChats() {
        return privateChatService.getAllPrivateChats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrivateChat> getPrivateChatById(@PathVariable Integer id) {
        Optional<PrivateChat> privateChat = privateChatService.getPrivateChatById(id);
        if (privateChat.isPresent()) {
            return ResponseEntity.ok(privateChat.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/sender/{senderId}")
    public List<PrivateChat> getPrivateChatsBySenderId(@PathVariable Integer senderId) {
        return privateChatService.getPrivateChatsBySenderId(senderId);
    }

    @GetMapping("/receiver/{receiverId}")
    public List<PrivateChat> getPrivateChatsByReceiverId(@PathVariable Integer receiverId) {
        return privateChatService.getPrivateChatsByReceiverId(receiverId);
    }

    @PostMapping
    public ResponseEntity<PrivateChat> createPrivateChat(@RequestBody PrivateChat privateChat) {
        PrivateChat createdPrivateChat = privateChatService.createPrivateChat(privateChat);
        return ResponseEntity.ok(createdPrivateChat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrivateChat(@PathVariable Integer id) {
        privateChatService.deletePrivateChat(id);
        return ResponseEntity.noContent().build();
    }
}
