package com.example.api.rest;

import com.example.api.model.dto.BugDto;
import com.example.api.model.dto.BugRequestDto;
import com.example.api.service.BugService;
import com.example.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/bugs")
public class BugController implements BugApi {

  private final BugService bugService;
  private final CommentService commentService;

  @Autowired
  public BugController(BugService bugService, CommentService commentService) {
    this.bugService = bugService;
    this.commentService = commentService;
  }

  @PostMapping
  public ResponseEntity<BugDto> createBug(@RequestBody BugRequestDto newBugDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bugService.create(newBugDto));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<BugDto> editBug(@PathVariable long id, @RequestBody BugRequestDto editBugDto) {
    return ResponseEntity.ok(bugService.edit(id, editBugDto));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteBug(@PathVariable long id) {
    bugService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public Page<BugDto> findAllBugs(Pageable pageable) {
    return bugService.findAll(pageable);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<BugDto> findSpecificBug(@PathVariable long id) {
    return ResponseEntity.ok(bugService.findById(id));
  }

//  @PostMapping(value = "/{id}/comments")
//  public ResponseEntity<Comm>

}
