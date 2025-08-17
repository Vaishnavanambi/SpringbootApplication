package com.application.SpringbootApplication.Controllers;

import com.application.SpringbootApplication.Interfaces.UserDetailInterface;
import com.application.SpringbootApplication.Data.UserDetailData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserConfigController {

    private final UserDetailInterface userDetailInterface;
    @PutMapping("/register")
    public ResponseEntity<String> registerUSer(@Valid @RequestBody UserDetailData userDetailData){
        userDetailInterface.registerUser(userDetailData);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);

    }
}
