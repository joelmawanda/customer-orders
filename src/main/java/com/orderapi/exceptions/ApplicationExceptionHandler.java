package com.orderapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String > handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return errorMap;
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(RecordNotFoundException.class)
//    public ResponseEntity<OperationResponse> handleBusinessException(RecordNotFoundException ex){
//        return new ResponseEntity<>(new OperationResponse(Constants.OPERATION_FAILURE_CODE, ex.getLocalizedMessage()), HttpStatus.NOT_FOUND);
//    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(HttpMessageNotWritableException.class)
//    public ResponseEntity<OperationResponse> handleHttpMessageNotWritableException(HttpMessageNotWritableException ex){
//        return new ResponseEntity<>(new OperationResponse(Constants.OPERATION_FAILURE_CODE, ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}

