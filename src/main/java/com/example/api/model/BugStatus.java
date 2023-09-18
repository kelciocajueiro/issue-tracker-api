package com.example.api.model;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum BugStatus {

    RESOLVED("Resolved"),
    UNRESOLVED("Unresolved");

    private final String displayName;

    BugStatus(String displayName) {
        this.displayName = displayName;
    }

    public static BugStatus from(String displayName) {
        return Arrays.stream(BugStatus.values())
                .filter(bugStatus -> StringUtils.equalsIgnoreCase(bugStatus.displayName, displayName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No such BugStatus: " + displayName));
    }

}
