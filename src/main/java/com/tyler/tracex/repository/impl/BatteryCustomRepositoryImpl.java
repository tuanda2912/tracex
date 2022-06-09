package com.tyler.tracex.repository.impl;

import com.tyler.tracex.domain.dto.BatteryDetailInfoDTO;
import com.tyler.tracex.repository.BatteryCustomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.*;

@Repository
public class BatteryCustomRepositoryImpl implements BatteryCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public BatteryDetailInfoDTO getTotalRowAndAvgWatt(Integer fromPostcode, Integer toPostCode) {

        StringBuilder strQuery = new StringBuilder();
        strQuery.append("SELECT COUNT(*) as total, AVG(WATT_CAPACITY) as avg FROM BATTERY WHERE 1=1 ");
        Map<String, Integer> mapping = new HashMap<>();
        if(Objects.nonNull(fromPostcode)) {
            strQuery.append("AND POST_CODE >= :fromPostCode ");
            mapping.put("fromPostCode", fromPostcode);
        }
        if(Objects.nonNull(toPostCode)) {
            strQuery.append("AND POST_CODE <= :toPostCode ");
            mapping.put("toPostCode", toPostCode);
        }
        Query query = em.createNativeQuery(strQuery.toString());
        mapping.forEach(query::setParameter);
        List<Object[]> results = query.getResultList();
        if(CollectionUtils.isEmpty(results)) {
            return null;
        }
        return BatteryDetailInfoDTO.builder()
                .total(((BigInteger) results.get(0)[0]).longValue())
                .averageWattCapacity((Double) results.get(0)[1])
                .build();
    }
}
