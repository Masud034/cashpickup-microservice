package com.globpay.cashpickupmicroservice.exceptions;

import com.globpay.cashpickupmicroservice.model.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError: fieldErrors){
            errors.add(fieldError.getField() + " " + fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(new ApiResponse("Invalid properties", errors), status);
    }

    @ExceptionHandler({BeneficiaryAlreadyExistException.class})
    public ResponseEntity<ApiResponse> handleDuplicatedBeneficiary(BeneficiaryAlreadyExistException beneficiaryAlreadyExist , WebRequest webRequest) {

        List<String> errors = new ArrayList<>();
        errors.add(beneficiaryAlreadyExist.getMessage());

        return new ResponseEntity<>(new ApiResponse("Bad Request", errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ApiResponse> handleConstraintViolation(ConstraintViolationException ex, WebRequest webRequest) {

        List<String> errors = new ArrayList<>();

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

        for (ConstraintViolation<?> constraintViolation: constraintViolations) {
            errors.add(constraintViolation.getMessage());
        }
        return new ResponseEntity<>( new ApiResponse("Validation Failed", errors), HttpStatus.BAD_REQUEST);
    }
}
