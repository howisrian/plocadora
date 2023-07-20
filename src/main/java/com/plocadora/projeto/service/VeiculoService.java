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
    
    public List<Veiculo> findByMarca(String marca) {
    	return VeiculoRepository.findByMarca(marca);
    }
    
    public Veiculo findByIdOrThrowBadRequestException(long id) {
        return VeiculoRepository.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Camisa Não encontrada"));
 	    }
    
    @Transactional
    public Veiculo save(VeiculoPostRequestBody VeiculoPostRequestBody) {
    	return VeiculoRepository.save(Veiculo.builder()
    			.marca(VeiculoPostRequestBody.getMarca())
    			.modelo(VeiculoPostRequestBody.getModelo())
                .placa(VeiculoPostRequestBody.getPlaca())
                .ano(VeiculoPostRequestBody.getAno())
                .lugares(VeiculoPostRequestBody.getLugares())
                .valor(VeiculoPostRequestBody.getValor())
    			.build());
    
    }

	public void delete(long id) {
		VeiculoRepository.delete(findByIdOrThrowBadRequestException(id));
		
	}
	
	public void replace(VeiculoPutRequestBody veiculoPutRequestBody) {
        Veiculo savedVeiculo = findByIdOrThrowBadRequestException(veiculoPutRequestBody.getId());
        Veiculo veiculo = Veiculo.builder()
                .id(savedVeiculo.getId())
                .marca(veiculoPutRequestBody.getMarca())
    			.modelo(veiculoPutRequestBody.getModelo())
                .placa(veiculoPutRequestBody.getPlaca())
                .ano(veiculoPutRequestBody.getAno())
                .lugares(veiculoPutRequestBody.getLugares())
                .valor(veiculoPutRequestBody.getValor())
    			.build();

        VeiculoRepository.save(veiculo);
    }
	     
	    
}
