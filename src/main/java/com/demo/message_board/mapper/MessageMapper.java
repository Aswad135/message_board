package com.demo.message_board.mapper;

import com.demo.message_board.dto.MessageDTO;
import com.demo.message_board.entities.Message;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public abstract class MessageMapper {


    public abstract MessageDTO toDTO(Message message);

    @InheritInverseConfiguration(name = "toDTO")
    public abstract Message fromDTO(MessageDTO messageDTO);
}
