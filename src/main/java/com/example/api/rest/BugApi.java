package com.example.api.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.api.model.dto.BugDto;
import com.example.api.model.dto.BugRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "1. Bug Endpoints")
public interface BugApi {

  @Operation(
      summary = "Bug creation",
      description =
          "Allows authorized users to initiate the process of reporting and tracking software issues.")
  @ApiResponse(
      responseCode = "201",
      description = "New bug has been successfully created",
      content =
          @Content(
              mediaType = APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = BugDto.class),
              examples =
              @ExampleObject(
                  name = "bug",
                  value =
                      "{\"title\": \"Bug title\", \"body\": \"Bug Description\", \"status\": \"Unresolved\"}")))
  ResponseEntity<BugDto> createBug(
      @Parameter(
              name = "bug",
              description = "Title, body and status of the bug",
              required = true,
              content =
                  @Content(
                      mediaType = APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = BugRequestDto.class),
                      examples =
                          @ExampleObject(
                              name = "bug",
                              value =
                                  "{\"title\": \"Bug title\", \"body\": \"Bug Description\", \"status\": \"Unresolved\"}")))
          BugRequestDto newBugDto);

  @Operation(
      summary = "Bug edit",
      description = "Allows authorized users to modify and update existing bug reports.")
  @ApiResponse(
      responseCode = "200",
      description = "New bug has been successfully modified",
      content =
          @Content(
              mediaType = APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = BugDto.class)))
  @ApiResponse(responseCode = "400", description = "The requested bug does not exist")
  ResponseEntity<BugDto> editBug(
      @Parameter(name = "bugId", description = "Bug ID", in = ParameterIn.PATH, example = "1")
          long bugId,
      BugRequestDto editBugDto);
}
