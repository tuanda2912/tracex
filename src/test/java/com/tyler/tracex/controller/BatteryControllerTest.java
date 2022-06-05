package com.tyler.tracex.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyler.tracex.domain.message.ResponseMessage;
import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeOutput;
import com.tyler.tracex.service.BatteryService;
import com.tyler.tracex.util.BatteryUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BatteryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private BatteryService batteryService;

    private final BatteryUtil batteryUtil = new BatteryUtil();

    @Test
    public void testCallAddBatteriesApiSuccess() throws Exception {
        AddBatteryInput input = batteryUtil.buildAddBatteryInput();
        HttpEntity<AddBatteryInput> request = new HttpEntity<>(input, null);
        ResponseEntity<ResponseMessage> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/battery").toString(), request, ResponseMessage.class);
        assertEquals("200", response.getBody().getCode());
        assertEquals("Successfully", response.getBody().getMessage());
        assertTrue(response.getBody().isSuccess());
    }

    @Test
    public void testCallGetBatteryName() throws Exception {
        GetBatteryNameByPostcodeInput input = batteryUtil.buildGetNameBatteryInput();
        HttpEntity<GetBatteryNameByPostcodeInput> request = new HttpEntity<>(input, null);
        List<String> nameList = List.of("Battery 1", "Battery 2", "Battery 3");
        GetBatteryNameByPostcodeOutput expect = batteryUtil.buildGetNameBatteryOutput(nameList);
        GetBatteryNameByPostcodeOutput outputService = batteryUtil.buildGetNameBatteryOutput(nameList);
        when(batteryService.getBatteryByPostcode(input)).thenReturn(outputService);
        ResponseEntity<ResponseMessage> response = restTemplate.postForEntity(
                new URL("http://localhost:" + port + "/battery/get-battery-by-postcode").toString(), request, ResponseMessage.class);
        assertEquals("200", response.getBody().getCode());
        assertEquals("Successfully", response.getBody().getMessage());
        assertTrue(response.getBody().isSuccess());
        batteryUtil.checkEqualsFuncGetBatteries(expect,
                new ObjectMapper().convertValue(response.getBody().getData(), GetBatteryNameByPostcodeOutput.class));
    }

}
