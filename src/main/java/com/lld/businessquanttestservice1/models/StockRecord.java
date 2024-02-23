package com.lld.businessquanttestservice1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity(name = "stocks")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockRecord extends BaseModel {
    // Fields
    private String ticker;
    private Date date;
    private String revenue;
    private String gp;
    private String fcf;
    private String capex;
}
