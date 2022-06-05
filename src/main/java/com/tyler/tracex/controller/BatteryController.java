package com.tyler.tracex.controller;

import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetNameBatteryByPostcodeInput;
import com.tyler.tracex.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Tuanda
 * Service for Battery
 */
@RestController
@RequestMapping("/battery")
@RequiredArgsConstructor
public class BatteryController extends BaseController {

    private final BatteryService batteryService;

    @PostMapping(value = "")
    public ResponseEntity<?> createBatteryList(@RequestBody AddBatteryInput addBatteryInput) {
        batteryService.addBatteryLIst(addBatteryInput);
        return toSuccessResult(null, "Successfully");
    }

    @PostMapping(value = "/get-battery-by-postcode")
    public ResponseEntity<?> getBatteryByPostcode(@RequestBody GetNameBatteryByPostcodeInput input) {
        return toSuccessResult(batteryService.getBatteryByPostcode(input), "Successfully");
    }

}
