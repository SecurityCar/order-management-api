package br.com.vitorcarvalho.order_management_api.modules.user.service;

import org.springframework.stereotype.Service;

import br.com.vitorcarvalho.order_management_api.modules.user.UserEntity;
import br.com.vitorcarvalho.order_management_api.modules.user.dto.CreateUserRequest;
import br.com.vitorcarvalho.order_management_api.modules.user.mappers.UserMapper;
import br.com.vitorcarvalho.order_management_api.modules.user.repositories.UserRepository;

@Service
public class UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    UserService(UserMapper userMapper, UserRepository userRepository){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserEntity create(CreateUserRequest dto){
        UserEntity user = this.userMapper.toEntity(dto);
        return this.userRepository.save(user);
    }
}
