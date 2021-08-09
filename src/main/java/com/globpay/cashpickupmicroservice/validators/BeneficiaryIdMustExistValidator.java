package com.globpay.cashpickupmicroservice.validators;

import com.globpay.cashpickupmicroservice.repositories.CashPickupBeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class BeneficiaryIdMustExistValidator implements ConstraintValidator<BeneficiaryIdMustExist, String> {

    @Autowired
    private CashPickupBeneficiaryRepository cashPickupBeneficiaryRepository;

    @Override
    public void initialize(BeneficiaryIdMustExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String beneficiaryId, ConstraintValidatorContext constraintValidatorContext) {
        return cashPickupBeneficiaryRepository.findById(beneficiaryId).isPresent();
    }
}
