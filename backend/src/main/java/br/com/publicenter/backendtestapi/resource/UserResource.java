package br.com.publicenter.backendtestapi.resource;

import br.com.publicenter.backendtestapi.repository.model.UserCustomer;
import br.com.publicenter.backendtestapi.resource.dto.request.CreateUserRequest;
import br.com.publicenter.backendtestapi.resource.dto.response.UserResponse;
import br.com.publicenter.backendtestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserResource {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse save(@RequestBody @Valid CreateUserRequest request) {
        return userService.save(UserCustomer.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(@PathVariable Long id, @RequestBody @Valid CreateUserRequest request) {
        return userService.update(UserCustomer.of(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public Page<UserResponse> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }
}
