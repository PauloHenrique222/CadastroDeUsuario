package com.projetoItss.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoItss.models.Pessoa;
import com.projetoItss.repositores.CadastroRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private CadastroRepository er;
	
	@RequestMapping(value = "/cadastrarPessoa" , method = RequestMethod.GET)
	public String form() {
		return "cadastro/formPessoa";
	}
	
	@RequestMapping(value = "/cadastrarPessoa" , method = RequestMethod.POST)
	public String form(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Por favor! Preencha todos os campos para continuar");
			return "redirect:/cadastrarPessoa";
		}
		try {
			er.save(pessoa);
			attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
			return "redirect:/cadastrarPessoa";
		}catch(Exception e) {
			attributes.addFlashAttribute("mensagem", "Usuario já existe, digite novamento");
			return "redirect:/cadastrarPessoa";
		}
	}
	
	@RequestMapping("/usuarios")
	public ModelAndView listUsuarios() {
		
		ModelAndView mv = new ModelAndView("index");
	
		Iterable<Pessoa> pessoas = er.findAll();
		mv.addObject("pessoa", pessoas);
		return mv;
	}
	
	@PostMapping("/pesquisarpessoa")
	public ModelAndView pesqUsuarios(@RequestParam("nomepesquisa") String nomepesquisa) {
		
		ModelAndView mv = new ModelAndView("index");
		
		if(nomepesquisa.equals("")) {
			Iterable<Pessoa> pessoas = er.findAll();
			mv.addObject("pessoa", pessoas);
			return mv;
		}
		
		Iterable<Pessoa> pessoas = er.findByNome(nomepesquisa);
		mv.addObject("pessoa", pessoas);
		return mv;
	}
	
}
