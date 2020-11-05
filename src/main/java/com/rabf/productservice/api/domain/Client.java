package com.rabf.productservice.api.domain;

import com.rabf.productservice.api.enums.EClientCategory;
import com.rabf.productservice.api.utils.DateUtils;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1377253643777389190L;

    private String firstname;

    private String lastname;

    private Date memberSince;

    private Date birthdate;

    private EClientCategory category;

    public boolean isTodayBirthdate() {
        return DateUtils.isSameCurrentDayAndMonth(birthdate);
    }

}
