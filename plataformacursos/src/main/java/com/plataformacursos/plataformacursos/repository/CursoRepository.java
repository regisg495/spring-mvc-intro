package com.plataformacursos.plataformacursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.plataformacursos.plataformacursos.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	Curso findByidcurso(long idcurso);
}
