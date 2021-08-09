package com.globpay.cashpickupmicroservice.controllers;

import com.globpay.cashpickupmicroservice.entities.CashPickupBeneficiary;
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
    public ResponseEntity<CashPickupBeneficiary> getAllBeneficiaries(@PathVariable @UserIdMustExist String userId){
        return new ResponseEntity(cashPickupBeneficiaryService.getAllBeneficiaries(userId), HttpStatus.OK);
    }

    @GetMapping(value = "beneficiary/{userId}/cashpickup/{cashpickupId}", produces = "application/json")
    public ResponseEntity<CashPickupBeneficiary> getBeneficiary(@PathVariable @UserIdMustExist String userId,
                                                                @PathVariable @BeneficiaryIdMustExist String cashpickupId){
        return new ResponseEntity<>(cashPickupBeneficiaryService.getBeneficiary(cashpickupId), HttpStatus.OK);
    }

    @PostMapping(value = "/beneficiary/{userId}/cashpickup", consumes = "application/json", produces = "application/json")
    public  ResponseEntity<CashPickupBeneficiary> addBeneficiary(@PathVariable String userId, @Valid @RequestBody CashPickupBeneficiary cashPickupBeneficiary){
        return new ResponseEntity<>(cashPickupBeneficiaryService.addBeneficiary(userId, cashPickupBeneficiary), HttpStatus.CREATED);
    }

    @PutMapping(value = "beneficiary/{userId}/beneficiary/{cashpickupId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CashPickupBeneficiary> updateBeneficiary(@PathVariable @BeneficiaryIdMustExist String cashpickupId,
                                                                   @PathVariable @UserIdMustExist String userId,
                                                                   @Valid @RequestBody CashPickupBeneficiary newCashPickupBeneficiary){
        return new ResponseEntity<>(cashPickupBeneficiaryService.updateBeneficiary
                (cashpickupId, newCashPickupBeneficiary), HttpStatus.OK);
    }

    @DeleteMapping(value = "beneficiary/{userId}/cashpickup/{cashpickupId}")
    public ResponseEntity deleteBeneficiary(@PathVariable @UserIdMustExist String userId, @PathVariable @BeneficiaryIdMustExist String cashpickupId){
        cashPickupBeneficiaryService.deleteBeneficiary(cashpickupId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
