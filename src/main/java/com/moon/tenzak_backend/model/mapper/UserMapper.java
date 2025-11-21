package com.moon.tenzak_backend.model.mapper;

import com.moon.tenzak_backend.model.dto.UserDto;
import com.moon.tenzak_backend.model.dto.authDto.AuthenticationResponseDto;
import com.moon.tenzak_backend.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
    AuthenticationResponseDto toUserDto(User user);
    User toUserEntity(AuthenticationResponseDto user);
}



