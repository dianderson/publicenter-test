package br.com.publicenter.backendtestapi.service;

import br.com.publicenter.backendtestapi.repository.UserRepository;
import br.com.publicenter.backendtestapi.repository.model.UserCustomer;
import br.com.publicenter.backendtestapi.resource.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse save(UserCustomer userCustomer) {
        return UserResponse.of(userRepository.save(userCustomer));
    }

    public UserResponse update(UserCustomer userCustomer) {
        UserCustomer userToBeUpdated = userRepository.findById(userCustomer.getId()).orElseThrow(() -> new EntityNotFoundException(String.format("User with id %s not found", userCustomer.getId())));
        userToBeUpdated.setId(userCustomer.getId());
        userToBeUpdated.setUsername(userCustomer.getUsername());
        userToBeUpdated.setPassword(userCustomer.getPassword());
        userToBeUpdated.setRoles(userCustomer.getRoles());
        return UserResponse.of(userRepository.save(userToBeUpdated));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


    public Page<UserResponse> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserResponse::of);
    }

    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(UserResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User with id %s not found", id)));
    }
}
