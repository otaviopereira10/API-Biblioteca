package com.projeto.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.biblioteca.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}

