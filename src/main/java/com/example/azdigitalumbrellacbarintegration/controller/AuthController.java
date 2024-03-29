package com.example.azdigitalumbrellacbarintegration.controller;

import com.example.azdigitalumbrellacbarintegration.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/auth")
public class AuthController {

    private final AuthService authService;


    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        tokenService.refreshToken(request, response);
    }



}
