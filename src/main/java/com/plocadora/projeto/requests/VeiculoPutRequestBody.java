package com.plocadora.projeto.requests;

import lombok.Data;

@Data
public class VeiculoPutRequestBody {
	Long id;
    String marca;
	String modelo;
    String placa;
	int ano;
	int lugares;
	float valor;
}