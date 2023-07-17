package com.plocadora.projeto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.plocadora.projeto.classe.Veiculo;
import com.plocadora.projeto.requests.VeiculoPostRequestBody;
import com.plocadora.projeto.requests.VeiculoPutRequestBody;
import com.plocadora.projeto.service.VeiculoService;
import com.plocadora.projeto.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Component
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/veiculos") //receberá as requisições feitas à URL ex :http://localhost:8080/camisas/requisicao
public class VeiculoController {
	private final DateUtil dateUtil;
    private final VeiculoService veiculoService;
    
    @GetMapping
    public ResponseEntity<List<Veiculo>> list(){
    	log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(veiculoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable long id){
        return ResponseEntity.ok(veiculoService.findByIdOrThrowBadRequestException(id));
    }
    
    @GetMapping(path = "/find")
    public ResponseEntity<List<Veiculo>> findByModelo(@RequestParam(name="nome") String modelo){
        return ResponseEntity.ok(veiculoService.findByModelo(modelo));
    }
    
    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody @Valid VeiculoPostRequestBody veiculoPostRequestBody){
        return new ResponseEntity<>(veiculoService.save(veiculoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	veiculoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody VeiculoPutRequestBody veiculoPutRequestBody){
    	veiculoService.replace(veiculoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}


