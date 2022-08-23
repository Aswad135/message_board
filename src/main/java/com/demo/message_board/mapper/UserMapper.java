package com.demo.message_board.mapper;

import com.demo.message_board.dto.UserDTO;
import com.demo.message_board.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public abstract class UserMapper {


    public abstract UserDTO toDTO(User user);

    @InheritInverseConfiguration(name = "toDTO")
    public abstract User fromDTO(UserDTO userDTO);
}
