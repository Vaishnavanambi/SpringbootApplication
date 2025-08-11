package com.application.SpringbootApplication.Controllers;

import com.application.SpringbootApplication.Services.UserDetailService;
import com.application.SpringbootApplication.TransferObjects.UserDetailReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor
public class UserConfigController {

    private final UserDetailService userDetailService;
    @PutMapping("/register")
    public ResponseEntity<String> registerUSer(@Valid @RequestBody UserDetailReq userDetailReq){
        userDetailService.registerUser(userDetailReq);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);

    }
}
