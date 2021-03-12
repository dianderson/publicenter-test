package br.com.publicenter.backendtestapi.repository.model;

import br.com.publicenter.backendtestapi.resource.dto.request.city.CreateCityRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.city.UpdateCityRequest;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @ManyToOne
    private State state;

    public static City of(CreateCityRequest request) {
        var city = new City();
        var state = new State();
        state.setId(request.getState_id());
        city.setName(request.getName());
        city.setState(state);
        return city;
    }

    public static City of(Long id, UpdateCityRequest request) {
        var city = new City();
        var state = new State();
        state.setId(request.getState_id());
        city.setId(id);
        city.setName(request.getName());
        city.setState(state);
        return city;
    }
}
