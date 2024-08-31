package com.vektorel.kutuphane.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtManager {

    @Value("${jwt.key}")
    String secretKey;

    public Optional<String> generateToken(Long id){
        String token="";
        Long expireTime =1000*60*60*24l; // 1gün

        try {
            token= JWT.create()
                    .withClaim("id",id)
                    .withClaim("mail","vektorel@gmail.com")
                    .withIssuer("vektorel")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis()+expireTime))
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);

        }catch (Exception e){
            System.out.println("** token oluşturulurken hata oluştu **");
            e.printStackTrace();
            return Optional.empty();
        }
    }


    public Optional<Long> validToken(String token){

        try {
            Algorithm algorithm= Algorithm.HMAC512(secretKey);

            JWTVerifier jwtVerifier=JWT
                    .require(algorithm)
                    .withIssuer("vektorel").build();

            DecodedJWT decodedJWT= jwtVerifier.verify(token);

            if (decodedJWT==null){
                return Optional.empty();
            }
            Optional<Long> id = Optional.of(decodedJWT.getClaim("id").asLong());
            return id;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("** token acilirken hata");
            return Optional.empty();
        }


    }




}
