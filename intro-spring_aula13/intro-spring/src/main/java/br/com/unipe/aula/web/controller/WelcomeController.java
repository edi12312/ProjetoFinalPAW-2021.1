package br.com.unipe.aula.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.dao.MoradorDAO;
import br.com.unipe.aula.model.Morador;

@Controller
public class WelcomeController {
	
	@Autowired
	private MoradorDAO dao;
	
	public WelcomeController() {
		dao = new MoradorDAO();
	}
	
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "/outraforma", method = RequestMethod.GET)
	public ModelAndView outraforma() {
		ModelAndView view = new ModelAndView("welcome");
		
		view.addObject("mensagem", "View com parâmetro funcionando com sucesso!");
		
		return view;
	}

	@RequestMapping(value = "/formulario", method = RequestMethod.GET)
	public ModelAndView formulario(Model model) {
		model.addAttribute("morador", new Morador());
		return new ModelAndView("formulario");
	}
	
	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public ModelAndView exibelocal(@ModelAttribute Morador morador) {
		ModelAndView view = new ModelAndView("formulario");
		
		view.addObject("mensagem", morador.getNome() + " é morador de " + morador.getLocal());
		
		return view;
	}
	
	@PostMapping(value = "/cadastro")
	public ModelAndView cadastrarMorador(@ModelAttribute Morador morador) {
				
		dao.salvar(morador);
		
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Morador cadastrado com sucesso!");
		view.addObject("moradores", dao.getAll());
				
		return view;
	}
	
	@GetMapping(value = "/cadastro")
	public ModelAndView retornarAposExcluir(@ModelAttribute Morador morador) {
				
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Morador cadastrado com sucesso!");
		view.addObject("moradores", dao.getAll());
				
		return view;
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluirMorador(@PathVariable("id") int id, Model model) {
		
		dao.excluir(id);
						
		return "redirect:../cadastro";
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView editarMorador(@PathVariable("id") int id, Model model) {
				
		ModelAndView view = new ModelAndView("editar");
		model.addAttribute("morador", dao.getId(id));
				
		return view;
	}
	
	@PostMapping(value = "/update/{id}")
	public String updateMorador(@PathVariable("id") int id, @ModelAttribute Morador morador) {
		
		dao.editar(id, morador);
						
		return "redirect:../cadastro";
	}

}
