package br.com.publicenter.backendtestapi.repository.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    @Override
    public String getAuthority() {
        return this.roleName;
    }

    public static List<Role> of(String roleName) {
        var role = new Role();
        role.setRoleName(roleName);
        List<Role> roles = new ArrayList<>();
        switch (roleName) {
            case Const.ROLE_ADMIN: {
                role.setId(1L);
                roles.add(role);
                return roles;
            }
            case Const.ROLE_MASTER: {
                role.setId(2L);
                roles.add(role);
                return roles;
            }
            case Const.ROLE_CUSTOMER: {
                role.setId(3L);
                roles.add(role);
                return roles;
            }
            default: {
                return null;
            }
        }
    }
}
