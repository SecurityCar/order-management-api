package br.com.vitorcarvalho.order_management_api.modules.items.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vitorcarvalho.order_management_api.modules.items.ItemEntity;
import br.com.vitorcarvalho.order_management_api.modules.items.repositories.ItemRepository;

@Service
public class ItemUseCase {
    private ItemRepository itemRepository;

    ItemUseCase(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> findAll(){
        return this.itemRepository.findAll();
    }

    public List<ItemEntity> findByFilter(String name, String category){
        if(name != null){
            return this.itemRepository.findByNameContainingIgnoreCase(name.toUpperCase());
        }
        if(category != null){
            return this.itemRepository.findByCategoryContainingIgnoreCase(category.toUpperCase());
        }
        return this.itemRepository.findAll();
    }
}
