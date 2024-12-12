package com.projeto.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.biblioteca.entity.Cliente;
import com.projeto.biblioteca.repository.ClienteRepository;

@Service
public class ClienteService {
	 @Autowired
	    private ClienteRepository clienteRepository;

	    public ClienteService(ClienteRepository clienteRepository) {
	        this.clienteRepository = clienteRepository;
	    }

	    public List<Cliente> getAllCliente() {
	        return clienteRepository.findAll();
	    }

	    public Cliente getClienteById(Long id) {
	        Optional<Cliente> existingCliente = clienteRepository.findById(id);
	        return existingCliente.orElse(null);
	    }

	    public Cliente createCliente(Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    public Cliente updateCliente(Long id, Cliente updatedCliente) {
	        Optional<Cliente> existingCliente = clienteRepository.findById(id);
	        if (existingCliente.isPresent()) {
	            updatedCliente.setId(id);
	            return clienteRepository.save(updatedCliente);
	        }
	        return null;
	    }

	    public boolean deleteCliente(Long id) {
	        Optional<Cliente> existingCliente = clienteRepository.findById(id);
	        if (existingCliente.isPresent()) {
	            clienteRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}



