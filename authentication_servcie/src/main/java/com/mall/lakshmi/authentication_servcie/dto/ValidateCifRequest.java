//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ValidateCifRequest {
    private @NotBlank(
            message = "Cif number cannot be blank"
    ) @Pattern(
            regexp = "CIF\\d{5,10}",
            message = "CIF number must start with 'CIF' followed by 5-10 digits"
    ) String cifNumber;

    public ValidateCifRequest(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getCifNumber() {
        return this.cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String toString() {
        return "ValidateCifRequest{cifNumber='" + this.cifNumber + "'}";
    }
}
