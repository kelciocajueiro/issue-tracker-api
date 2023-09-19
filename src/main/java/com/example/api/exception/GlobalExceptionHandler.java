package com.example.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleGlobalException(Exception e) {
    return ResponseEntity.internalServerError().body(e.getMessage());
  }

  @ExceptionHandler({
    BugNotFoundException.class,
    BugStatusNotValidException.class,
    CommentNotFoundException.class
  })
  public ResponseEntity<String> handleBugException(RuntimeException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }
}
