package com.rabf.productservice.api.controller.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientRequest {

    @NotNull(message="First Name cannot be null")
    private String firstname;

    @NotNull(message="Last Name cannot be null")
    private String lastname;

    @NotNull(message="Member since date cannot be null")
    private String memberSince;

    @NotNull(message="Birthdate cannot be null")
    private String birthdate;

    @NotNull(message="Category cannot be null")
    private String category;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
