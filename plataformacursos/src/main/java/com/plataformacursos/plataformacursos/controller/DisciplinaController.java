package com.plataformacursos.plataformacursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.plataformacursos.plataformacursos.model.Disciplina;
import com.plataformacursos.plataformacursos.repository.DisciplinaRepository;

@Controller
public class DisciplinaController {
	@Autowired
	private DisciplinaRepository drps;
	
	@RequestMapping(value = "/cadastroDisciplina", method=RequestMethod.GET)
	public String addDisciplines() {
		return "view/curso/cadastroDisciplina";
	}
	@RequestMapping(value = "/cadastroDisciplina", method=RequestMethod.POST)
	public String addDisciplines(Disciplina disciplina) {
		drps.save(disciplina);
		return "view/curso/cadastroDisciplina";
	}
	@RequestMapping("/disciplinas")
	public ModelAndView showDisciplines() {
		ModelAndView mov = new ModelAndView("view/curso/disciplinas");
		Iterable<Disciplina> disciplinas = drps.findAll();
		mov.addObject("disciplinas", disciplinas);
		return mov;
	}
	@RequestMapping("/deletarDisciplina")
	public String deleteDiscipline(long iddisciplina) {
		Disciplina disciplina = drps.findByiddisciplina(iddisciplina);
		drps.delete(disciplina);
		return "redirect:/disciplinas";
	}
	@RequestMapping("/iddisciplina={iddisciplina}")
	public ModelAndView atualizarDisciplina(@PathVariable("iddisciplina") long iddisciplina) {
		Disciplina disciplina = drps.findByiddisciplina(iddisciplina);
		ModelAndView mov = new ModelAndView("view/curso/atualizarDisciplina");
		mov.addObject("disciplinas", disciplina);
		return mov;
	}
	@RequestMapping(value = "/atualizarDisciplina")
	public String editFormDiscipline() {
		return "view/curso/disciplinas";
	}
	@PostMapping(value = "/atualizarDisciplina")
	public String editFormDiscipline(Disciplina disciplina) {
		drps.save(disciplina);
		return "redirect:disciplinas";
	}
}
