package br.com.publicenter.backendtestapi.resource.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String roleName;
    private String token;
    private String type;

    public LoginResponse(String username, String roleName, String token, String type) {
        this.username=username;
        this.roleName=roleName;
        this.token = token;
        this.type = type;
    }
}
