package com.demo.message_board.controller;

import com.demo.message_board.entities.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface MessageController {

    @GetMapping(path = "/message/all")
    ResponseEntity<List<Message>> getAllMessages();

    @GetMapping(path = "/messages")
    ResponseEntity<List<Message>> getMessages();

    @GetMapping(path = "/messages/{id}")
    ResponseEntity<Message> getMessageWithId(@PathVariable int id);

    @PostMapping(path = "/messages/save")
    ResponseEntity<Message> addNewMessage(@RequestBody Message message);

    @PutMapping(path = "/messages/update")
    ResponseEntity<Message> updateMessage(@RequestBody Message message);

    @DeleteMapping(path = "/messages/delete/{id}")
    ResponseEntity<Boolean> deleteMessage(@PathVariable int id);

}
