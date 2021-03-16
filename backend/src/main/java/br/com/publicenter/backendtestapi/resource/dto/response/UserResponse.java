package br.com.publicenter.backendtestapi.resource.dto.response;

import br.com.publicenter.backendtestapi.repository.model.UserCustomer;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String roleName;

    public static UserResponse of(UserCustomer userCustomer) {
        var response = new UserResponse();
        response.setId(userCustomer.getId());
        response.setUsername(userCustomer.getUsername());
        response.setRoleName(userCustomer.getRoles().toString());
        return response;
    }
}
