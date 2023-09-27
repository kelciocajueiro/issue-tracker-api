package com.example.api.dto;

import com.example.api.model.BugStatus;

public record NewBugDto(String title, String body, BugStatus status) {}
