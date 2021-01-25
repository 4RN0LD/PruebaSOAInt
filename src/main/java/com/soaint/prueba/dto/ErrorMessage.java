package com.soaint.prueba.dto;

public class ErrorMessage {
    private String HttpStatus;
    private String Message;
    private String code;
    private String BackendMessage;

    public ErrorMessage(String httpStatus, String message, String code, String backendMessage) {
        HttpStatus = httpStatus;
        Message = message;
        this.code = code;
        BackendMessage = backendMessage;
    }

    public String getHttpStatus() {
        return HttpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        HttpStatus = httpStatus;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBackendMessage() {
        return BackendMessage;
    }

    public void setBackendMessage(String backendMessage) {
        BackendMessage = backendMessage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Error{");
        sb.append("HttpStatus='").append(HttpStatus).append('\'');
        sb.append(", Message='").append(Message).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", BackendMessage='").append(BackendMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
