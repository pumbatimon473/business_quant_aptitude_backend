package com.lld.businessquanttestservice1.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDto {
    // Fields
    private Integer errorCode;
    private String errorMessage;
}
