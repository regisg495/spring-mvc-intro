package com.plataformacursos.plataformacursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.plataformacursos.plataformacursos.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String> {
	
	Professor findByidprofessor(long idprofessor);
	
}
