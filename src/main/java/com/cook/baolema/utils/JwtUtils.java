package com.cook.baolema.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 徐亮
 */
public class JwtUtils {
    /*
    * 设置过期时间为30分钟
    * */
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    /*
    * jwt密钥
    * */
    private static final String SECRET = "baolemaorderingsystem";

    /*
    * 生成jwt字符串，5分钟后过期
    * jwt:json web token
    * @param phoneNumber
    * */
    public static String createToken(Map<String,String> claimMap) {
        //当前时间戳加上设定毫秒数
        Date expiration = new Date(System.currentTimeMillis()+EXPIRE_TIME*1000);
        //设置jwt头部
        Map<String,Object> map = new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        //创建token
        JWTCreator.Builder builder = JWT.create();
        //使用lambda创建payload
        claimMap.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //添加头部
        return builder.withHeader(map)
                //设置过期时间
                .withExpiresAt(expiration)
                //设置签名解码算法
                .sign(Algorithm.HMAC256(SECRET));

    }

    /**
     * @description 验证token
     **/
    public static DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }

}



