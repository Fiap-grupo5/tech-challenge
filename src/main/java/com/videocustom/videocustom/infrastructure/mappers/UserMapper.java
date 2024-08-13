package com.videocustom.videocustom.infrastructure.mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.videocustom.user.model.UserDTO;
import com.videocustom.user.model.CreateUserDTO;
import com.videocustom.user.model.UpdateUserDTO;
import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.usecases.user.create.UserCreateUseCaseInput;
import com.videocustom.videocustom.application.usecases.user.create.UserCreateUseCaseOutput;
import com.videocustom.videocustom.application.usecases.user.retrieve.get.UserGetByIdUseCaseOutput;
import com.videocustom.videocustom.application.usecases.user.retrieve.list.UserListUseCaseOutput;
import com.videocustom.videocustom.application.usecases.user.update.UserUpdateUseCaseInput;
import com.videocustom.videocustom.application.usecases.user.update.UserUpdateUseCaseOutput;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    UserDTO toDTO(UserGetByIdUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    UserDTO toDTO(UserUpdateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(user.getId().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(user.getCreatedAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(user.getDeletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(user.getUpdatedAt()))")
    UserDTO toDTO(User user);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
    @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
    @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
    UserDTO toDTO(UserCreateUseCaseOutput output);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
    UserDTO toDTO(UserListUseCaseOutput output);

    List<UserDTO> toDTO(List<UserListUseCaseOutput> output);

    UserCreateUseCaseInput fromDTO(CreateUserDTO dto);

    @Mapping(target = "id", source = "userId")
    UserUpdateUseCaseInput fromDTO(String userId, UpdateUserDTO dto);

    default OffsetDateTime mapOffsetDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(instant, java.time.ZoneOffset.UTC);
    }

    default String map(BaseId value) {
        return value.toString();
    }

}
