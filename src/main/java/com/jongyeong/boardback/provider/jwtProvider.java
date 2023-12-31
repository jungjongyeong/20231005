package com.jongyeong.boardback.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class jwtProvider {
    
    @Value("${secret-key}")
    private String secretkey;

    public String create(String email) {

        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.ES256, secretkey)
            .setSubject(email).setIssuedAt(new java.util.Date()).setExpiration(expiredDate)
            .compact();

            return jwt;

    }

    public String validate(String jwt){

        Claims claims = null;

        try {
            claims = Jwts.parser().setSigningKey(secretkey)
            .parseClaimsJws(jwt).getBody();
        } catch(Exception exception){
            exception.printStackTrace();
            return null;
        }

        return claims.getSubject();
    }
}
