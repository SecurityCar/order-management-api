package br.com.vitorcarvalho.order_management_api.modules.items.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.vitorcarvalho.order_management_api.modules.items.ItemEntity;
import br.com.vitorcarvalho.order_management_api.modules.items.dto.PatchItemRequest;
import br.com.vitorcarvalho.order_management_api.modules.items.dto.UpdateItemRequest;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchEntityFromDTO(PatchItemRequest dto, @MappingTarget ItemEntity destity);

    void updateEntityFromDTO(UpdateItemRequest dto, @MappingTarget ItemEntity destiny);
}
