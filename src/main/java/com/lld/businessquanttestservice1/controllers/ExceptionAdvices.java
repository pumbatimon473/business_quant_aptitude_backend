package com.lld.businessquanttestservice1.controllers;

import com.lld.businessquanttestservice1.dtos.ErrorDto;
import com.lld.businessquanttestservice1.exceptions.ClientErrorException;
import com.lld.businessquanttestservice1.exceptions.InvalidTickerException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(InvalidTickerException.class)
    public HttpEntity<ErrorDto> handleInvalidTickerException(InvalidTickerException e) {
        return new ResponseEntity<>(new ErrorDto(e.getErrCode(), e.getErrMsg()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientErrorException.class)
    public HttpEntity<ErrorDto> handleClientErrorException(ClientErrorException e) {
        return new ResponseEntity<>(new ErrorDto(e.getErrCode(), e.getErrMsg()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
