package br.com.publicenter.backendtestapi.repository.model;

import br.com.publicenter.backendtestapi.resource.dto.request.city.CreateCityRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.city.UpdateCityRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.state.CreateStateRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.state.UpdateStateRequest;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    @ManyToOne
    private State state;

    public static City of(CreateCityRequest request) {
        var city = new City();
        city.setName(request.getName());
        city.setState(request.getState());
        return city;
    }

    public static City of(Long id, UpdateCityRequest request) {
        var city = new City();
        city.setId(id);
        city.setName(request.getName());
        city.setState(request.getState());
        return city;
    }

}
