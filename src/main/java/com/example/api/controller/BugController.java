package com.example.api.controller;

import com.example.api.dto.BugDto;
import com.example.api.dto.NewBugDto;
import com.example.api.model.BugStatus;
import com.example.api.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/bugs")
public class BugController {

  private final BugService bugService;

  @Autowired
  public BugController(BugService bugService) {
    this.bugService = bugService;
  }

  @PostMapping
  public ResponseEntity<BugDto> createBug(@RequestBody NewBugDto newBugDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bugService.create(newBugDto));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<BugDto> editBug(@PathVariable long id, @RequestBody NewBugDto editBugDto) {
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

  @PutMapping("/{id}/resolve")
  public ResponseEntity<BugDto> markBugAsResolved(@PathVariable long id) {
    return ResponseEntity.ok(bugService.changeBugStatus(id, BugStatus.RESOLVED));
  }

  @PutMapping("/{id}/unresolve")
  public ResponseEntity<BugDto> markBugAsUnresolved(@PathVariable long id) {
    return ResponseEntity.ok(bugService.changeBugStatus(id, BugStatus.UNRESOLVED));
  }

  @GetMapping("/resolved")
  public Page<BugDto> findAllResolved(Pageable pageable) {
    return bugService.findAllResolved(pageable);
  }

  @PutMapping("/{id}/assign/{userId}")
  public ResponseEntity<BugDto> assignBugToUser(@PathVariable Long id, @PathVariable Long userId) {
    return ResponseEntity.ok(bugService.assignBugToUser(id, userId));
  }

}
