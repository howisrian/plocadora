package com.plocadora.projeto.requests;


import lombok.Data;

@Data
public class ClientePutRequestBody {
	private Long id;
    private String nome;
    private String email;
    private String telefone;
}
