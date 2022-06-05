package com.tyler.tracex.repository;

import java.util.Map;

public interface BatteryCustomRepository {

    Map<String, Object> getTotalRowAndAvgWatt(Integer fromPostcode, Integer toPostCode);

}
