package com.demo.message_board;

import com.demo.message_board.dto.MessageDTO;
import com.demo.message_board.entities.Message;
import com.demo.message_board.service.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MessageBoardApplicationTests extends AbstractTest {

    @Autowired
    MessageService service;

    @Override
    @BeforeAll
    public void setUp() {
        super.setUp();
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setContent("New Message Added");
        service.addNewMessage(messageDTO);
    }

    @Test
    void contextLoads() {
    }


    @Test
    void getAllMessages() throws Exception {
        String uri = "/message/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        MessageDTO[] messageDTOS = super.mapFromJson(content, MessageDTO[].class);
        assertTrue(messageDTOS.length > 0);
    }

    @Test
    void createNewMessages() throws Exception {
        String uri = "/messages/save";
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setContent("Created a new Message");


        String inputJson = super.mapToJson(messageDTO);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        MessageDTO res = super.mapFromJson(content, MessageDTO.class);
        assertEquals(messageDTO.getContent(), res.getContent());

    }

}
