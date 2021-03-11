package br.com.publicenter.backendtestapi.resource;

import br.com.publicenter.backendtestapi.repository.model.City;
import br.com.publicenter.backendtestapi.resource.dto.request.city.CreateCityRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.city.UpdateCityRequest;
import br.com.publicenter.backendtestapi.resource.dto.response.CityResponse;
import br.com.publicenter.backendtestapi.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<CityResponse> findAll() {
        return cityService.findAll();
    }
}
