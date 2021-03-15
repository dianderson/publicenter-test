package br.com.publicenter.backendtestapi.resource;

import br.com.publicenter.backendtestapi.repository.model.State;
import br.com.publicenter.backendtestapi.resource.dto.request.state.CreateStateRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.state.UpdateStateRequest;
import br.com.publicenter.backendtestapi.resource.dto.response.StateResponse;
import br.com.publicenter.backendtestapi.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/state")
@RequiredArgsConstructor
public class StateResource {

    private final StateService stateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StateResponse save(@RequestBody @Valid CreateStateRequest request) {
        return stateService.save(State.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StateResponse update(@PathVariable Long id, @RequestBody @Valid UpdateStateRequest request) {
        return stateService.update(State.of(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        stateService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StateResponse findById(@PathVariable Long id) {
        return stateService.findById(id);
    }

    @GetMapping
    public Page<StateResponse> findAll(Pageable pageable) {
        return stateService.findAll(pageable);
    }

    @GetMapping("/find-by-name")
    public Page<StateResponse> findAllByName(@RequestParam(value = "name") String name, Pageable pageable) {
        return stateService.findAllByName(name, pageable);
    }

    @GetMapping("/find-by-code")
    public Page<StateResponse> findAllByCode(@RequestParam(value = "code") String code, Pageable pageable) {
        return stateService.findAllByCode(code, pageable);
    }

    @GetMapping("/find-by-parameters")
    public Page<StateResponse> findAllByNameOrCode(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "code", required = false) String code, Pageable pageable) {
        return stateService.findAllByNameOrCode(name, code, pageable);
    }

}
