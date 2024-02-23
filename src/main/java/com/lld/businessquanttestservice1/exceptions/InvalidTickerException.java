package com.lld.businessquanttestservice1.exceptions;

import lombok.Getter;

@Getter
public class InvalidTickerException extends Exception {
    // Fields
    private Integer errCode;
    private String errMsg;

    public InvalidTickerException(Integer errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
