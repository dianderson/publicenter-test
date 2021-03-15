package br.com.publicenter.backendtestapi.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class BackendApiControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorModel> entityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        var modelException = new ErrorModel();
        modelException.setTimestamp(Instant.now());
        modelException.setStatus(HttpStatus.NOT_FOUND.value());
        modelException.setError("Msg de ERRO - VERIFICAR");
        modelException.setMessage(ex.getMessage());
        modelException.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(modelException);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorModel> dataIntegrityViolation(DataIntegrityViolationException ex, HttpServletRequest request) {
        var modelException = new ErrorModel();
        modelException.setTimestamp(Instant.now());
        modelException.setStatus(HttpStatus.BAD_REQUEST.value());
        modelException.setError("Msg de ERRO - VERIFICAR");
        modelException.setMessage(ex.getMessage());
        modelException.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(modelException);
    }

}
