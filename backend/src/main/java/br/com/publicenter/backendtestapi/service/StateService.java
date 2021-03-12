package br.com.publicenter.backendtestapi.service;

import br.com.publicenter.backendtestapi.repository.StateRepository;
import br.com.publicenter.backendtestapi.repository.model.State;
import br.com.publicenter.backendtestapi.resource.dto.response.StateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public StateResponse save(State state) {
        return StateResponse.of(stateRepository.save(state));
    }

    public StateResponse update(State state) {
        State customerToBeUpdated = stateRepository.findById(state.getId()).orElseThrow(() -> new EntityNotFoundException(String.format("State with id %s not found", state.getId())));
        customerToBeUpdated.setId(state.getId());
        customerToBeUpdated.setName(state.getName());
        customerToBeUpdated.setCode(state.getCode());
        return StateResponse.of(stateRepository.save(customerToBeUpdated));
    }

    public void delete(Long id) {
        stateRepository.deleteById(id);
    }

    public List<StateResponse> findAllByName(String name) {
        return stateRepository.findAllByNameContainingIgnoreCase(name).stream().map(StateResponse::of).collect(Collectors.toList());
    }

    public List<StateResponse> findAllByCode(String name) {
        return stateRepository.findAllByCodeContainingIgnoreCase(name).stream().map(StateResponse::of).collect(Collectors.toList());
    }

    public List<StateResponse> findAllByNameOrCode(String name, String code) {
        return stateRepository.findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCase(name, code).stream().map(StateResponse::of).collect(Collectors.toList());
    }

    public List<StateResponse> findAll() {
        return stateRepository.findAll().stream().map(StateResponse::of).collect(Collectors.toList());
    }

    public StateResponse findById(Long id) {
        return stateRepository.findById(id)
                .map(StateResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("State with id %s not found", id)));
    }
}