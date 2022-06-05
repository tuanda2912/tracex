package com.tyler.tracex.repository.impl;

import com.tyler.tracex.repository.BatteryCustomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
public class BatteryCustomRepositoryImpl implements BatteryCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Map<String, Object> getTotalRowAndAvgWatt(Integer fromPostcode, Integer toPostCode) {

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
        Map<String, Object> response = new HashMap<>();
        response.put("TOTAL", results.get(0)[0]);
        response.put("AVG", results.get(0)[1]);
        return response;
    }
}
