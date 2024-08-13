package com.videocustom.videocustom.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.videocustom.videocustom.application.repositories.UserRepository;
import com.videocustom.videocustom.application.usecases.user.create.UserCreateUseCase;
import com.videocustom.videocustom.application.usecases.user.create.DefaultUserCreateUseCase;
import com.videocustom.videocustom.application.usecases.user.delete.UserDeleteUseCase;
import com.videocustom.videocustom.application.usecases.user.delete.DefaultUserDeleteUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.get.UserGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.get.DefaultUserGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.list.UserListUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.list.DefaultUserListUseCase;
import com.videocustom.videocustom.application.usecases.user.update.UserUpdateUseCase;
import com.videocustom.videocustom.application.usecases.user.update.DefaultUserUpdateUseCase;
import com.videocustom.videocustom.infrastructure.persistence.repositories.UserJPARepository;
import com.videocustom.videocustom.infrastructure.repositories.UserRepositoryImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserRepository userRepository(final UserJPARepository userJPARepository) {
        return new UserRepositoryImpl(userJPARepository);
    }

    @Bean
    public UserCreateUseCase userCreateUseCase(final UserRepository userRepository) {
        return new DefaultUserCreateUseCase(userRepository);
    }

    @Bean
    public UserListUseCase userListUseCase(final UserRepository userRepository) {
        return new DefaultUserListUseCase(userRepository);
    }

    @Bean
    public UserGetByIdUseCase userGetByIdUseCase(final UserRepository userRepository) {
        return new DefaultUserGetByIdUseCase(userRepository);
    }

    @Bean
    public UserDeleteUseCase userDeleteUseCase(final UserRepository userRepository) {
        return new DefaultUserDeleteUseCase(userRepository);
    }

    @Bean
    public UserUpdateUseCase userUpdateUseCase(final UserRepository userRepository) {
        return new DefaultUserUpdateUseCase(userRepository);
    }
}
