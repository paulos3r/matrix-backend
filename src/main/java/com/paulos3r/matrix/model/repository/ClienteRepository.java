package com.paulos3r.matrix.model.repository;

import com.paulos3r.matrix.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
