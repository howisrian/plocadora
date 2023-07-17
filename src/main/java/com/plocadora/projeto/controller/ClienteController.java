package com.plocadora.projeto.controller;

import java.time.LocalDateTime;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.plocadora.projeto.classe.Cliente;
import com.plocadora.projeto.requests.ClientePostRequestBody;
import com.plocadora.projeto.service.ClienteService;
import com.plocadora.projeto.util.DateUtil;

import com.plocadora.projeto.requests.ClientePutRequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/clientes") //receberá as requisições feitas à URL ex :http://localhost:8080/camisas/requisicao
public class ClienteController {
	private final DateUtil dateUtil;
    private final ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> list(){
    	log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(clienteService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id){
        return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));
    }
    
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClientePostRequestBody clientePostRequestBody){
        return new ResponseEntity<>(clienteService.save(clientePostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
		clienteService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ClientePutRequestBody clientePutRequestBody){
    	clienteService.replace(clientePutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}