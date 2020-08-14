package com.project.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.Repository.ClienteRepository;
import com.project.Repository.ServicoPrestadoRepository;
import com.project.model.entity.Cliente;
import com.project.model.entity.ServicoPrestado;
import com.project.rest.dto.ServicoPrestadoDTO;
 
@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {
		
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository repository;
	
	public ServicoPrestadoController(ClienteRepository clienteRepository,ServicoPrestadoRepository repository) {
		this.clienteRepository = clienteRepository;
		this.repository = repository;
 	}
     
	@PostMapping
	public  ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		  LocalDate dataFormater = LocalDate.parse(dto.getData(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		  Integer idCliente = dto.getIdCliente();
		  
	     Cliente cliente = 
	    		    clienteRepository
	                .findById(idCliente)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cliente inesistente"));
	     
	    
	   ServicoPrestado servicoPrestado = new ServicoPrestado();
	   servicoPrestado.setDescricao(dto.getDescricao());
	   servicoPrestado.setData(dataFormater);
	   servicoPrestado.setCliente(cliente);
	   //servicoPrestado.setValor();
	   return null;
	}
   	 
}





