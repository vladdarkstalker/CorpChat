package com.corpchat.CorpChat.controller;

import com.corpchat.CorpChat.dbmodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.corpchat.CorpChat.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email")
    public List<User> getUsersByEmail(@RequestParam String email) {
        return userService.getUsersByEmail(email);
    }

    @GetMapping("/login")
    public List<User> getUsersByLogin(@RequestParam String login) {
        return userService.getUsersByLogin(login);
    }

    @GetMapping("/firstName")
    public List<User> getUsersByFirstName(@RequestParam String firstName) {
        return userService.getUsersByFirstName(firstName);
    }

    @GetMapping("/middleName")
    public List<User> getUsersByMiddleName(@RequestParam String middleName) {
        return userService.getUsersByMiddleName(middleName);
    }

    @GetMapping("/lastName")
    public List<User> getUsersByLastName(@RequestParam String lastName) {
        return userService.getUsersByLastName(lastName);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLogin(userDetails.getLogin());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setMiddleName(userDetails.getMiddleName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
