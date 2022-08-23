package com.demo.message_board.service;

import com.demo.message_board.entities.Message;
import com.demo.message_board.exception.MessageNotFoundException;
import com.demo.message_board.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    MessageRepository repository;
    Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Message>> getAllMessages() {
        try {
            List<Message> todo = repository.findAll();
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        throw new MessageNotFoundException();
    }

    public ResponseEntity<List<Message>> getMessages() {
        try {
            List<Message> todo = repository.findAll();
//            todo.stream().filter(message -> {message.getUser()})
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        throw new MessageNotFoundException();
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

    public ResponseEntity<Message> getMessageWithId(int id) {
        return null;
    }
}
