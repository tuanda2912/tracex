package com.tyler.tracex.domain.message;

import java.io.Serializable;

/**
 * Class name.
 *
 * @author tuanda
 * @version 1.0
 * @since 03/11/2020
 */
public class BaseMessage implements Serializable {
    private String code;
    private boolean success;
    private String description;
    private String message;

    public BaseMessage() {

    }

    public BaseMessage(String code, boolean success, String description) {
        this.code = code;
        this.description = description;
        this.success = success;
    }

    public BaseMessage(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
