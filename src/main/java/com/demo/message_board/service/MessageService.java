package com.demo.message_board.service;

import com.demo.message_board.dto.MessageDTO;
import com.demo.message_board.entities.Message;
import com.demo.message_board.entities.User;
import com.demo.message_board.exception.GlobalException;
import com.demo.message_board.exception.MessageNotFoundException;
import com.demo.message_board.mapper.MessageMapper;
import com.demo.message_board.repository.MessageRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    MessageRepository repository;
    Logger logger = LoggerFactory.getLogger(MessageService.class);
    MessageMapper messageMapper = Mappers.getMapper(MessageMapper.class);

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        try {
            List<Message> messages = repository.findAll();
            List<MessageDTO> dto = new ArrayList<>();
            for (Message mess : messages) {
                dto.add(messageMapper.toDTO(mess));
            }
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        throw new MessageNotFoundException();
    }

    public ResponseEntity<List<MessageDTO>> getMessages() {
        return getAllMessages();
    }

    public ResponseEntity<MessageDTO> addNewMessage(MessageDTO messageDTO) {
        try {
            Message message = messageMapper.fromDTO(messageDTO);
            message = repository.save(message);
            messageDTO = messageMapper.toDTO(message);
            return new ResponseEntity<>(messageDTO, HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        throw new GlobalException();
    }

    public ResponseEntity<MessageDTO> updateMessage(MessageDTO messageDTO) {
        try {
            Message message = messageMapper.fromDTO(messageDTO);
            Optional<Message> existingMessage = repository.findById(message.getId());
            if (existingMessage.isPresent()) {
                existingMessage.get().setContent(message.getContent());
                message = repository.save(existingMessage.get());
                messageDTO = messageMapper.toDTO(message);
                return new ResponseEntity<>(messageDTO, HttpStatus.OK);
            } else
                throw new MessageNotFoundException();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        throw new GlobalException();
    }

    public ResponseEntity<Boolean> deleteMessage(int id) {
        try {
            Optional<Message> existingMessage = repository.findById(id);
            if (existingMessage.isPresent()) {
                repository.deleteById(existingMessage.get().getId());
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else
                throw new MessageNotFoundException();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        throw new GlobalException();
    }

    public ResponseEntity<MessageDTO> getMessageWithId(int id) {
        try {
            Optional<Message> existingMessage = repository.findById(id);
            if (existingMessage.isPresent()) {
                MessageDTO messageDTO = messageMapper.toDTO(existingMessage.get());
                return new ResponseEntity<>(messageDTO, HttpStatus.OK);
            } else
                throw new MessageNotFoundException();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        throw new GlobalException();
    }
}
