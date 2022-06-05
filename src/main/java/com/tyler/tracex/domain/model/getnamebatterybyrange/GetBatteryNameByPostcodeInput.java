package com.tyler.tracex.domain.model.getnamebatterybyrange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBatteryNameByPostcodeInput implements Serializable {
    private static final long serialVersionUID = -7583721206416035161L;
    @Schema(description = "From post code")
    private Integer fromPostCode;

    @Schema(description = "To post code")
    private Integer toPostCode;

    @Schema(description = "Page index")
    private Integer pageIndex;

    @Schema(description = "Page size")
    private Integer pageSize;
}
