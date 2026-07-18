package br.com.vitorcarvalho.order_management_api.modules.items.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcarvalho.order_management_api.modules.items.ItemEntity;
import br.com.vitorcarvalho.order_management_api.modules.items.repositories.ItemRepository;
import br.com.vitorcarvalho.order_management_api.modules.items.useCases.ItemUseCase;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemRepository itemRepository;
    private ItemUseCase itemUseCase;

    ItemController(ItemRepository itemRepository, ItemUseCase itemUseCase){
        this.itemRepository = itemRepository;
        this.itemUseCase = itemUseCase;
    }

    @PostMapping("/")
    public ItemEntity create(@Valid @RequestBody ItemEntity itemEntity) {
        return this.itemRepository.save(itemEntity);
    }

    @GetMapping("")
    public ResponseEntity<List<ItemEntity>> list(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
        List<ItemEntity> items = itemUseCase.findByFilter(name, category);
        return ResponseEntity.ok(items);
    }
    
    
}
