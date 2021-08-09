package com.globpay.cashpickupmicroservice.controllers;

import com.globpay.cashpickupmicroservice.entities.CashPickupBeneficiary;
import com.globpay.cashpickupmicroservice.model.ApiResponse;
import com.globpay.cashpickupmicroservice.services.CashPickupBeneficiaryService;
import com.globpay.cashpickupmicroservice.validators.BeneficiaryIdMustExist;
import com.globpay.cashpickupmicroservice.validators.UserIdMustExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
public class CashPickupBeneficiaryController {
    @Autowired
    private CashPickupBeneficiaryService cashPickupBeneficiaryService;

    @GetMapping(value = "/beneficiary/{userId}/cashpickup",produces = "application/json")
    public ResponseEntity<ApiResponse> getAllBeneficiaries(@PathVariable @UserIdMustExist String userId){
        return new ResponseEntity(new ApiResponse("Success",cashPickupBeneficiaryService.getAllBeneficiaries(userId)), HttpStatus.OK);
    }

    @GetMapping(value = "beneficiary/{userId}/cashpickup/{cashpickupId}", produces = "application/json")
    public ResponseEntity<ApiResponse> getBeneficiary(@PathVariable @UserIdMustExist String userId,
                                                                @PathVariable @BeneficiaryIdMustExist String cashpickupId){
        return new ResponseEntity<>(new ApiResponse("Success",cashPickupBeneficiaryService.getBeneficiary(cashpickupId)), HttpStatus.OK);
    }

    @PostMapping(value = "/beneficiary/{userId}/cashpickup", consumes = "application/json", produces = "application/json")
    public  ResponseEntity<ApiResponse> addBeneficiary(@PathVariable @UserIdMustExist String userId, @Valid @RequestBody CashPickupBeneficiary cashPickupBeneficiary){
        return new ResponseEntity<>(new ApiResponse("Success",cashPickupBeneficiaryService.addBeneficiary(userId, cashPickupBeneficiary)), HttpStatus.CREATED);
    }

    @PutMapping(value = "beneficiary/{userId}/beneficiary/{cashpickupId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse> updateBeneficiary(@PathVariable @BeneficiaryIdMustExist String cashpickupId,
                                                                   @PathVariable @UserIdMustExist String userId,
                                                                   @Valid @RequestBody CashPickupBeneficiary newCashPickupBeneficiary){
        return new ResponseEntity<>(new ApiResponse("Success",cashPickupBeneficiaryService.updateBeneficiary(userId,cashpickupId, newCashPickupBeneficiary)), HttpStatus.OK);
    }

    @DeleteMapping(value = "beneficiary/{userId}/cashpickup/{cashpickupId}")
    public ResponseEntity<ApiResponse> deleteBeneficiary(@PathVariable @UserIdMustExist String userId, @PathVariable @BeneficiaryIdMustExist String cashpickupId){
        return new ResponseEntity(new ApiResponse("Deleted"),HttpStatus.NO_CONTENT);
    }
}
