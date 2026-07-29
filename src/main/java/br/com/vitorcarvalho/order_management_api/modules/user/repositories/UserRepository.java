package br.com.vitorcarvalho.order_management_api.modules.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitorcarvalho.order_management_api.modules.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID>{

    
}
