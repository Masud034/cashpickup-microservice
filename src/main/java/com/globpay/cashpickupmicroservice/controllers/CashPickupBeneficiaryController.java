package com.globpay.cashpickupmicroservice.controllers;

import com.globpay.cashpickupmicroservice.entities.CashPickupBeneficiary;
import com.globpay.cashpickupmicroservice.services.CashPickupBeneficiaryService;
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

    @GetMapping(value = "{userId}/beneficiaries",produces = "application/json")
    public ResponseEntity<CashPickupBeneficiary> getAllBeneficiaries(@PathVariable String userId){
        return new ResponseEntity(cashPickupBeneficiaryService.getAllBeneficiaries(userId), HttpStatus.OK);
    }

    @GetMapping(value = "beneficiaries/{beneficiaryId}", produces = "application/json")
    public ResponseEntity<CashPickupBeneficiary> getBeneficiary(@PathVariable String beneficiaryId){
        return new ResponseEntity<>(cashPickupBeneficiaryService.getBeneficiary(beneficiaryId), HttpStatus.OK);
    }

    @PostMapping(value = "/beneficiary", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CashPickupBeneficiary> addBeneficiary(@RequestBody @Valid CashPickupBeneficiary cashPickupBeneficiary){
        return new ResponseEntity<>(cashPickupBeneficiaryService.addBeneficiary(cashPickupBeneficiary), HttpStatus.CREATED);
    }

    @PutMapping(value = "beneficiaries/{userId}/beneficiary/{beneficiaryId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CashPickupBeneficiary> updateBeneficiary(@PathVariable String beneficiaryId,
                                                                   @PathVariable String userId,
                                                                   @RequestBody @Valid CashPickupBeneficiary newCashPickupBeneficiary){
        return new ResponseEntity<>(cashPickupBeneficiaryService.updateBeneficiary
                (beneficiaryId, newCashPickupBeneficiary), HttpStatus.OK);
    }

    @DeleteMapping(value = "beneficiaries/{userId}/beneficiary/{beneficiaryId}")
    public ResponseEntity deleteBeneficiary(@PathVariable String userId, @PathVariable String beneficiaryId){
        cashPickupBeneficiaryService.deleteBeneficiary(beneficiaryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
