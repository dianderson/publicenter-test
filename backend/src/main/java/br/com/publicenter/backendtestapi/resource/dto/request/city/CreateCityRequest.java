package br.com.publicenter.backendtestapi.resource.dto.request.city;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreateCityRequest extends CityRequest {

}
