package com.globpay.cashpickupmicroservice.exceptions;

public class BeneficiaryAlreadyExistException extends RuntimeException{
    public BeneficiaryAlreadyExistException(String message) {
        super(message);
    }
}
