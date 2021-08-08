package com.globpay.cashpickupmicroservice.exceptions;

public class BeneficiaryAlreadyExist extends RuntimeException{
    public BeneficiaryAlreadyExist(String message) {
        super(message);
    }
}
