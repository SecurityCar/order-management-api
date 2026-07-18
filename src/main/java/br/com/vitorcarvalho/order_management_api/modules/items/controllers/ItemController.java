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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/items")
@Tag(name = "Item", description = "Item's information")
public class ItemController {
    private ItemRepository itemRepository;
    private ItemUseCase itemUseCase;

    ItemController(ItemRepository itemRepository, ItemUseCase itemUseCase){
        this.itemRepository = itemRepository;
        this.itemUseCase = itemUseCase;
    }

    @PostMapping("/")
    @Operation(summary = "Registration", description = "This function is responsible for recording the items.")
    public ItemEntity create(@Valid @RequestBody ItemEntity itemEntity) {
        return this.itemRepository.save(itemEntity);
    }

    @GetMapping("")
    @Operation(summary = "Listing", description = "This funcion is responsible for listing the items based on a filter.")
    public ResponseEntity<List<ItemEntity>> list(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
        List<ItemEntity> items = itemUseCase.findByFilter(name, category);
        return ResponseEntity.ok(items);
    }
    
    
}
