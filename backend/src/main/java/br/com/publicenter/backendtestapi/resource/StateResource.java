package br.com.publicenter.backendtestapi.resource;

import br.com.publicenter.backendtestapi.repository.model.State;
import br.com.publicenter.backendtestapi.resource.dto.request.state.CreateStateRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.state.UpdateStateRequest;
import br.com.publicenter.backendtestapi.resource.dto.response.StateResponse;
import br.com.publicenter.backendtestapi.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public StateResponse findById(@PathVariable Long id) {
        return stateService.findById(id);
    }

    @GetMapping
    public List<StateResponse> findAll() {
        return stateService.findAll();
    }
}
