package com.demo.message_board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDTO {
    private int id;
    private String title;
    private String desc;
}
