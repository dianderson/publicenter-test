package br.com.publicenter.backendtestapi.config;

import br.com.publicenter.backendtestapi.repository.UserRepository;
import br.com.publicenter.backendtestapi.repository.model.UserCustomer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationToken extends OncePerRequestFilter {

    private final MyTokenService myTokenService;
    private final UserRepository userRepository;

    public AuthenticationToken(MyTokenService myTokenService, UserRepository userRepository) {
        this.myTokenService = myTokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recoverToken(request);
        boolean valid = myTokenService.isValidToken(token);
        if (valid) {
            authenticateUser(token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateUser(String token) {
        Long userId = myTokenService.getIdUsuario(token);
        UserCustomer user = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
