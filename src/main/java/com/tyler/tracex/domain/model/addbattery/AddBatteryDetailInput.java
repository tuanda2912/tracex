package com.tyler.tracex.domain.model.addbattery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBatteryDetailInput implements Serializable {
    private static final long serialVersionUID = 8298861230954401926L;

    @NotBlank(message = "Name must not be null or empty")
    @Size(max = 100, message = "Name only from 0 to 100")
    @Schema(description = "Name of the battery")
    private String name;

    @NotNull(message = "Post code must not be null")
    @Schema(description = "Post code of the battery")
    private Integer postCode;

    @NotNull(message = "Watt capacity must not be null")
    @Schema(description = "Watt capacity of the battery")
    private Double wattCapacity;

}
