package com.globpay.cashpickupmicroservice.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class CashPickupBeneficiary {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotEmpty
    private String userId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String mobileNumber;

    @NotEmpty
    private String verificationId;

    @NotNull
    private boolean status;

    public CashPickupBeneficiary(){

    }

    public CashPickupBeneficiary(String id, String userId, String name, String mobileNumber, String verificationId, boolean status) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.verificationId = verificationId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(String verificationId) {
        this.verificationId = verificationId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashPickupBeneficiary that = (CashPickupBeneficiary) o;
        return status == that.status && Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(name, that.name) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(verificationId, that.verificationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, mobileNumber, verificationId, status);
    }

    @Override
    public String toString() {
        return "CashPickupBeneficiary{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", verificationId='" + verificationId + '\'' +
                ", status=" + status +
                '}';
    }
}
