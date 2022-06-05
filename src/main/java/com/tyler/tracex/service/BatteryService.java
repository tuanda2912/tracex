package com.tyler.tracex.service;

import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetNameBatteryByPostcodeOutput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetNameBatteryByPostcodeInput;

public interface BatteryService {

    void addBatteryLIst(AddBatteryInput input);

    GetNameBatteryByPostcodeOutput getBatteryByPostcode(GetNameBatteryByPostcodeInput input);

}
