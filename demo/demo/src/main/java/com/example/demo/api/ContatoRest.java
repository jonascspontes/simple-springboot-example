package com.example.demo.api;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Contato;
import com.example.demo.repository.ContatoRepository;

@Controller
public class ContatoRest {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping(value = "/api/contatos")
	@ResponseBody
	public List<Contato> listarContatos(){
		return contatoRepository.findAll();		
	}
	
	@GetMapping(value = "/api/contatos/{id}")
	@ResponseBody
	public Contato recuperarContato(
			@PathVariable(required = true) String id){
		return contatoRepository.findById(BigInteger.valueOf(Long.parseLong(id))).get();	
	}
	
	@PostMapping(value = "/api/contatos")
	@ResponseBody
	public Contato incluirContato(
			@RequestBody(required = true) Contato contato){
		Contato contatoGravado = contatoRepository.save(contato);
		return contatoGravado;		
	}
	
	@DeleteMapping(value = "/api/contatos/{id}")
	@ResponseBody
	public ResponseEntity<String> excluirContato(
			@PathVariable(required = true) String id){
		contatoRepository.deleteById(BigInteger.valueOf(Long.parseLong(id)));
		
		return ResponseEntity.ok("Contato excluído com sucesso!");
	}
	
	
}
