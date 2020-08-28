package com.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByUsername(String username);
	
	//realizara um select no banco de dados e
	/*verificar se existe algum outro 
	/*usuario com dados iguais
	 */
	// select count(*) > 0 from usuario where username = :login
	boolean existsByUsername(String username);
  
}
