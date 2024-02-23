package com.lld.businessquanttestservice1.repositories;

import com.lld.businessquanttestservice1.models.StockRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockRecord, Long>, StockRepositoryCustom {
    List<StockRecord> findAllByTicker(String ticker);
}
