package com.alunos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunos.apirest.repository.AlunoRepository;

import com.alunos.apirest.models.Aluno;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api/cadastro")
public class AlunoResource {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/aluno/{id}")
	public Aluno listaAlunoUnico(@PathVariable(value="id") long id){
		return alunoRepository.findById(id);
	}
	
	@PostMapping("/aluno")
	public Aluno salvaAluno(@RequestBody Aluno aluno) {
		
		return alunoRepository.save(aluno);
		
	}
	
	
	@DeleteMapping("/aluno")
	public void deletaAluno(@RequestBody Aluno aluno) {
		
		alunoRepository.delete(aluno);
		
	}
	
	@PutMapping("/aluno")
	public Aluno atualizaAluno(@RequestBody Aluno aluno) {
		
		return alunoRepository.save(aluno);
		
	}

}
