package com.plocadora.projeto.classe;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String modelo;
    String marca;
    String placa;
	int ano;
	int lugares;
	float valor;
}