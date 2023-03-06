package com.example.demo.repository;

import com.example.demo.domain.Item;
import com.example.demo.domain.Owner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestQuerySerice {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Owner> getModel() {
        Query query = entityManager.createQuery("select o from Owner o");
        List<Owner> lista = query.getResultList();
        entityManager.clear();
        return lista;
    }
}
