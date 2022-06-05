package com.tyler.tracex.domain.model.getnamebatterybyrange;

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
public class GetNameBatteryByPostcodeOutput implements Serializable {
    private static final long serialVersionUID = -3212285433565879258L;

    private List<String> batteryNameList;
    private Long total;
    private Double averageWatt;
}
