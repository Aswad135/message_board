package com.demo.message_board.utils;

import com.demo.message_board.entities.Message;

import java.util.*;

public class Utils {

    public static List<Message> getDummyData() {
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message message = new Message();
            message.setContent("Dummy Message :" + i);
            messages.add(message);
        }
        return messages;

    }
}
