package br.com.publicenter.backendtestapi.service;

import br.com.publicenter.backendtestapi.repository.StateRepository;
import br.com.publicenter.backendtestapi.repository.model.State;
import br.com.publicenter.backendtestapi.resource.dto.response.StateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    @CacheEvict(value = "stateCache")
    public StateResponse save(State state) {
        return StateResponse.of(stateRepository.save(state));
    }

    @CacheEvict(value = "stateCache")
    public StateResponse update(State state) {
        State customerToBeUpdated = stateRepository.findById(state.getId()).orElseThrow(() -> new EntityNotFoundException(String.format("State with id %s not found", state.getId())));
        customerToBeUpdated.setId(state.getId());
        customerToBeUpdated.setName(state.getName());
        customerToBeUpdated.setCode(state.getCode());
        return StateResponse.of(stateRepository.save(customerToBeUpdated));
    }

    @CacheEvict(value = "stateCache")
    public void delete(Long id) {
        stateRepository.deleteById(id);
    }

    @Cacheable(value = "stateCache")
    public Page<StateResponse> findAllByName(String name, Pageable pageable) {
        return stateRepository.findAllByNameContainingIgnoreCase(name, pageable).map(StateResponse::of);
    }

    @Cacheable(value = "stateCache")
    public Page<StateResponse> findAllByCode(String name, Pageable pageable) {
        return stateRepository.findAllByCodeContainingIgnoreCase(name, pageable).map(StateResponse::of);
    }

    @Cacheable(value = "stateCache")
    public Page<StateResponse> findAllByNameOrCode(String name, String code, Pageable pageable) {
        return stateRepository.findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCase(name, code, pageable).map(StateResponse::of);
    }

    @Cacheable(value = "stateCache")
    public Page<StateResponse> findAll(Pageable pageable) {
        return stateRepository.findAll(pageable).map(StateResponse::of);
    }

    @Cacheable(value = "stateCache")
    public StateResponse findById(Long id) {
        return stateRepository.findById(id)
                .map(StateResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("State with id %s not found", id)));
    }
}
