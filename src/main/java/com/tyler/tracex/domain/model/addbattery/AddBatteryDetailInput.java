package com.tyler.tracex.domain.model.addbattery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddBatteryDetailInput implements Serializable {
    private static final long serialVersionUID = 8298861230954401926L;

    private String name;
    private Integer postCode;
    private Double wattCapacity;

}
