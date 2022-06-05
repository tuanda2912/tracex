package com.tyler.tracex.domain.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ResponseMessage
 * @author tuanda
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage<T> extends BaseMessage implements Serializable {
    private T data;

}
