package br.com.publicenter.backendtestapi.resource.dto.response;

import br.com.publicenter.backendtestapi.repository.model.State;
import lombok.Data;

@Data
public class StateResponse {

    private Long id;
    private String name;
    private String code;

    public static StateResponse of(State state) {
        var stateResponse = new StateResponse();
        stateResponse.setId(state.getId());
        stateResponse.setName(state.getName());
        stateResponse.setCode(state.getCode());
        return stateResponse;
    }

}
