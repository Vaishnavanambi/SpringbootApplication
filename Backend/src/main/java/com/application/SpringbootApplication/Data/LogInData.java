package com.application.SpringbootApplication.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogInData {
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;
}
