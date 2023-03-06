package com.example.demo.services;

import com.example.demo.domain.Owner;
import com.example.demo.dto.OwnerDto;
import com.example.demo.mapper.OwnerMapper;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.repository.TestQuerySerice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;
    private OwnerMapper ownerMapper;
    private TestMaping testMaping;
    private TestQuerySerice testQuerySerice;

    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper, TestMaping testMaping, TestQuerySerice testQuerySerice) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
        this.testMaping = testMaping;
        this.testQuerySerice = testQuerySerice;
    }

    public List<OwnerDto> getOwners() {
        return ownerRepository.findAll().stream().map(ownerMapper::toDto).collect(Collectors.toList());
    }

    public List<OwnerDto> getOwnersToString() {
        List<Owner> lista = ownerRepository.findAll();
        String test = lista.get(0).toString();
        return lista.stream().map(ownerMapper::toDto).collect(Collectors.toList());
    }

    public List<OwnerDto> getOwnersError() {
        List<Owner> owners = testQuerySerice.getModel();
        return testMaping.ownersMapToDto(owners);
    }



}
