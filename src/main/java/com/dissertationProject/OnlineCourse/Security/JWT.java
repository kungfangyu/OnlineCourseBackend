package com.dissertationProject.OnlineCourse.Security;

import com.dissertationProject.OnlineCourse.Service.UserService;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWT {
    private static String signKey = "onlineCourseProject";
    private  static  Long expire =  43200000L;

    private final UserService userService;

    @Autowired
    public JWT(UserService userService) {
        this.userService = userService;
    }

    public String generateJwt(String userID) {
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg", "HS256");
        headerClaims.put("typ", "JWT");

        Map<String, Object> payloadClaims = new HashMap<>();
        payloadClaims.put("userID", userID);
        Date expiration = new Date(System.currentTimeMillis() + expire);
        payloadClaims.put("exp", expiration.getTime() / 1000);

        String jwt = Jwts.builder()
                .setHeader(headerClaims)
                .setClaims(payloadClaims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .compact();
        return jwt;

    }

    public String getIdFromJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }

    public static Claims parseJwt(String jwt) {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt);
        Claims claims = jws.getBody();
        return claims;
    }
}
