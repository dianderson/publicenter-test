package br.com.publicenter.backendtestapi.resource.dto.request.state;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public abstract class StateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String code;
}
