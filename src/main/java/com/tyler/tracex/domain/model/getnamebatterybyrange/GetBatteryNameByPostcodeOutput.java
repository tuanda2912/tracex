package com.tyler.tracex.domain.model.getnamebatterybyrange;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetBatteryNameByPostcodeOutput implements Serializable {
    private static final long serialVersionUID = -3212285433565879258L;

    @Schema(description = "List name of batteries after filter")
    private List<String> batteryNameList;

    @Schema(description = "Total records in database")
    private Long total;

    @Schema(description = "Average Watt of batteries after filter")
    private Double averageWatt;
}
