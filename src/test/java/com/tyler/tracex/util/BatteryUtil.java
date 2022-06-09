package com.tyler.tracex.util;

import com.tyler.tracex.domain.model.addbattery.AddBatteryDetailInput;
import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeOutput;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatteryUtil {

    public static AddBatteryInput buildAddBatteryInput() {
        AddBatteryInput addBatteryInput = new AddBatteryInput();
        AddBatteryDetailInput addBatteryDetailInputFirst = AddBatteryDetailInput.builder()
                .name("Battery 1")
                .postCode(100000)
                .wattCapacity(200.5D)
                .build();
        AddBatteryDetailInput addBatteryDetailInputSecond = AddBatteryDetailInput.builder()
                .name("Battery 2")
                .postCode(100001)
                .wattCapacity(190D)
                .build();
        addBatteryInput.setAddBatteryDetailList(List.of(addBatteryDetailInputFirst, addBatteryDetailInputSecond));
        return addBatteryInput;
    }

    public static GetBatteryNameByPostcodeInput buildGetNameBatteryInput() {
        return GetBatteryNameByPostcodeInput.builder()
                .fromPostCode(100000)
                .toPostCode(1000005)
                .pageIndex(0)
                .pageSize(10)
                .build();
    }

    public static GetBatteryNameByPostcodeOutput buildGetNameBatteryOutput(List<String> nameList) {
        return GetBatteryNameByPostcodeOutput.builder()
                .total(20L)
                .averageWatt(127.5D)
                .batteryNameList(nameList)
                .build();
    }

    public static void checkEqualsFuncGetBatteries(GetBatteryNameByPostcodeOutput expect, GetBatteryNameByPostcodeOutput actual) {
        assertEquals(expect.getAverageWatt(), actual.getAverageWatt());
        assertEquals(expect.getTotal(), actual.getTotal());
        assertEquals(expect.getBatteryNameList(), actual.getBatteryNameList());
    }

}
