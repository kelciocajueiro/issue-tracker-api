package com.example.api.mapper;

import com.example.api.model.Comment;
import com.example.api.model.dto.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

  CommentDto toCommentDto(Comment comment);
}
