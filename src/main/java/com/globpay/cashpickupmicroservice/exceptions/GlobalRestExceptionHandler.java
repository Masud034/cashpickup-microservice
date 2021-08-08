package com.globpay.cashpickupmicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BeneficiaryAlreadyExist.class})
    public ResponseEntity<String> handleDuplicatedBeneficiary(BeneficiaryAlreadyExist beneficiaryAlreadyExist) {

        String error = beneficiaryAlreadyExist.getMessage();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
