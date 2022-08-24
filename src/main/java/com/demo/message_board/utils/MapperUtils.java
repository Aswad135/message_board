package com.demo.message_board.utils;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class MapperUtils {

    public static Mapper getMapper(Class<Mapper> tClass) {
        return Mappers.getMapper(tClass);
    }
}
