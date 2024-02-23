package com.lld.businessquanttestservice1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
public class ClientErrorException extends Exception {
    // Fields
    private Integer errCode;
    private String errMsg;

    public ClientErrorException(Integer errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
