package com.example.api.mapper;

import com.example.api.dto.CommentDto;
import com.example.api.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

  CommentDto toCommentDto(Comment comment);
}
