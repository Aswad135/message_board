package com.demo.message_board.controller.impl;


import com.demo.message_board.controller.MessageController;
import com.demo.message_board.entities.Message;
import com.demo.message_board.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MessageControllerImpl implements MessageController {

    MessageService service;

    @Autowired
    public MessageControllerImpl(MessageService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Message>> getAllMessages() {
        return this.service.getAllMessages();
    }

    @Override
    public ResponseEntity<List<Message>> getMessages() {
        return this.service.getMessages();
    }

    @Override
    public ResponseEntity<Message> addNewMessage(Message message) {
        return this.service.addNewMessage(message);
    }

    @Override
    public ResponseEntity<Message> updateMessage(Message message) {
        return this.service.updateMessage(message);
    }

    @Override
    public ResponseEntity<Boolean> deleteMessage(int id) {
        return this.service.deleteMessage(id);
    }
}
