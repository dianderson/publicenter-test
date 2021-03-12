package br.com.publicenter.backendtestapi.resource.dto.request.city;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public abstract class CityRequest {
    @NotBlank
    private String name;
    @NotNull
    private Long state_id;
}
