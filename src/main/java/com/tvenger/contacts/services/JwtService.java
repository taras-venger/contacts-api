package com.tvenger.contacts.services;

import com.tvenger.contacts.dtos.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("${spring.jwt.secret}")
    private String secret;

    public String generateToken(UserDto user) {
        final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;
        return Jwts.builder()
            .subject(user.getId().toString())
            .claim("email", user.getEmail())
            .claim("name", user.getName())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
            .compact();
    }

}
