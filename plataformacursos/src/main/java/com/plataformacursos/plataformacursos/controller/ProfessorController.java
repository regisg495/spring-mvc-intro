package com.plataformacursos.plataformacursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.plataformacursos.plataformacursos.model.Professor;
import com.plataformacursos.plataformacursos.repository.ProfessorRepository;

@Controller
public class ProfessorController {
	@Autowired
	ProfessorRepository prps;
	
	@RequestMapping(value= "/cadastroProfessor", method=RequestMethod.GET)
	public String addProfessor() {
		return "view/curso/cadastroProfessor";
	}
	@RequestMapping(value= "/cadastroProfessor", method=RequestMethod.POST)
	public String adddProfessor(Professor professor) {
		prps.save(professor);
		return "redirect:/cadastroProfessor";
	}
	@RequestMapping("/professores")
	public ModelAndView showProfessors() {
		ModelAndView mov = new ModelAndView("view/curso/professores");
		Iterable<Professor> professores = prps.findAll();
		mov.addObject("professores", professores);
		return mov;
	}
	@RequestMapping("/idprofessor={idprofessor}")
	public ModelAndView atualizarProfessor(@PathVariable("idprofessor") long idprofessor) {
		Professor professor = prps.findByidprofessor(idprofessor);
		ModelAndView mov = new ModelAndView("view/curso/atualizarProfessor");
		mov.addObject("professor", professor);
		return mov;
	}
	@RequestMapping(value= "/atualizarProfessor")
	public String editFormProfessor() {
		return "view/curso/atualizarProfessor";
	}
	@PostMapping(value= "/atualizarProfessor")
	public String editFormProfessor(Professor professor) {
		prps.save(professor);
		return "redirect:professores";
	}
	@RequestMapping("/deletarProfessor")
	public String deleteProfessor(long idprofessor) {
		Professor professor = prps.findByidprofessor(idprofessor);
		prps.delete(professor);
		return "redirect:/professores";
	}

}
