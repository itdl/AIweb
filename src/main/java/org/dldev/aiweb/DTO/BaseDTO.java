package org.dldev.aiweb.DTO;

public class BaseDTO {

    /**
     * return code, 0-successful; 1-warning; 2-error;
     */
    private int code;
    /**
     * return message, meaningful description for the response
     */
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
