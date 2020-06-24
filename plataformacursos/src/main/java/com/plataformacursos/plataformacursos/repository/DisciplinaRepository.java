package com.plataformacursos.plataformacursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.plataformacursos.plataformacursos.model.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina, String> {
		Disciplina findByiddisciplina(long iddiscplina);
}
