package com.demo.message_board.controller.impl;


import com.demo.message_board.controller.MessageController;
import com.demo.message_board.dto.MessageDTO;
import com.demo.message_board.entities.Message;
import com.demo.message_board.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MessageControllerImpl implements MessageController {

    MessageService service;

    @Autowired
    public MessageControllerImpl(MessageService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        return this.service.getAllMessages();
    }

    @Override
    public ResponseEntity<List<MessageDTO>> getMessages() {
        return this.service.getMessages();
    }

    @Override
    public ResponseEntity<MessageDTO> getMessageWithId(int id) {
        return this.service.getMessageWithId(id);
    }

    @Override
    public ResponseEntity<MessageDTO> addNewMessage(MessageDTO message) {
        return this.service.addNewMessage(message);
    }

    @Override
    public ResponseEntity<MessageDTO> updateMessage(MessageDTO message) {
        return this.service.updateMessage(message);
    }

    @Override
    public ResponseEntity<Boolean> deleteMessage(int id) {
        return this.service.deleteMessage(id);
    }
}
