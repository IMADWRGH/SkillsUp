package IMADWRGH.MyJob.service;

import IMADWRGH.MyJob.entity.User;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.algorithm.key}")
    private String key;


    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;
    private static final String USERNAME_KEY="USERNAME";

    @PostConstruct
    public void postConstruct(){
        algorithm=Algorithm.HMAC256(key);
    }

    public String generateJwt(User user){
        return JWT.create()
                .withClaim(USERNAME_KEY,user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+(1000L *expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String GetUsername(String token){
        return  JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }
}
