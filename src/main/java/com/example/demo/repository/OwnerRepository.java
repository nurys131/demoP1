package com.example.demo.repository;

import com.example.demo.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
