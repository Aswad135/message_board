package com.demo.message_board.exception;

public class MessageNotFoundException extends RuntimeException{
    public MessageNotFoundException() {
        super();
    }

    public MessageNotFoundException(String message) {
        super(message);
    }

    public MessageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "Requested Message is not found";
    }

    @Override
    public String getLocalizedMessage() {
        return "Requested Message is not found";
    }
}
