package com.example.api.rest;

import com.example.api.model.dto.CommentDto;
import com.example.api.model.dto.NewCommentDto;
import com.example.api.service.CommentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/bugs/{id}/comments")
public class CommentController {

  private final CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping
  public ResponseEntity<CommentDto> create(@PathVariable long id, @RequestBody NewCommentDto newCommentDto) {
    CommentDto createdComment = commentService.create(id, newCommentDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
  }

  @DeleteMapping("/{commentId}")
  public ResponseEntity<Void> delete(@PathVariable long id, @PathVariable long commentId) {
    commentService.delete(id, commentId);
    return ResponseEntity.noContent().build();
  }
}
