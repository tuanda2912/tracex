package com.tyler.tracex.repository;

import com.tyler.tracex.domain.entity.Battery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, String>, BatteryCustomRepository {

    @Query(value = "SELECT NAME FROM BATTERY WHERE POST_CODE >= :fromPostCode AND POST_CODE <= :toPostCode", nativeQuery = true)
    List<String> getBatteryNameByPostCodeRange(Integer fromPostCode, Integer toPostCode, Pageable pageable);

}
