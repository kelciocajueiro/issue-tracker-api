package com.example.api.service;

import com.example.api.exception.BugNotFoundException;
import com.example.api.mapper.BugMapper;
import com.example.api.model.Bug;
import com.example.api.model.dto.BugDto;
import com.example.api.model.dto.BugRequestDto;
import com.example.api.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BugService {

  private final BugRepository bugRepository;
  private final BugMapper bugMapper;

  @Autowired
  public BugService(BugRepository bugRepository, BugMapper bugMapper) {
    this.bugRepository = bugRepository;
    this.bugMapper = bugMapper;
  }

  public BugDto create(BugRequestDto newBugDto) {
    Bug savedBug = bugRepository.save(bugMapper.newBugDtoToBug(newBugDto));
    return bugMapper.toBugDto(savedBug);
  }

  public BugDto edit(long bugId, BugRequestDto editBugDto) {
    Bug bug = bugRepository.findById(bugId).orElseThrow(() -> new BugNotFoundException(bugId));

    bug.setTitle(editBugDto.getTitle());
    bug.setBody(editBugDto.getBody());
    bug.setStatus(editBugDto.getStatus());

    bug = bugRepository.save(bug);

    return bugMapper.toBugDto(bug);
  }

  public void delete(long bugId) {
    bugRepository
        .findById(bugId)
        .ifPresentOrElse(
            bugRepository::delete,
            () -> {
              throw new BugNotFoundException(bugId);
            });
  }

  public Page<BugDto> findAll(Pageable pageable) {
    return bugRepository.findAll(pageable).map(bugMapper::toBugDto);
  }

  public BugDto findById(long bugId) {
    return bugRepository.findById(bugId)
        .map(bugMapper::toBugDto)
        .orElseThrow(() -> new BugNotFoundException(bugId));
  }
}
