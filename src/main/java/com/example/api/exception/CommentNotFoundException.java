package com.example.api.exception;

import lombok.Getter;

@Getter
public class CommentNotFoundException extends RuntimeException {

  private final long commentId;

  public CommentNotFoundException(long commentId) {
    super(String.format("The requested comment [%d] does not exist", commentId));
    this.commentId = commentId;
  }
}
