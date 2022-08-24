package com.demo.message_board.exception.ExceptionHandler;

import com.demo.message_board.exception.GlobalException;
import com.demo.message_board.exception.MessageNotFoundException;
import com.demo.message_board.exception.UnAuthorizedMessageAccess;
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
        return ex;
    }

    @ExceptionHandler(UnAuthorizedMessageAccess.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public UnAuthorizedMessageAccess handleUnAuthorizedAccessException(UnAuthorizedMessageAccess ex) {
        return ex;
    }

    @ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public GlobalException handleUnAuthorizedAccessException(GlobalException ex) {
        return ex;
    }


}
