package com.demo.message_board.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MessageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public MessageNotFoundException handleMessageNotFoundException(MessageNotFoundException ex) {
        MessageNotFoundException errorResponse = new MessageNotFoundException();
        return errorResponse;
    }

    @ExceptionHandler(UnAuthorizedMessageAccess.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public UnAuthorizedMessageAccess handleUnAuthorizedAccessException(UnAuthorizedMessageAccess ex) {
        UnAuthorizedMessageAccess errorResponse = new UnAuthorizedMessageAccess();
        return errorResponse;
    }


}
