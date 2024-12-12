package com.projeto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.biblioteca.entity.Cliente;
import com.projeto.biblioteca.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllCliente() {
        return clienteService.getAllCliente();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCLienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.createCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        return ResponseEntity.ok(clienteService.updateCliente(id, updatedCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}

