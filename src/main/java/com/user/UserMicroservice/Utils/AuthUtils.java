package com.user.UserMicroservice.Utils;

import com.user.UserMicroservice.User.Entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class AuthUtils {

    @Value("$jwt.secretKey")
    private String SecretKey;

    private SecretKey getKey() {
        return  Keys.hmacShaKeyFor(SecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public  String generateAccessToken(UserEntity user){
        return Jwts.builder()
                .claim("UserId",user.getId())
                .signWith(getKey())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*10))
                .compact();
    }

    public  String getUserEmail(String token){
        Claims claims =Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
