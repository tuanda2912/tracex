package com.tyler.tracex.controller;

import com.tyler.tracex.domain.message.ResponseMessage;
import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeInput;
import com.tyler.tracex.service.BatteryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @Operation(summary = "Save a list of Battery")
    @ApiResponse(responseCode = "200", description = "Save completed",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class)) })
    @ApiResponse(responseCode = "400", description = "Input invalid",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class)) })
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class)) })
    public ResponseEntity<?> createBatteryList(@Valid @RequestBody AddBatteryInput addBatteryInput) {
        batteryService.addBatteryLIst(addBatteryInput);
        return toSuccessResult(null, "Successfully");
    }

    @PostMapping(value = "/get-battery-by-postcode")
    @Operation(summary = "Get Battery names by Post code")
    @ApiResponse(responseCode = "200", description = "List battery name, total records found and Watt Average",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class)) })
    @ApiResponse(responseCode = "400", description = "Input invalid",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class)) })
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseMessage.class)) })
    public ResponseEntity<?> getBatteryByPostcode(@Valid @RequestBody GetBatteryNameByPostcodeInput input) {
        return toSuccessResult(batteryService.getBatteryByPostcode(input), "Successfully");
    }

}
