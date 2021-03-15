package br.com.publicenter.backendtestapi.resource;

import br.com.publicenter.backendtestapi.config.MyTokenService;
import br.com.publicenter.backendtestapi.resource.dto.request.LoginRequest;
import br.com.publicenter.backendtestapi.resource.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyTokenService myTokenService;

    @PostMapping
    public ResponseEntity<?> authentication(@RequestBody @Valid LoginRequest request) {
        UsernamePasswordAuthenticationToken loginData = request.of();
        try {
            Authentication authentication = authenticationManager.authenticate(loginData);
            String token = myTokenService.createToken(authentication);
            return ResponseEntity.ok(new LoginResponse(token, "Bearer"));
        } catch (AuthenticationException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
