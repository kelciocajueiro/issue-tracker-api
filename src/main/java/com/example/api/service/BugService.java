package com.example.api.service;

import com.example.api.exception.BugNotFoundException;
import com.example.api.exception.UserNotFoundException;
import com.example.api.mapper.BugMapper;
import com.example.api.model.Bug;
import com.example.api.model.BugStatus;
import com.example.api.model.User;
import com.example.api.model.dto.BugDto;
import com.example.api.model.dto.NewBugDto;
import com.example.api.repository.BugRepository;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BugService {

  private final BugRepository repository;
  private final UserRepository userRepository;
  private final BugMapper mapper;

  @Autowired
  public BugService(BugRepository repository, UserRepository userRepository, BugMapper mapper) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.mapper = mapper;
  }

  public BugDto create(NewBugDto newBugDto) {
    Bug savedBug = repository.save(mapper.newBugDtoToBug(newBugDto));
    return mapper.toBugDto(savedBug);
  }

  public BugDto edit(long bugId, NewBugDto editBugDto) {
    Bug bug = repository.findById(bugId).orElseThrow(() -> new BugNotFoundException(bugId));

    bug.setTitle(editBugDto.title());
    bug.setBody(editBugDto.body());
    bug.setStatus(editBugDto.status());

    bug = repository.save(bug);

    return mapper.toBugDto(bug);
  }

  public void delete(long bugId) {
    repository
        .findById(bugId)
        .ifPresentOrElse(
            repository::delete,
            () -> {
              throw new BugNotFoundException(bugId);
            });
  }

  public Page<BugDto> findAll(Pageable pageable) {
    return repository.findAll(pageable).map(mapper::toBugDto);
  }

  public BugDto findById(long bugId) {
    return repository
        .findById(bugId)
        .map(mapper::toBugDto)
        .orElseThrow(() -> new BugNotFoundException(bugId));
  }

  public BugDto changeBugStatus(Long bugId, BugStatus status) {
    Bug bug = repository.findById(bugId).orElseThrow(() -> new BugNotFoundException(bugId));
    bug.setStatus(status);
    bug = repository.save(bug);

    return mapper.toBugDto(bug);
  }

  public Page<BugDto> findAllResolved(Pageable pageable) {
    return repository.findByStatus(BugStatus.RESOLVED, pageable).map(mapper::toBugDto);
  }

  public BugDto assignBugToUser(Long bugId, Long userId) {
    Bug bug = repository.findById(bugId).orElseThrow(() -> new BugNotFoundException(bugId));
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

    bug.setAssignedUser(user);
    bug = repository.save(bug);

    return mapper.toBugDto(repository.save(bug));
  }
}
