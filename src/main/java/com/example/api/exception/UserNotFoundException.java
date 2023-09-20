package com.example.api.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {

  private final long userId;

  public UserNotFoundException(long userId) {
    super(String.format("The requested user [%d] does not exist", userId));
    this.userId = userId;
  }
}
