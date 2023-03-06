package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OwnerDto {

    private String name;
    private String surname;
    private List<ItemDto> items;
}
