package com.project.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.Exception.UsuarioCadastradoException;
import com.project.model.entity.Usuario;
import com.project.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
 public class UsuarioController {
	
	  private UsuarioService service;
          
     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public void salvar(@RequestBody @Valid Usuario usuario ) {
    	 
    	 try {
        	 service.salvar(usuario);			
		} catch (UsuarioCadastradoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage() );
 		}
     }
}
