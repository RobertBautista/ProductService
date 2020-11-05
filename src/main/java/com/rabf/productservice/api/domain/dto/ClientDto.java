package com.rabf.productservice.api.domain.dto;

import com.rabf.productservice.api.enums.EClientCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1377253643777389190L;

    private String firstname;

    private String lastname;

    private Date memberSince;

    private Date birthdate;

    private EClientCategory category;

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

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public EClientCategory getCategory() {
        return category;
    }

    public void setCategory(EClientCategory category) {
        this.category = category;
    }
}
