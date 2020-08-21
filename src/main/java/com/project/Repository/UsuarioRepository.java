package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
