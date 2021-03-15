package br.com.publicenter.backendtestapi.config;

import br.com.publicenter.backendtestapi.repository.model.UserCustomer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyTokenService {

    @Value("${backend.jwt.expiration}")
    private String expiration;

    @Value("${backend.jwt.secret}")
    private String secret;

    public String createToken(Authentication authentication) {
        UserCustomer logged = (UserCustomer) authentication.getPrincipal();
        Date toDay = new Date();
        Date expirationDate = new Date(toDay.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("Publicenter API")
                .setSubject(logged.getId().toString())
                .setIssuedAt(toDay)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
