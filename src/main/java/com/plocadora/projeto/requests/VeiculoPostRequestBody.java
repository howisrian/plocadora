package com.plocadora.projeto.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
public class VeiculoPostRequestBody {

	@NotEmpty(message = "Veiculo não pode estar faltando.")
	private String marca;
	private String modelo;
    private String placa;
	private int ano;
	private int lugares;
	private float valor;
}