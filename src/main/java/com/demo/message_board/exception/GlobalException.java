package com.demo.message_board.exception;

public class GlobalException extends RuntimeException {
    public GlobalException() {
        super();
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "There was an exception during this request. : " + super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return "There was an exception during this request. : " + super.getLocalizedMessage();
    }
}
