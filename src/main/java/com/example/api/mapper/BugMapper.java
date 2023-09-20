package com.example.api.mapper;

import com.example.api.model.Bug;
import com.example.api.model.dto.BugDto;
import com.example.api.model.dto.NewBugDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BugMapper {

    @Mapping(source = "assignedUser.username", target = "assignedUser")
    BugDto toBugDto(Bug bug);

    Bug newBugDtoToBug(NewBugDto newBugDto);

}
