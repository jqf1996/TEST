package com.example.jwtutils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Map;

public class jwtutils {

private static final String SING="safsdfj";


    public static String getToken (Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); //默认7天过期
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        //payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime())//指定令牌过期时间
                .sign(Algorithm.HMAC256(SING));//sign
        return token;
    }
/**.
 由验证token合法性
 9 public static DecodedJWT verify(String token){
 return JWT . require(Algorithm. HMAC256( SING) ) .build().verify(token);
 //
 *获取token信息方法
 */
//        public static DecodedJWT getTokenInfo(string token){
//            DecodedJWT. verify ■JWT. require (Aigorithm. HMAC256 (SING)).bui1d().verify(token);
//            return verify;
//        }

    }
