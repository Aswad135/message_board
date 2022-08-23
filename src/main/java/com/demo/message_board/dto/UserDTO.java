package com.demo.message_board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String email;
}
