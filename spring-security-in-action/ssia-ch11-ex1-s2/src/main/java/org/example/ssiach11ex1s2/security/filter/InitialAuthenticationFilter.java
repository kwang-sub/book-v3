package org.example.ssiach11ex1s2.security.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import org.example.ssiach11ex1s2.security.authentication.OtpAuthentication;
import org.example.ssiach11ex1s2.security.authentication.UsernamePasswordAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class InitialAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager manager;
    @Value("${jwt.signing.key}")
    private String signingKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String code = request.getHeader("code");
        if (code == null) {
            UsernamePasswordAuthentication auth = new UsernamePasswordAuthentication(username, password);
            manager.authenticate(auth);
        } else {
            OtpAuthentication auth = new OtpAuthentication(username, code);
            manager.authenticate(auth);

            SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder()
                    .setClaims(Map.of("username", username))
                    .signWith(key)
                    .compact();

            response.setHeader("Authorization", jwt);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/login");
    }
}
