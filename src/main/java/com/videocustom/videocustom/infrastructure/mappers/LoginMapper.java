package com.videocustom.videocustom.infrastructure.mappers;

import com.videocustom.videocustom.application.usecases.login.LoginUseCaseInput;
import com.videocustom.videocustom.application.usecases.login.LoginUseCaseOutput;
import com.videocustom.login.model.LoginDTO;
import com.videocustom.login.model.RequestLoginDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    LoginUseCaseInput toUseCaseInput(RequestLoginDTO dto);

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "mapInstantToOffsetDateTime")
    @Mapping(source = "updatedAt", target = "updatedAt", qualifiedByName = "mapInstantToOffsetDateTime")
    @Mapping(source = "deletedAt", target = "deletedAt", qualifiedByName = "mapInstantToOffsetDateTime")
    LoginDTO toDTO(LoginUseCaseOutput output);

    @Named("mapInstantToOffsetDateTime")
    static OffsetDateTime mapInstantToOffsetDateTime(Instant instant) {
        return instant != null ? OffsetDateTime.ofInstant(instant, ZoneOffset.UTC) : null;
    }

    @Named("mapOffsetDateTimeToInstant")
    static Instant mapOffsetDateTimeToInstant(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? offsetDateTime.toInstant() : null;
    }
}

