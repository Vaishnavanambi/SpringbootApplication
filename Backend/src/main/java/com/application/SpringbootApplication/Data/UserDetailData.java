package com.application.SpringbootApplication.Data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailData {
    @JsonProperty("name")
    @NotBlank(message = "name cannot be empty")
    private String name;

    @JsonProperty("userName")
    @NotBlank(message = "username cannot be empty")
    private String userName;

    @JsonProperty("email")
    @NotBlank(message = "email cannot be empty")
    @Email(message = "Enter valid email")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
