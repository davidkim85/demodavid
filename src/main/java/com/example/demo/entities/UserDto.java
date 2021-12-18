package com.example.demo.entities;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    @NotEmpty(message="Enter your First Name")
    private String firstName;
    @NotEmpty(message="Enter your Last Name")
    private String lastName;
    @NotEmpty(message="Enter a Username")
    private String username;
    @NotEmpty(message="Enter an Email")
    @Email(message="Email is not valid")
    private String email;
    @NotEmpty(message="Enter a password")
    private String password;
    @NotEmpty(message="Confirm your password")
    private String confirmPassword;

}
