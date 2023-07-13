package com.tyler.tracex.repository;

import com.tyler.tracex.domain.dto.BatteryDetailInfoDTO;

public interface BatteryCustomRepository {

    BatteryDetailInfoDTO getTotalRowAndAvgWatt(Integer fromPostcode, Integer toPostCode);

}
