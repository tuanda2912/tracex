package com.tyler.tracex.service;

import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeOutput;
import com.tyler.tracex.repository.BatteryRepository;
import com.tyler.tracex.util.BatteryUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BatteryServiceImplTest {

    @Autowired
    private BatteryService batteryService;

    @MockBean
    private BatteryRepository batteryRepository;

    BatteryUtil batteryUtil = new BatteryUtil();

    @DisplayName("Test Add batteries function")
    @Test
    void testAddBatteries() {
        AddBatteryInput addBatteryInput = batteryUtil.buildAddBatteryInput();
        when(batteryRepository.saveAll(any())).thenReturn(new ArrayList<>());
        batteryService.addBatteryLIst(addBatteryInput);
    }

    @DisplayName("Test get batteries function")
    @Test
    void testGetBatteriesFunction() {
        GetBatteryNameByPostcodeInput input = batteryUtil.buildGetNameBatteryInput();
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("TOTAL", BigInteger.valueOf(20L));
        mapping.put("AVG", 127.5D);
        when(batteryRepository.getTotalRowAndAvgWatt(input.getFromPostCode(), input.getToPostCode())).thenReturn(mapping);
        Pageable pageable = PageRequest.of(input.getPageIndex(), input.getPageSize(), Sort.by("NAME").ascending());
        List<String> nameList = List.of("Battery 1", "Battery 2", "Battery 3");
        GetBatteryNameByPostcodeOutput expect = batteryUtil.buildGetNameBatteryOutput(nameList);
        when(batteryRepository.getBatteryNameByPostCodeRange(input.getFromPostCode(), input.getToPostCode(), pageable)).thenReturn(nameList);
        GetBatteryNameByPostcodeOutput actual = batteryService.getBatteryByPostcode(input);
        batteryUtil.checkEqualsFuncGetBatteries(expect, actual);
    }

    @DisplayName("Test get batteries function if not found")
    @Test
    void testGetBatteriesFunctionNotFound() {
        GetBatteryNameByPostcodeInput input = batteryUtil.buildGetNameBatteryInput();
        when(batteryRepository.getTotalRowAndAvgWatt(input.getFromPostCode(), input.getToPostCode())).thenReturn(null);
        GetBatteryNameByPostcodeOutput expect = GetBatteryNameByPostcodeOutput.builder()
                .total(0L)
                .averageWatt(0D)
                .batteryNameList(null)
                .build();
        GetBatteryNameByPostcodeOutput actual = batteryService.getBatteryByPostcode(input);
        batteryUtil.checkEqualsFuncGetBatteries(expect, actual);
    }

}
