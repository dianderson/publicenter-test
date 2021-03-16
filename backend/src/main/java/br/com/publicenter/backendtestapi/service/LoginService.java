package br.com.publicenter.backendtestapi.service;

import br.com.publicenter.backendtestapi.resource.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RequiredArgsConstructor
public class LoginService {

    public ResponseEntity<LoginResponse> auth(UsernamePasswordAuthenticationToken request) {
        return null;
    }
}
