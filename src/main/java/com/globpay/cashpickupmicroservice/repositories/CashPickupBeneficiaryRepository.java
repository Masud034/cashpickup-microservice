package com.globpay.cashpickupmicroservice.repositories;

import com.globpay.cashpickupmicroservice.entities.CashPickupBeneficiary;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CashPickupBeneficiaryRepository extends JpaRepository<CashPickupBeneficiary, String> {

    List<CashPickupBeneficiary> findByUserId(String userId);

    boolean existsByUserIdAndNameAndMobileNumberAndVerificationIdAndStatus(String userId,String name, String mobileNumber,
                                                                           String verificationId,
                                                                           boolean status);
    //   boolean existsByEntity(CashPickupBeneficiary cashPickupBeneficiary);
}
