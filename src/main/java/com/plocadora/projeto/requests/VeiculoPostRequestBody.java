package com.plocadora.projeto.requests;

import javax.validation.constraints.NotEmpty;
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