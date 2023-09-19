package com.example.api.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {

  private Long id;

  private String title;

  private String body;
}
