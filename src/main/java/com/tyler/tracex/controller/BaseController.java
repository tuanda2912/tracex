package com.tyler.tracex.controller;

import com.tyler.tracex.common.Const;
import com.tyler.tracex.domain.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * CommonController
 *
 * @author tuanda
 * @version 1.0
 * @since 03/11/2020
 */
public abstract class BaseController {


    protected <T> ResponseEntity<ResponseMessage<T>> toSuccessResult(T data, String successMessage) {
        ResponseMessage<T> message = new ResponseMessage<>();

        message.setCode(HttpStatus.OK.value());
        message.setSuccess(true);
        message.setMessage(successMessage);
        message.setData(data);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    protected <T> ResponseEntity<ResponseMessage<T>> toExceptionResult(String errorMessage, int code) {
        ResponseMessage<T> message = new ResponseMessage<>();

        message.setSuccess(false);
        message.setCode(code);
        message.setMessage(errorMessage);

        return new ResponseEntity<>(message, HttpStatus.valueOf(code));
    }
}
