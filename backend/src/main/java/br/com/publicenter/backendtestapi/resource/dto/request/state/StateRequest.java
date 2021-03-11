package br.com.publicenter.backendtestapi.resource.dto.request.state;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public abstract class StateRequest {

    @NotNull
    private String name;
    @NotNull
    private String code;

}
