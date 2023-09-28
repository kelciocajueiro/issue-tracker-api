package com.example.api.model;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.DELEGATING;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum Priority {
  
  CRITICAL("Critical"),
  HIGH("High"),
  MEDIUM("Medium"),
  LOW("Low");

  private final String description;

  Priority(String description) {
    this.description = description;
  }

  @JsonCreator(mode = DELEGATING)
  public static Priority from(String description) {
    return Arrays.stream(Priority.values())
        .filter(priority -> StringUtils.equalsIgnoreCase(priority.description, description))
        .findFirst()
        .orElse(null);
  }
}
