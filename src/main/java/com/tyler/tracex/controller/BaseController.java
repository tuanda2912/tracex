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


    protected <T> ResponseEntity<?> toSuccessResult(T data, String successMessage) {
        ResponseMessage<T> message = new ResponseMessage<>();

        message.setCode(Const.API_RESPONSE.RETURN_CODE_SUCCESS + "");
        message.setSuccess(Const.API_RESPONSE.RESPONSE_STATUS_TRUE);
        message.setMessage(successMessage);
        message.setData(data);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    protected <T> ResponseEntity<?> toExceptionResult(String errorMessage, int code) {
        ResponseMessage<T> message = new ResponseMessage<>();

        message.setSuccess(Const.API_RESPONSE.RESPONSE_STATUS_FALSE);
        message.setCode(code + "");
        message.setMessage(errorMessage);

        return new ResponseEntity<>(message, HttpStatus.valueOf(code));
    }
}
