package br.com.publicenter.backendtestapi.service;

import br.com.publicenter.backendtestapi.repository.CityRepository;
import br.com.publicenter.backendtestapi.repository.model.City;
import br.com.publicenter.backendtestapi.resource.dto.response.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public CityResponse save(City city) {
        return CityResponse.of(cityRepository.save(city));
    }

    public CityResponse update(City city) {
        City customerToBeUpdated = cityRepository.findById(city.getId()).orElseThrow(() -> new EntityNotFoundException(String.format("City with id %s not found", city.getId())));
        customerToBeUpdated.setId(city.getId());
        customerToBeUpdated.setName(city.getName());
        customerToBeUpdated.setState(city.getState());
        return CityResponse.of(cityRepository.save(customerToBeUpdated));
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    public List<CityResponse> findAllByName(String name) {
        return cityRepository.findAllByNameContainingIgnoreCase(name).stream().map(CityResponse::of).collect(Collectors.toList());
    }

    public List<CityResponse> findAllByState(Long state_id) {
        return cityRepository.findAllByStateId(state_id).stream().map(CityResponse::of).collect(Collectors.toList());
    }

    public List<CityResponse> findAllByNameOrState(String name, Long state_id) {
        return cityRepository.findAllByNameContainingIgnoreCaseOrStateId(name, state_id).stream().map(CityResponse::of).collect(Collectors.toList());
    }

    public List<CityResponse> findAll() {
        return cityRepository.findAll().stream().map(CityResponse::of).collect(Collectors.toList());
    }

    public CityResponse findById(Long id) {
        return cityRepository.findById(id)
                .map(CityResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("City with id %s not found", id)));
    }
}
