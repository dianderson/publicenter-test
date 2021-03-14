package br.com.publicenter.backendtestapi.service;

import br.com.publicenter.backendtestapi.repository.CityRepository;
import br.com.publicenter.backendtestapi.repository.model.City;
import br.com.publicenter.backendtestapi.resource.dto.response.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    @CacheEvict(value = "cityCache", allEntries = true)
    public CityResponse save(City city) {
        return CityResponse.of(cityRepository.save(city));
    }

    @CacheEvict(value = "cityCache", allEntries = true)
    public CityResponse update(City city) {
        City customerToBeUpdated = cityRepository.findById(city.getId()).orElseThrow(() -> new EntityNotFoundException(String.format("City with id %s not found", city.getId())));
        customerToBeUpdated.setId(city.getId());
        customerToBeUpdated.setName(city.getName());
        customerToBeUpdated.setState(city.getState());
        return CityResponse.of(cityRepository.save(customerToBeUpdated));
    }

    @CacheEvict(value = "cityCache", allEntries = true)
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Cacheable(value = "cityCache")
    public Page<CityResponse> findAllByName(String name, Pageable pageable) {
        return cityRepository.findAllByNameContainingIgnoreCase(name, pageable).map(CityResponse::of);
    }

    @Cacheable(value = "cityCache")
    public Page<CityResponse> findAllByState(Long state_id, Pageable pageable) {
        return cityRepository.findAllByStateId(state_id, pageable).map(CityResponse::of);
    }

    @Cacheable(value = "cityCache")
    public Page<CityResponse> findAllByNameOrState(String name, Long state_id, Pageable pageable) {
        return cityRepository.findAllByNameContainingIgnoreCaseOrStateId(name, state_id, pageable).map(CityResponse::of);
    }

    @Cacheable(value = "cityCache")
    public Page<CityResponse> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable).map(CityResponse::of);
    }

    @Cacheable(value = "cityCache")
    public CityResponse findById(Long id) {
        return cityRepository.findById(id)
                .map(CityResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("City with id %s not found", id)));
    }
}
