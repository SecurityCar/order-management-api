package br.com.vitorcarvalho.order_management_api.modules.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.vitorcarvalho.order_management_api.modules.exceptions.UserNotFoundException;
import br.com.vitorcarvalho.order_management_api.modules.user.UserEntity;
import br.com.vitorcarvalho.order_management_api.modules.user.dto.CreateUserRequest;
import br.com.vitorcarvalho.order_management_api.modules.user.dto.DeleteUserRequest;
import br.com.vitorcarvalho.order_management_api.modules.user.dto.PatchUserRequest;
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

    public List<UserEntity> findByFilter(String name){
        if(name != null){
            return this.userRepository.findByNameContainingIgnoreCase(name);
        }
        return this.userRepository.findAll();
    }

    public UserEntity patch(UUID id, PatchUserRequest dto){
        UserEntity user = this.userRepository.findById(id).orElseThrow(
            () -> new UserNotFoundException()
        );
        this.userMapper.patchUserFromDTO(dto, user);
        return this.userRepository.save(user);
    }

    public void delete(UUID id, DeleteUserRequest dto){
        UserEntity user = this.userRepository.findById(id).orElseThrow(
            () -> new UserNotFoundException()
        );

        user.setActive(false);
        this.userRepository.save(user);
    }
}
