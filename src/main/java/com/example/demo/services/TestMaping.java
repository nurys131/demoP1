package com.example.demo.services;

import com.example.demo.domain.Item;
import com.example.demo.domain.Owner;
import com.example.demo.dto.OwnerDto;
import com.example.demo.mapper.OwnerMapper;
import com.example.demo.repository.TestQuerySerice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestMaping {

    private OwnerMapper ownerMapper;
    private TestQuerySerice testQuerySerice;

    public TestMaping(OwnerMapper ownerMapper, TestQuerySerice testQuerySerice) {
        this.ownerMapper = ownerMapper;
        this.testQuerySerice = testQuerySerice;
    }

    public List<OwnerDto> ownersMapToDto(List<Owner> onwers) {
        return onwers.stream().map(ownerMapper::toDto).collect(Collectors.toList());
    }

}
