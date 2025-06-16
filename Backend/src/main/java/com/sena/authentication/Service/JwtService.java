package com.sena.authentication.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    public String getToken(UserDetails user) {
        return generateToken(new HashMap<>(),user);
    }

    private String generateToken(HashMap<String, Object> extraClaims,UserDetails user) {

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(getExpirationDate())
                .signWith(getKey()) // El algoritmo ya está implícito en la clave
                .compact();

    }

    private Date getExpirationDate() {
        return new Date(System.currentTimeMillis() + jwtExpiration);
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes); // Ya está asociado con HS256
    }

    public boolean validateToken(String token, UserDetails user) {
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    private Claims getAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

}

