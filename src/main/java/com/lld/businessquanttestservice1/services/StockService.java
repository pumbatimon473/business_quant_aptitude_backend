package com.lld.businessquanttestservice1.services;


import com.lld.businessquanttestservice1.models.StockRecord;

import java.util.List;
import java.util.Map;

public interface StockService {
    List<StockRecord> getHistoricView(String ticker);
    List<Map<String, Object>> getCustomHistoricView(String ticker, List<String> cols);
    List<Map<String, Object>> getCustomHistoricViewWithinPeriod(String ticker, List<String> cols, Integer periodInYear);
}
