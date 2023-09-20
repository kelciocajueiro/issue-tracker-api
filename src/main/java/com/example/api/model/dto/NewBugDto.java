package com.example.api.model.dto;

import com.example.api.model.BugStatus;

public record NewBugDto(String title, String body, BugStatus status) {}
