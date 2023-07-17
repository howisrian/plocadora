package com.plocadora.projeto.requests;

import lombok.Data;

@Data
public class VeiculoPutRequestBody {
	Long id;
	String modelo;
    String marca;
    String placa;
	int ano;
	int lugares;
	float valor;
}