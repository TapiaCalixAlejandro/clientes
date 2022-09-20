package com.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.model.Cliente;
import com.cliente.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/index")
	public List<Cliente> index() {
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente show(@PathVariable Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
	}
	
}
