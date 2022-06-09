package com.tyler.tracex.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BatteryDetailInfoDTO {

    private Long total;
    private Double averageWattCapacity;

}
