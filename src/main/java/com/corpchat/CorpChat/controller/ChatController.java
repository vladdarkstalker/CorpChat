package com.corpchat.CorpChat.controller;

import com.corpchat.CorpChat.dto.MessageDto;
import com.corpchat.CorpChat.entity.Message;
import com.corpchat.CorpChat.service.MessageService;
import com.corpchat.CorpChat.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final MessageService messageService;
    private final UserService userService;

    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody MessageDto messageDto) {
        Message message = messageService.sendMessage(messageDto.getSenderId(), messageDto.getReceiverId(), messageDto.getContent());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Message>> getChatHistory(@RequestParam Long userId1, @RequestParam Long userId2) {
        List<Message> chatHistory = messageService.getChatHistory(userId1, userId2);
        return ResponseEntity.ok(chatHistory);
    }
}
