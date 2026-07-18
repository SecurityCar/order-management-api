package br.com.vitorcarvalho.order_management_api.modules.items.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcarvalho.order_management_api.modules.items.ItemEntity;
import br.com.vitorcarvalho.order_management_api.modules.items.repositories.ItemRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemRepository itemRepository;

    ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @PostMapping("/")
    public ItemEntity create(@Valid @RequestBody ItemEntity itemEntity) {
        return this.itemRepository.save(itemEntity);
    }
    
}
