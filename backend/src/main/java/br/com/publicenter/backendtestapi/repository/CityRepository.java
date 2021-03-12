package br.com.publicenter.backendtestapi.repository;

import br.com.publicenter.backendtestapi.repository.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();

    List<City> findAllByNameContainingIgnoreCase(String name);

    List<City> findAllByStateId(Long state_id);

    List<City> findAllByNameContainingIgnoreCaseOrStateId(String name, Long state_id);
}
