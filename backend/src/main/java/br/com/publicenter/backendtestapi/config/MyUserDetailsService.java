package br.com.publicenter.backendtestapi.config;

import br.com.publicenter.backendtestapi.repository.UserRepository;
import br.com.publicenter.backendtestapi.repository.model.UserCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserCustomer> user = userRepository.findByUsername(s);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }
}
