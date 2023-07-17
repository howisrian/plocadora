package com.plocadora.projeto.requests;

import lombok.Data;

@Data
public class ClientePostRequestBody {
    private String nome;
    private String email;
    private String telefone;
}
   