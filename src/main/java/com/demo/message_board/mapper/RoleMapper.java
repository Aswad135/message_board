package com.demo.message_board.mapper;

import com.demo.message_board.dto.RoleDTO;
import com.demo.message_board.entities.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public abstract class RoleMapper {


    public abstract RoleDTO toDTO(Role role);

    @InheritInverseConfiguration(name = "toDTO")
    public abstract Role fromDTO(RoleDTO roleDTO);
}
