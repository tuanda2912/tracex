package com.tyler.tracex.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tyler.tracex.domain.dto.BatteryDetailInfoDTO;
import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeOutput;
import com.tyler.tracex.repository.BatteryRepository;
import com.tyler.tracex.util.BatteryUtil;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BatteryServiceImplTest {

    @Autowired
    private BatteryService batteryService;

    @MockBean
    private BatteryRepository batteryRepository;

    @DisplayName("Test Add batteries function")
    @Test
    void testAddBatteries() {
        AddBatteryInput addBatteryInput = BatteryUtil.buildAddBatteryInput();
        when(batteryRepository.saveAll(any())).thenReturn(new ArrayList<>());
        batteryService.addBatteryList(addBatteryInput);
    }

    @DisplayName("Test get batteries function")
    @Test
    void testGetBatteriesFunction() {
        GetBatteryNameByPostcodeInput input = BatteryUtil.buildGetNameBatteryInput();
        BatteryDetailInfoDTO batteryDetailInfoDTO = new BatteryDetailInfoDTO();
        Map<String, Object> mapping = new HashMap<>();
        batteryDetailInfoDTO.setTotal(20L);
        batteryDetailInfoDTO.setAverageWattCapacity(127.5D);
        when(batteryRepository.getTotalRowAndAvgWatt(input.getFromPostCode(), input.getToPostCode())).thenReturn(batteryDetailInfoDTO);
        Pageable pageable = PageRequest.of(input.getPageIndex(), input.getPageSize(), Sort.by("NAME").ascending());
        List<String> nameList = List.of("Battery 1", "Battery 2", "Battery 3");
        GetBatteryNameByPostcodeOutput expect = BatteryUtil.buildGetNameBatteryOutput(nameList);
        when(batteryRepository.getBatteryNameByPostCodeRange(input.getFromPostCode(), input.getToPostCode(), pageable)).thenReturn(nameList);
        GetBatteryNameByPostcodeOutput actual = batteryService.getBatteryByPostcode(input);
        BatteryUtil.checkEqualsFuncGetBatteries(expect, actual);
    }

    @DisplayName("Test get batteries function if not found")
    @Test
    void testGetBatteriesFunctionNotFound() {
        GetBatteryNameByPostcodeInput input = BatteryUtil.buildGetNameBatteryInput();
        when(batteryRepository.getTotalRowAndAvgWatt(input.getFromPostCode(), input.getToPostCode())).thenReturn(null);
        GetBatteryNameByPostcodeOutput expect = GetBatteryNameByPostcodeOutput.builder()
                .total(0L)
                .averageWatt(0D)
                .batteryNameList(null)
                .build();
        GetBatteryNameByPostcodeOutput actual = batteryService.getBatteryByPostcode(input);
        BatteryUtil.checkEqualsFuncGetBatteries(expect, actual);
    }

}
