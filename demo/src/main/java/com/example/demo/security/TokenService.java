package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String segredo;

    public String geradorToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            String token = JWT.create()
                    .withIssuer("auth-hisig")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(genExpiracaoToken())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Errro na geração do token", exception);
        }

    }

    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.require(algorithm)
                    .withIssuer("auth-hisig")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";
        }
    }

    private Instant genExpiracaoToken(){
        //tempo de expiração do token: 5 horas
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-03:00"));
    }
}
