package com.tyler.tracex.service.impl;

import com.tyler.tracex.domain.entity.Battery;
import com.tyler.tracex.domain.model.addbattery.AddBatteryInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeInput;
import com.tyler.tracex.domain.model.getnamebatterybyrange.GetBatteryNameByPostcodeOutput;
import com.tyler.tracex.repository.BatteryRepository;
import com.tyler.tracex.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    @Override
    public void addBatteryLIst(AddBatteryInput addBatteryInput) {
        Assert.isTrue(!CollectionUtils.isEmpty(addBatteryInput.getAddBatteryDetailList()), "Input battery list can not be empty or null");
        List<Battery> batteryList = addBatteryInput.getAddBatteryDetailList().stream().map(batteryDetailInput -> {
            Battery battery = new Battery();
            BeanUtils.copyProperties(batteryDetailInput, battery);
            battery.setCreateDate(LocalDateTime.now());
            battery.setUpdateTime(LocalDateTime.now());
            return battery;
        }).collect(Collectors.toList());
        batteryRepository.saveAll(batteryList);
    }

    @Override
    public GetBatteryNameByPostcodeOutput getBatteryByPostcode(GetBatteryNameByPostcodeInput input) {
        Map<String, Object> mapTotalAndAvg = batteryRepository.getTotalRowAndAvgWatt(input.getFromPostCode(), input.getToPostCode());
        if(CollectionUtils.isEmpty(mapTotalAndAvg)) {
            return GetBatteryNameByPostcodeOutput.builder()
                    .batteryNameList(null)
                    .total(0l)
                    .averageWatt(0D)
                    .build();
        }
        List<String> nameList = batteryRepository.getBatteryNameByPostCodeRange(input.getFromPostCode(), input.getToPostCode(),
                PageRequest.of(Objects.isNull(input.getPageIndex()) ? 0 : input.getPageIndex(),
                        Objects.isNull(input.getPageSize()) ? 10 : input.getPageSize(), Sort.by("NAME").ascending()));
        return GetBatteryNameByPostcodeOutput.builder()
                .batteryNameList(nameList)
                .total(((BigInteger) mapTotalAndAvg.get("TOTAL")).longValue())
                .averageWatt((Double) mapTotalAndAvg.get("AVG"))
                .build();
    }
}
