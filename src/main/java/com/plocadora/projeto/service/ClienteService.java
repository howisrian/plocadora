package com.plocadora.projeto.service;

import org.springframework.web.server.ResponseStatusException;

import com.plocadora.projeto.classe.Cliente;
import com.plocadora.projeto.repository.ClienteRepository;

import com.plocadora.projeto.requests.ClientePostRequestBody;
import com.plocadora.projeto.requests.ClientePutRequestBody;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public List<Cliente> listAll() {
    	return clienteRepository.findAll();
    }
	
	public Cliente findByIdOrThrowBadRequestException(long id) {
        return clienteRepository.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Não encontrado"));
 	    }
    
	public Cliente save(ClientePostRequestBody clientePostRequestBody) {
    	return clienteRepository.save(Cliente.builder()
    			.nome(clientePostRequestBody.getNome())
    			.email(clientePostRequestBody.getEmail())
                .telefone(clientePostRequestBody.getTelefone())
    			.build());
    }

	public void delete(long id) {
		clienteRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}

	public void replace(ClientePutRequestBody clientePutRequestBody) {
        Cliente savedCliente = findByIdOrThrowBadRequestException(clientePutRequestBody.getId());
        Cliente cliente = Cliente.builder()
                .id(savedCliente.getId())
                .nome(clientePutRequestBody.getNome())
    			.email(clientePutRequestBody.getEmail())
                .telefone(clientePutRequestBody.getTelefone())      
                .build();

        clienteRepository.save(cliente);
    }
	     
	    
}