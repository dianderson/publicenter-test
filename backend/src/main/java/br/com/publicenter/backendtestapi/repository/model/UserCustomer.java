package br.com.publicenter.backendtestapi.repository.model;

import br.com.publicenter.backendtestapi.resource.dto.request.CreateUserRequest;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class UserCustomer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public static UserCustomer of(CreateUserRequest request) {
        var userCustomer = new UserCustomer();
        userCustomer.setUsername(request.getUsername());
        userCustomer.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        userCustomer.setRoles(Role.of(request.getRoleName()));
        return userCustomer;
    }

    public static UserCustomer of(Long id, CreateUserRequest request) {
        var userCustomer = new UserCustomer();
        userCustomer.setId(id);
        userCustomer.setUsername(request.getUsername());
        userCustomer.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        userCustomer.setRoles(Role.of(request.getRoleName()));
        return userCustomer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
