package com.Sir.Module.PayloadDto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserRegistrationDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "FirstName should have at least 2 characters")
    private String firstName;

    @NotEmpty
    @Size(min = 2, message = "LastName should have at least 2 characters")
    private String lastName;
    private String email;
    private String mobile;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String password;
}
