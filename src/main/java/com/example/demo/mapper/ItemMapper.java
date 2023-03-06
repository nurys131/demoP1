package com.example.demo.mapper;

import com.example.demo.domain.Item;
import com.example.demo.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ItemMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "value", source = "value")
    public abstract ItemDto toDto(Item item);

}
