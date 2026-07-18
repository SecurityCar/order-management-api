package br.com.vitorcarvalho.order_management_api.modules.items.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.vitorcarvalho.order_management_api.modules.items.ItemEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {
    void updateEntityFromDTO(ItemEntity origem, @MappingTarget ItemEntity destino);
}
