package com.globpay.cashpickupmicroservice.services;

import com.globpay.cashpickupmicroservice.entities.CashPickupBeneficiary;
import com.globpay.cashpickupmicroservice.exceptions.BeneficiaryAlreadyExist;
import com.globpay.cashpickupmicroservice.repositories.CashPickupBeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashPickupBeneficiaryService {

    @Autowired
    private CashPickupBeneficiaryRepository cashPickupBeneficiaryRepository;

    public List<CashPickupBeneficiary> getAllBeneficiaries(String userId) {
        return cashPickupBeneficiaryRepository.findByUserId(userId);
    }

    public CashPickupBeneficiary getBeneficiary(String beneficiaryId) {
        return cashPickupBeneficiaryRepository.findById(beneficiaryId).get();
    }

    public CashPickupBeneficiary addBeneficiary(CashPickupBeneficiary newCashPickupBeneficiary) {
        if (cashPickupBeneficiaryRepository.existsByUserIdAndNameAndMobileNumberAndVerificationIdAndStatus
                (
                        newCashPickupBeneficiary.getUserId(),newCashPickupBeneficiary.getName(),
                        newCashPickupBeneficiary.getMobileNumber(),newCashPickupBeneficiary.getVerificationId(),
                        newCashPickupBeneficiary.isStatus())
                )
        {
            throw new BeneficiaryAlreadyExist("You have already added this person");
        }
        return cashPickupBeneficiaryRepository.save(newCashPickupBeneficiary);
    }

    public CashPickupBeneficiary updateBeneficiary(String beneficiaryId, CashPickupBeneficiary newBeneficiary){

        CashPickupBeneficiary oldBeneficiary = cashPickupBeneficiaryRepository.findById(beneficiaryId).get();
        oldBeneficiary.setUserId(newBeneficiary.getUserId());
        oldBeneficiary.setName(newBeneficiary.getName());
        oldBeneficiary.setMobileNumber(newBeneficiary.getMobileNumber());
        oldBeneficiary.setVerificationId(newBeneficiary.getVerificationId());
        oldBeneficiary.setStatus(newBeneficiary.isStatus());

        return cashPickupBeneficiaryRepository.save(oldBeneficiary);
    }

    public void deleteBeneficiary(String beneficiaryId){
        cashPickupBeneficiaryRepository.deleteById(beneficiaryId);
    }

}
