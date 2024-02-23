package com.lld.businessquanttestservice1.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class StockRepositoryCustomImpl implements StockRepositoryCustom {
    // Fields
    private static final String tableName = "stocks";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getRecords(List<String> cols, String ticker) {
        String fields = String.join(",", cols);
        Query nativeQuery = this.entityManager.createNativeQuery("SELECT " + fields + " FROM " + StockRepositoryCustomImpl.tableName
                + " WHERE ticker = :ticker");
        nativeQuery.setParameter("ticker", ticker);
        return nativeQuery.getResultList();
    }

    @Override
    public List<Object[]> getRecordsWithinPeriod(List<String> cols, String ticker, Integer periodInYear) {
        String fields = String.join(",", cols);
        Query nativeQuery = this.entityManager.createNativeQuery("SELECT " + fields + " FROM " + StockRepositoryCustomImpl.tableName
                + " WHERE ticker = :ticker AND date >= date_add(CURRENT_DATE(), INTERVAL :period YEAR)");
        nativeQuery.setParameter("ticker", ticker);
        nativeQuery.setParameter("period", -periodInYear);
        return nativeQuery.getResultList();
    }
}
