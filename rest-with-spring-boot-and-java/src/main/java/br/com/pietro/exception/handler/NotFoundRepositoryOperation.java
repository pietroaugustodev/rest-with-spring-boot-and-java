package br.com.pietro.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundRepositoryOperation extends RuntimeException {
  public NotFoundRepositoryOperation(String message) {
    super(message);
  }
}
