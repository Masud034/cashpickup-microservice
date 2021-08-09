package com.globpay.cashpickupmicroservice.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserIdMustExistValidator.class)
public @interface UserIdMustExist {

    String message() default "INVALID User Id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
