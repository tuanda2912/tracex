package com.tyler.tracex.domain.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Class name.
 *
 * @author tuanda
 * @version 1.0
 * @since 03/11/2020
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class BaseMessage implements Serializable {

    @Schema(description = "Status code of request")
    private int code;

    @Schema(description = "Boolean check if success")
    private boolean success;

    @Schema(description = "Description if needed")
    private String description;

    @Schema(description = "Message success or error")
    private String message;
}
