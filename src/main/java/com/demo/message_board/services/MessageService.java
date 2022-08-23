package com.demo.message_board.services;

import com.demo.message_board.entities.Message;
import com.demo.message_board.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<List<Message>> getAllMessages() {
        return null;
    }

    public ResponseEntity<List<Message>> getMessages() {
        return null;
    }

    public ResponseEntity<Message> addNewMessage(Message message) {
        return null;
    }

    public ResponseEntity<Message> updateMessage(Message message) {
        return null;
    }

    public ResponseEntity<Boolean> deleteMessage(int id) {
        return null;
    }
}
