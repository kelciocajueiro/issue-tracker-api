package com.example.api.service;

import com.example.api.dto.CommentDto;
import com.example.api.dto.NewCommentDto;
import com.example.api.exception.BugNotFoundException;
import com.example.api.exception.CommentNotFoundException;
import com.example.api.mapper.CommentMapper;
import com.example.api.model.Bug;
import com.example.api.model.Comment;
import com.example.api.repository.BugRepository;
import com.example.api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  private final CommentRepository commentRepository;
  private final BugRepository bugRepository;
  private final CommentMapper commentMapper;

  @Autowired
  public CommentService(CommentRepository commentRepository, BugRepository bugRepository, CommentMapper commentMapper) {
    this.commentRepository = commentRepository;
    this.bugRepository = bugRepository;
    this.commentMapper = commentMapper;
  }

  // Create a new comment for a bug
  public CommentDto create(long bugId, NewCommentDto newCommentDto) {
    Bug bug = bugRepository.findById(bugId).orElseThrow(() -> new BugNotFoundException(bugId));

    Comment comment = new Comment();
    comment.setTitle(newCommentDto.title());
    comment.setBody(newCommentDto.body());
    comment.setBug(bug);

    comment = commentRepository.save(comment);

    return commentMapper.toCommentDto(comment);
  }

  public void delete(long bugId, long commentId) {
    Bug bug = bugRepository.findById(bugId).orElseThrow(() -> new BugNotFoundException(bugId));

    Comment comment =
        commentRepository
            .findById(commentId)
            .orElseThrow(() -> new CommentNotFoundException(commentId));

    commentRepository.delete(comment);
  }
}
