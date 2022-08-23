package com.demo.message_board.exception;

public class UnAuthorizedMessageAccess extends RuntimeException {
    public UnAuthorizedMessageAccess() {
        super();
    }

    public UnAuthorizedMessageAccess(String message) {
        super(message);
    }

    public UnAuthorizedMessageAccess(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "User Not allowed to access message.";
    }

    @Override
    public String getLocalizedMessage() {
        return  "User Not allowed to access message.";
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
