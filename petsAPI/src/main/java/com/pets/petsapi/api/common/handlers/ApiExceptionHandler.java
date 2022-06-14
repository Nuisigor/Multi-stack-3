package com.pets.petsapi.api.common.handlers;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.pets.petsapi.api.common.dtos.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private final PropertyNamingStrategies.SnakeCaseStrategy snakeCaseStrategy = new PropertyNamingStrategies.SnakeCaseStrategy();

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    var body = ErrorResponse.builder()
            .status(status.value())
            .error(status.getReasonPhrase())
            .cause(ex.getClass().getSimpleName())
            .message("Houveram erros de validação")
            .timestamp(LocalDateTime.now())
            .errors(convertFieldErrors(ex.getBindingResult().getFieldErrors()))
            .build();

    return new ResponseEntity<>(body, status);
  }

  private Map<String, List<String>> convertFieldErrors(List<FieldError> fieldErrors){
    var errors = new HashMap<String, List<String>>();

    fieldErrors.stream().forEach(fieldError -> {
      var field = snakeCaseStrategy.translate(fieldError.getField());
      if(errors.containsKey(field)){
        errors.get(field).add(fieldError.getDefaultMessage());
      } else {
        var errorList = new ArrayList<String>();
        errorList.add(fieldError.getDefaultMessage());
        errors.put(field, errorList);
      }
    });

    return errors;
  }
}
