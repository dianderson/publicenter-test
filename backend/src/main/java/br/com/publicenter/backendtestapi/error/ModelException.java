package br.com.publicenter.backendtestapi.error;

import lombok.Data;

import java.time.Instant;

@Data
public class ModelException {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
