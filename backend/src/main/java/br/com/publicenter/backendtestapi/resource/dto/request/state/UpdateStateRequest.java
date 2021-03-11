package br.com.publicenter.backendtestapi.resource.dto.request.state;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class UpdateStateRequest extends StateRequest {

}
