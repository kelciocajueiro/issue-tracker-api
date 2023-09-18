package com.example.api.exception;

import lombok.Getter;

@Getter
public class BugNotFoundException extends RuntimeException {

    private final long bugId;

    public BugNotFoundException(long bugId) {
        super(String.format("The requested bug [%d] does not exist", bugId));
        this.bugId = bugId;
    }

}
