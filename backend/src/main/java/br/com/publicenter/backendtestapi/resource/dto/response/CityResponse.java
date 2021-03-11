package br.com.publicenter.backendtestapi.resource.dto.response;

import br.com.publicenter.backendtestapi.repository.model.City;
import br.com.publicenter.backendtestapi.repository.model.State;
import lombok.Data;

@Data
public class CityResponse {

    private Long id;
    private String name;
    private State state;

    public static CityResponse of(City city) {
        var cityResponse = new CityResponse();
        cityResponse.setId(city.getId());
        cityResponse.setName(city.getName());
        cityResponse.setState(city.getState());
        return cityResponse;
    }
}
