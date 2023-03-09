package com.example.testest.controller;

import com.example.testest.dto.LoginDto;
import com.example.testest.dto.LoginResponseDto;
import com.example.testest.dto.ResponseDto;
import com.example.testest.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        log.info("LoginDto >>>>>>>>>> {}", loginDto.toString());
        LoginResponseDto response = loginService.authenticate(loginDto);
        ResponseDto responseDto = new ResponseDto("200", "ok", response);
        log.info("Response >>>>>>>>>> {}", response);

        HttpHeaders headers = new HttpHeaders();
        headers.add("resultCode", "200");
        headers.add("resultMsg", "OK");

        return ResponseEntity.ok().headers(headers).body(responseDto);
    }
}
