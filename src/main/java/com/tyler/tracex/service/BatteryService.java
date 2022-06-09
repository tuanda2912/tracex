package com.tyler.tracex.service;

import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeOutput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeInput;

public interface BatteryService {

    void addBatteryList(AddBatteryInput input);

    GetBatteryNameByPostcodeOutput getBatteryByPostcode(GetBatteryNameByPostcodeInput input);

}
