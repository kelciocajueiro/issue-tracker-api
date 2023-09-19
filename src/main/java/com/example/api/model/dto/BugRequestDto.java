package com.example.api.model.dto;

import com.example.api.model.BugStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BugRequestDto {

  private String title;
  
  private String body;

  private BugStatus status;
}
