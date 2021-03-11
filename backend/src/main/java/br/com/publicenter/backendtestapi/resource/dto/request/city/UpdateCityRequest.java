package br.com.publicenter.backendtestapi.resource.dto.request.city;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class UpdateCityRequest extends CityRequest {

}
