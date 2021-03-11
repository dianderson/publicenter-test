package br.com.publicenter.backendtestapi.resource.dto.request.city;

import br.com.publicenter.backendtestapi.repository.model.State;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public abstract class CityRequest {

    @NotNull
    private String name;
    @NotNull
    private State state;

}
