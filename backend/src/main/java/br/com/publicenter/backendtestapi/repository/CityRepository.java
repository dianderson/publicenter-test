package br.com.publicenter.backendtestapi.repository;

import br.com.publicenter.backendtestapi.repository.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    Page<City> findAll(Pageable pageable);

    Page<City> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<City> findAllByStateId(Long state_id, Pageable pageable);

    Page<City> findAllByNameContainingIgnoreCaseOrStateId(String name, Long state_id, Pageable pageable);
}
