package br.com.publicenter.backendtestapi.repository;

import br.com.publicenter.backendtestapi.repository.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
    List<State> findAll();

    List<State> findAllByNameContainingIgnoreCase(String name);

    List<State> findAllByCodeContainingIgnoreCase(String code);

    List<State> findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCase(String name, String code);
}