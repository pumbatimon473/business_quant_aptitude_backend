package com.lld.businessquanttestservice1.repositories;

import com.lld.businessquanttestservice1.models.StockRecord;

import java.util.List;

/**
 * - Aiming to retrieve only the specified columns from the table
 */
public interface StockRepositoryCustom {
    List<Object[]> getRecords(List<String> cols, String ticker);
    List<Object[]> getRecordsWithinPeriod(List<String> cols, String ticker, Integer periodInYear);
}
