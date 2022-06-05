package com.tyler.tracex.repository.impl;

import com.tyler.tracex.repository.BatteryCustomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BatteryCustomRepositoryImpl implements BatteryCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Map<String, Object> getTotalRowAndAvgWatt(Integer fromPostcode, Integer toPostCode) {

        StringBuilder strQuery = new StringBuilder();
        strQuery.append("SELECT COUNT(*) as total, AVG(WATT_CAPACITY) as avg FROM BATTERY WHERE POST_CODE >= :fromPostCode AND POST_CODE <= :toPostCode ");
        Query query = em.createNativeQuery(strQuery.toString());
        query.setParameter("fromPostCode", fromPostcode);
        query.setParameter("toPostCode", toPostCode);
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
