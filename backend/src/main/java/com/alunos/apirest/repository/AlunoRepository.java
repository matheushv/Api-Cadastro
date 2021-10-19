package com.alunos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunos.apirest.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Aluno findById(long id);
	
}
