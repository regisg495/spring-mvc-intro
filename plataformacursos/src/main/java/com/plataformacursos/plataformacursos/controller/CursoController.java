package com.plataformacursos.plataformacursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.plataformacursos.plataformacursos.model.Curso;
import com.plataformacursos.plataformacursos.repository.CursoRepository;

@Controller
public class CursoController {
		
		@Autowired
		private CursoRepository cursorps;
	
		@RequestMapping(value= "/cadastroCurso", method=RequestMethod.GET)
		public String addCourse() {
			return "view/curso/cadastroCurso";
		}
		@RequestMapping(value= "/cadastroCurso", method=RequestMethod.POST)
		public String addCourse(Curso curso) {
			cursorps.save(curso);
			return "view/curso/cadastroCurso";
		}
		@RequestMapping("/cursos")
		public ModelAndView showCourses() {
			ModelAndView mov = new ModelAndView("view/curso/cursos");
			Iterable<Curso> cursos = cursorps.findAll();
			mov.addObject("cursos", cursos);
			return mov;
		}
		
		@RequestMapping("/idcurso={idcurso}")
		public ModelAndView atualizarCurso(@PathVariable("idcurso") long idcurso) {
			Curso curso = cursorps.findByidcurso(idcurso);
			ModelAndView mov = new ModelAndView("view/curso/atualizarCurso");
			mov.addObject("cursos", curso);
			return mov;
		}
		@RequestMapping(value= "/atualizarCurso")
		public String editForm() {
			return "view/curso/atualizarCurso";
		}
		@PostMapping(value= "/atualizarCurso")
		public String editForm(Curso curso) {
			cursorps.save(curso);
			return "redirect:cursos";
		}
		
		@RequestMapping("/deletarCurso")
		public String deletarCurso(long idcurso) {
			Curso curso = cursorps.findByidcurso(idcurso);
			cursorps.delete(curso);
			return "redirect:/cursos";
		}
		
	
		
}
