package com.application.SpringbootApplication.TransferObjects;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailReq {
    @JsonProperty("userName")
    @NotBlank(message = "username cannot be empty")
    private String userName;

    @JsonProperty("password")
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
