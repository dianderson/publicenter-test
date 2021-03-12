package br.com.publicenter.backendtestapi.resource.dto.request.city;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateCityRequest extends CityRequest {

}
