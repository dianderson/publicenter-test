package br.com.publicenter.backendtestapi.resource.dto.request.state;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateStateRequest extends StateRequest {

}
