package com.example.api.exception;

import lombok.Getter;

@Getter
public class BugStatusNotValidException extends RuntimeException {

  private final String bugStatus;

  public BugStatusNotValidException(String bugStatus) {
    super(String.format("The requested bug status [%s] is not valid", bugStatus.toUpperCase()));
    this.bugStatus = bugStatus;
  }
}
