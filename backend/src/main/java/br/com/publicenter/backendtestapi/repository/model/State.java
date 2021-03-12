package br.com.publicenter.backendtestapi.repository.model;

import br.com.publicenter.backendtestapi.resource.dto.request.state.CreateStateRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.state.UpdateStateRequest;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String name;
    @NotBlank
    @Column(unique = true)
    private String code;

    public static State of(CreateStateRequest request) {
        var state = new State();
        state.setName(request.getName());
        state.setCode(request.getCode());
        return state;
    }

    public static State of(Long id, UpdateStateRequest request) {
        var state = new State();
        state.setId(id);
        state.setName(request.getName());
        state.setCode(request.getCode());
        return state;
    }
}
