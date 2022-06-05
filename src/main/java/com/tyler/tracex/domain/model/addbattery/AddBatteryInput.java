package com.tyler.tracex.domain.model.addbattery;

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
public class AddBatteryInput implements Serializable {
    private static final long serialVersionUID = 1787208969968399440L;

    private List<AddBatteryDetailInput> addBatteryDetailList;

    //some more detail if needed
}
