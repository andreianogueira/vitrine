package br.com.vitrine.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.vitrine.model.Sugestao;
import br.com.vitrine.repository.SugestaoRepository;

@Controller
@RequestMapping("/sugestao")
public class SugestaoController {
	
	@Autowired
	SugestaoRepository repo;
	
	@PostMapping("/cadastra")
	public ModelAndView cadastraSugestao(@ModelAttribute("sugestao") @Valid Sugestao sugestao, BindingResult result) {
		System.out.println(sugestao);
		repo.save(sugestao);
		ModelAndView modelSugestao = new ModelAndView("sugestao/AdicionaSugestao");
		modelSugestao.addObject("sugestao", new Sugestao());
		modelSugestao.addObject("mensagem", "salvo com sucesso");
		return modelSugestao;
	}
	
	@GetMapping("/formulario")
	public ModelAndView formularioSugestao() {
		Sugestao sugestao = new Sugestao();
		ModelAndView modelSugestao = new ModelAndView("sugestao/AdicionaSugestao");
		modelSugestao.addObject("sugestao", sugestao);
		return modelSugestao;
	}
}
