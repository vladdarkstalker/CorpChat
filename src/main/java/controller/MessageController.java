package controller;

import dbmodels.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.MessageService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Integer id) {
        Optional<Message> message = messageService.getMessageById(id);
        if (message.isPresent()) {
            return ResponseEntity.ok(message.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/chat/{chatId}")
    public List<Message> getMessagesByChatId(@PathVariable Integer chatId) {
        return messageService.getMessagesByChatId(chatId);
    }

    @GetMapping("/sender/{senderId}")
    public List<Message> getMessagesBySenderId(@PathVariable Integer senderId) {
        return messageService.getMessagesBySenderId(senderId);
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Integer id, @RequestBody Message messageDetails) {
        Optional<Message> messageOptional = messageService.getMessageById(id);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setChat(messageDetails.getChat());
            message.setSender(messageDetails.getSender());
            message.setContent(messageDetails.getContent());
            Message updatedMessage = messageService.updateMessage(message);
            return ResponseEntity.ok(updatedMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
