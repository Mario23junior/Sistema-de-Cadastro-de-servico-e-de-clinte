package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
