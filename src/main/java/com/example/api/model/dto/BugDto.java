package com.example.api.model.dto;

import com.example.api.model.BugStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BugDto {

  private String title;

  private String body;

  private BugStatus status;

  @JsonInclude(Include.NON_NULL)
  private String assignedUser;
}
