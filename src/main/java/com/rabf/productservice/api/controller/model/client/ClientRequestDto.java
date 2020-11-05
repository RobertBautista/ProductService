package com.rabf.productservice.api.controller.model.client;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClientRequestDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1377253643777389197L;

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

}
