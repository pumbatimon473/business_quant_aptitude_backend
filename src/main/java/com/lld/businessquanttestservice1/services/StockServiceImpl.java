package com.lld.businessquanttestservice1.services;

import com.lld.businessquanttestservice1.models.StockRecord;
import com.lld.businessquanttestservice1.repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {
    // Fields
    private StockRepository stockRepo;
    @Override
    public List<StockRecord> getHistoricView(String ticker) {
        return this.stockRepo.findAllByTicker(ticker);
    }

    @Override
    public List<Map<String, Object>> getCustomHistoricView(String ticker, List<String> cols) {
        List<Object[]> records = this.stockRepo.getRecords(cols, ticker);
        List<Map<String, Object>> mapList = StockServiceImpl.getMaps(cols, records);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> getCustomHistoricViewWithinPeriod(String ticker, List<String> cols, Integer periodInYear) {
        List<Object[]> records = this.stockRepo.getRecordsWithinPeriod(cols, ticker, periodInYear);
        List<Map<String, Object>> mapList = StockServiceImpl.getMaps(cols, records);
        return mapList;
    }

    private static List<Map<String, Object>> getMaps(List<String> cols, List<Object[]> records) {
        int i;
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Object[] record : records) {
            Map<String, Object> map = new HashMap<>();
            i = 0;
            for (String col : cols) {
                map.put(col, record[i++]);
            }
            mapList.add(map);
        }
        return mapList;
    }
}
