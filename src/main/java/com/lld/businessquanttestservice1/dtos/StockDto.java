package com.lld.businessquanttestservice1.dtos;

import com.lld.businessquanttestservice1.models.StockRecord;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {
    // Fields
    private String ticker;
    private String date;
    private String revenue;
    private String gp;
    private String fcf;
    private String capex;

    public static StockDto from(StockRecord stockRecord) {
        StockDto stockDto = new StockDto();
        stockDto.setTicker(stockRecord.getTicker());
        stockDto.setDate(stockRecord.getDate().toString());
        stockDto.setRevenue(stockRecord.getRevenue());
        stockDto.setGp(stockRecord.getGp());
        stockDto.setFcf(stockRecord.getFcf());
        stockDto.setCapex(stockRecord.getCapex());
        return stockDto;
    }
}
