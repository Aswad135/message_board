package com.demo.message_board.dto;

import com.demo.message_board.entities.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MessageDTO {
    private int id;
    private String content;
    private UserDTO owner;
}
