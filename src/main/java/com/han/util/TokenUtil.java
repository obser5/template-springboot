package com.han.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

/**
 * token工具类，用来生成和解析token
 *
 * @author hmj
 * @since 2021/9/9
 */
public class TokenUtil {
    /**
     * token有效时间10分钟
     */
    private static final long TOKEN_LIFE = 10 * 60 * 1000;
    /**
     * 密钥
     */
    private static final String TOKEN_SECRET = "xxx";

    /**
     * 根据username password生成token
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public static String createToken(String username, String password) {
        Date nowDate = new Date();
        Date lastDate = new Date(nowDate.getTime() + TOKEN_LIFE);
        // 头部信息，hashmap声明时最好添加初始容量，避免resize影响性能
        HashMap<String, Object> header = new HashMap<>(16);
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        // 根据密钥和载荷生成token
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        String token = JWT.create()
                // 头部信息
                .withHeader(header)
                // 载荷
                .withClaim("username", username)
                .withClaim("password", password)

                .withSubject("end")
                .withAudience("front")
                .withIssuedAt(nowDate)
                .withExpiresAt(lastDate)
                .sign(algorithm);
        return token;
    }

    /**
     * 解析token
     *
     * @param token 需要验证的令牌
     * @return
     */
    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
