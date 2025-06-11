package com.sena.authentication.JWT;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAunthenticationFilter extends OncePerRequestFilter {
    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        final String token = req.getHeader("Authorization");
    }

    private String getToken(HttpServletRequest req){
        final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(authHeader) && !authHeader.startsWith("Bearer ")) return null;
        return authHeader.substring(7);
    }
}
