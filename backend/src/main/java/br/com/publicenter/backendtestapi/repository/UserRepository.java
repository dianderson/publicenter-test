package br.com.publicenter.backendtestapi.repository;

import br.com.publicenter.backendtestapi.repository.model.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserCustomer, Long> {
    Optional<UserCustomer> findByUsername(String username);
}
