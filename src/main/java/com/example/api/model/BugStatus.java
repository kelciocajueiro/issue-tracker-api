package com.example.api.model;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.DELEGATING;

import com.example.api.exception.BugStatusNotValidException;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum BugStatus {

  RESOLVED("Resolved"),
  UNRESOLVED("Unresolved");

  private final String status;

  BugStatus(String status) {
    this.status = status;
  }

  @JsonCreator(mode = DELEGATING)
  public static BugStatus from(String status) {
    return Arrays.stream(BugStatus.values())
        .filter(bugStatus -> StringUtils.equalsIgnoreCase(bugStatus.status, status))
        .findFirst()
        .orElseThrow(() -> new BugStatusNotValidException(status));
  }
}
