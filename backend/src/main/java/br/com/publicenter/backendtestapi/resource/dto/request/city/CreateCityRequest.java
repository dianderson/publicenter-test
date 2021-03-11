package br.com.publicenter.backendtestapi.resource.dto.request.city;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class CreateCityRequest extends CityRequest {

}
