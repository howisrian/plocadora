package com.plocadora.projeto.service;

import org.springframework.web.server.ResponseStatusException;
import com.plocadora.projeto.classe.Veiculo;
import com.plocadora.projeto.repository.VeiculoRepository;
import com.plocadora.projeto.requests.VeiculoPostRequestBody;
import com.plocadora.projeto.requests.VeiculoPutRequestBody;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VeiculoService {
	

	private final VeiculoRepository VeiculoRepository;
    
    public List<Veiculo> listAll() {
    	return VeiculoRepository.findAll();
    }
    
    public List<Veiculo> findByModelo(String modelo) {
    	return VeiculoRepository.findByModelo(modelo);
    }
    
    public Veiculo findByIdOrThrowBadRequestException(long id) {
        return VeiculoRepository.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veiculo Não encontrado"));
 	    }
    
    @Transactional
    public Veiculo save(VeiculoPostRequestBody VeiculoPostRequestBody) {
    	return VeiculoRepository.save(Veiculo.builder()
    			.modelo(VeiculoPostRequestBody.getModelo())
    			.marca(VeiculoPostRequestBody.getMarca())
                .placa(VeiculoPostRequestBody.getPlaca())
                .ano(VeiculoPostRequestBody.getAno())
                .lugares(VeiculoPostRequestBody.getLugares())
                .valor(VeiculoPostRequestBody.getValor())
    			.build());
    }

	public void delete(long id) {
		VeiculoRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}
	
	public void replace(VeiculoPutRequestBody VeiculoPutRequestBody) {
        Veiculo savedVeiculo = findByIdOrThrowBadRequestException(VeiculoPutRequestBody.getId());
        Veiculo Veiculo = Veiculo.builder()
                .modelo(VeiculoPuttRequestBody.getModelo())
    			.marca(VeiculoPuttRequestBody.getMarca())
                .placa(VeiculoPuttRequestBody.getPlaca())
                .ano(VeiculoPuttRequestBody.getAno())
                .lugares(VeiculoPuttRequestBody.getLugares())
                .valor(VeiculoPuttRequestBody.getValor())
                .build();

        VeiculoRepository.save(Veiculo);
    }
	     
	    
}
