package br.com.publicenter.backendtestapi.repository;

import br.com.publicenter.backendtestapi.repository.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
    Page<State> findAll(Pageable pageable);

    Page<State> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<State> findAllByCodeContainingIgnoreCase(String code, Pageable pageable);

    Page<State> findAllByNameContainingIgnoreCaseOrCodeContainingIgnoreCase(String name, String code, Pageable pageable);
}
