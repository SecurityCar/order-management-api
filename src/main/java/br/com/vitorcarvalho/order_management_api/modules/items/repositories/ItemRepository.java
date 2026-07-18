package br.com.vitorcarvalho.order_management_api.modules.items.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitorcarvalho.order_management_api.modules.items.ItemEntity;
import java.util.List;


public interface ItemRepository extends JpaRepository<ItemEntity, UUID>{
    List<ItemEntity> findByNameContainingIgnoreCase(String name);
    List<ItemEntity> findByCategoryContainingIgnoreCase(String category);
    
}
