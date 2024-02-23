package com.lld.businessquanttestservice1.controllers;

import com.lld.businessquanttestservice1.dtos.StockDto;
import com.lld.businessquanttestservice1.exceptions.ClientErrorException;
import com.lld.businessquanttestservice1.exceptions.InvalidTickerException;
import com.lld.businessquanttestservice1.services.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Api")
@AllArgsConstructor
public class StocksController {
    // Fields
    private StockService stockService;


    // Behaviors
    // REQUIREMENT 2: Fetch records by ticker
    @GetMapping
    public HttpEntity<List<StockDto>> getAllHistoryForStock(@RequestParam(name = "ticker") String ticker) throws InvalidTickerException, ClientErrorException {
        if (ticker == null || ticker.isEmpty()) throw new InvalidTickerException(9, "Ticker name is required!");
        HttpEntity<List<StockDto>> response;
        try {
            response = new ResponseEntity<>(this.stockService.getHistoricView(ticker).stream()
                    .map(StockDto::from)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            throw new ClientErrorException(101, e.getMessage());
        }
        return response;
    }

    // REQUIREMENT 3: fetch custom view of the records - Return only the specified columns for the ticker
    @GetMapping("/custom")
    public HttpEntity<List<Map<String, Object>>> getCustomHistoricViewForStock(@RequestParam(name = "ticker") String ticker, @RequestParam(name = "column") String column) throws InvalidTickerException, ClientErrorException {
        if (ticker == null || ticker.isEmpty()) throw new InvalidTickerException(9, "Ticker name is required!");
        HttpEntity<List<Map<String, Object>>> response;
        try {
            List<String> columnsList = Arrays.stream(column.split(","))
                    .map(col -> col.trim())
                    .collect(Collectors.toList());
            response = new ResponseEntity<>(this.stockService.getCustomHistoricView(ticker, columnsList), HttpStatus.OK);
        } catch (Exception e) {
            throw new ClientErrorException(102, e.getMessage());
        }
        return response;
    }

    // REQUIREMENT 4: fetch custom view of the records within a specified period (past x years)
    @GetMapping("/custom/period")
    public HttpEntity<List<Map<String, Object>>> getCustomHistoricViewWithinPeriodForStock(@RequestParam(name = "ticker") String ticker, @RequestParam(name = "column") String column, @RequestParam(name = "period") Integer periodInYear) throws InvalidTickerException, ClientErrorException {
        if (ticker == null || ticker.isEmpty()) throw new InvalidTickerException(9, "Ticker name is required!");
        HttpEntity<List<Map<String, Object>>> response;
        try {
            List<String> columnsList = Arrays.stream(column.split(","))
                    .map(col -> col.trim())
                    .collect(Collectors.toList());
            response = new ResponseEntity<>(this.stockService.getCustomHistoricViewWithinPeriod(ticker, columnsList, periodInYear), HttpStatus.OK);
        } catch (Exception e) {
            throw new ClientErrorException(103, e.getMessage());
        }
        return response;
    }
}
