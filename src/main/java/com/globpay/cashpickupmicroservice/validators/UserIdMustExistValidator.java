package com.globpay.cashpickupmicroservice.validators;

import com.globpay.cashpickupmicroservice.repositories.CashPickupBeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdMustExistValidator implements ConstraintValidator<UserIdMustExist, String> {

    @Autowired
    private CashPickupBeneficiaryRepository cashPickupBeneficiaryRepository;

    @Override
    public void initialize(UserIdMustExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
