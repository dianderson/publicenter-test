package br.com.publicenter.backendtestapi.repository.model;

import br.com.publicenter.backendtestapi.resource.dto.request.state.CreateStateRequest;
import br.com.publicenter.backendtestapi.resource.dto.request.state.UpdateStateRequest;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class State {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private String code;

    public static State of(CreateStateRequest request) {
        var state = new State();
        state.setName(request.getName());
        state.setCode(request.getCode());
        return state;
    }

    public static State of(Long id,UpdateStateRequest request) {
        var state = new State();
        state.setId(id);
        state.setName(request.getName());
        state.setCode(request.getCode());
        return state;
    }
}
