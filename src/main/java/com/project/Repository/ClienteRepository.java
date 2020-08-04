package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
