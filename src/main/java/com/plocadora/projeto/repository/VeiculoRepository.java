package com.plocadora.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plocadora.projeto.classe.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	List<Veiculo> findByMarca(String marca);
	
}
