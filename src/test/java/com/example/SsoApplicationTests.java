package com.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
class SsoApplicationTests {

    @Test
    void contextLoads() {

        HashMap<String,Object> map = new HashMap<>() ;
        Calendar instance= Calendar.getInstance();
        instance.add(Calendar.SECOND,200);


        String token=JWT. create( )
                . withHeader(map) //header
                . withClaim("userId",21) //payload
                . withClaim(" username"," xiaochen")
                .withExpiresAt(instance.getTime())
                .  sign ( Algorithm. HMAC256("!Q@W#E$R")); //签名
        System.out.println("token拿到了"+token);



        JWTVerifier jwtVerifier = JWT.require(Algorithm. HMAC256("!Q@W#E$R")).build();
        DecodedJWT verify = jwtVerifier.verify(token);
        System. out. println(verify .getClaims() .get("userid").asInt());
        System. out. println(verify. getClaims().get( "username" ).asString() ) ;
        System.out.println("过期时间"+verify.getExpiresAt());





    }

}
