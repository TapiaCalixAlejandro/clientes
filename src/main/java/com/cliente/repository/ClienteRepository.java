package com.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cliente.model.Cliente;

@Repository
public interface ClienteRepository  extends CrudRepository<Cliente, Integer>{

}
