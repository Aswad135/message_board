package com.demo.message_board.controller;

import com.demo.message_board.dto.MessageDTO;
import com.demo.message_board.entities.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MessageController {

    @GetMapping(path = "/messages/all")
    ResponseEntity<List<MessageDTO>> getAllMessages();

    @GetMapping(path = "/messages")
    ResponseEntity<List<MessageDTO>> getMessages();

    @GetMapping(path = "/messages/{id}")
    ResponseEntity<MessageDTO> getMessageWithId(@PathVariable int id);

    @PostMapping(path = "/messages/save")
    ResponseEntity<MessageDTO> addNewMessage(@RequestBody MessageDTO message);

    @PutMapping(path = "/messages/update")
    ResponseEntity<MessageDTO> updateMessage(@RequestBody MessageDTO message);

    @DeleteMapping(path = "/messages/delete/{id}")
    ResponseEntity<Boolean> deleteMessage(@PathVariable int id);

    @GetMapping(path = "/messages/add/dummy")
    void addDummyData();
}
