package com.globpay.cashpickupmicroservice.services;

import com.globpay.cashpickupmicroservice.entities.CashPickupBeneficiary;
import com.globpay.cashpickupmicroservice.exceptions.BeneficiaryAlreadyExistException;
import com.globpay.cashpickupmicroservice.repositories.CashPickupBeneficiaryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashPickupBeneficiaryService{

    @Autowired
    private CashPickupBeneficiaryRepository cashPickupBeneficiaryRepository;

    public List<CashPickupBeneficiary> getAllBeneficiaries(String userId){
        return cashPickupBeneficiaryRepository.findByUserId(userId);
    }

    public CashPickupBeneficiary getBeneficiary(String beneficiaryId){
        return cashPickupBeneficiaryRepository.findById(beneficiaryId).get();
    }

    public CashPickupBeneficiary addBeneficiary(String userId, CashPickupBeneficiary newCashPickupBeneficiary) {

        newCashPickupBeneficiary.setUserId(userId);
        if (cashPickupBeneficiaryRepository.existsByUserIdAndNameAndMobileNumberAndVerificationIdAndStatus
                (
                        newCashPickupBeneficiary.getUserId(),
                        newCashPickupBeneficiary.getName(),
                        newCashPickupBeneficiary.getMobileNumber(),
                        newCashPickupBeneficiary.getVerificationId(),
                        newCashPickupBeneficiary.isStatus())
                )
        {
            throw new BeneficiaryAlreadyExistException("You have already added this person");
        }
        return cashPickupBeneficiaryRepository.save(newCashPickupBeneficiary);
    }

    public CashPickupBeneficiary updateBeneficiary(String userId, String beneficiaryId, CashPickupBeneficiary newBeneficiary){

        CashPickupBeneficiary oldBeneficiary = cashPickupBeneficiaryRepository.findById(beneficiaryId).get();
        BeanUtils.copyProperties(newBeneficiary, oldBeneficiary);
        oldBeneficiary.setUserId(userId);

        return cashPickupBeneficiaryRepository.save(oldBeneficiary);
    }

    public void deleteBeneficiary(String beneficiaryId){
        cashPickupBeneficiaryRepository.deleteById(beneficiaryId);
    }

}
