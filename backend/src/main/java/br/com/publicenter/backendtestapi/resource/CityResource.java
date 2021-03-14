package br.com.publicenter.backendtestapi.resource;

import br.com.publicenter.backendtestapi.repository.model.City;
import br.com.publicenter.backendtestapi.resource.dto.request.city.CreateCityRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.city.UpdateCityRequest;
import br.com.publicenter.backendtestapi.resource.dto.response.CityResponse;
import br.com.publicenter.backendtestapi.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/city")
@RequiredArgsConstructor
public class CityResource {

    private final CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponse save(@RequestBody @Valid CreateCityRequest request) {
        return cityService.save(City.of(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CityResponse update(@PathVariable Long id, @RequestBody @Valid UpdateCityRequest request) {
        return cityService.update(City.of(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }

    @GetMapping("/{id}")
    public CityResponse findById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @GetMapping
    public Page<CityResponse> findAll(Pageable pageable) {
        return cityService.findAll(pageable);
    }

    @GetMapping("/find-by-name")
    public Page<CityResponse> findAllByName(@RequestParam(value = "name") String name, Pageable pageable) {
        return cityService.findAllByName(name, pageable);
    }

    @GetMapping("/find-by-state")
    public Page<CityResponse> findAllByState(@RequestParam(value = "state_id") Long state_id, Pageable pageable) {
        return cityService.findAllByState(state_id, pageable);
    }

    @GetMapping("/find-by-parameters")
    public Page<CityResponse> findAllByNameOrState(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "state_id", required = false) Long state_id, Pageable pageable) {
        return cityService.findAllByNameOrState(name, state_id, pageable);
    }
}
