package com.plocadora.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plocadora.projeto.classe.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
