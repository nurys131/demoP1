package com.example.demo.mapper;

import com.example.demo.domain.Owner;
import com.example.demo.dto.OwnerDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class OwnerMapper {

    @Autowired
    private ItemMapper itemMapper;

    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    public abstract OwnerDto toDto(Owner owner);

    @AfterMapping
    protected void additionalMappings(@MappingTarget OwnerDto ownerDto, Owner owner) {
        ownerDto.setItems(owner.getItems().stream().map(itemMapper::toDto).collect(Collectors.toList()));
    }

}
