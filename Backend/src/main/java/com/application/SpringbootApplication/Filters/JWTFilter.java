package com.application.SpringbootApplication.Filters;

import com.application.SpringbootApplication.Data.LogInData;
import com.application.SpringbootApplication.Utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        if(!request.getServletPath().equals("/user/logIn")){
            filterChain.doFilter(request,response);
            return;
        }
        LogInData logInData = objectMapper.readValue(request.getInputStream(),LogInData.class);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(logInData.getUserName(),logInData.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if(authentication.isAuthenticated()){
            String jwtToken = jwtUtils.generateToken(authentication.getName(),10);
            response.setHeader("Authorization",jwtToken);
        }
    }
}
