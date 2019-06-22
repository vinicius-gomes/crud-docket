package br.com.docket.controllers;

import java.util.List;

import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.docket.daos.CartorioDAO;
import br.com.docket.models.Cartorio;

@Controller
@RequestMapping("/cartorios")
public class CartoriosController {

	@Autowired
	private CartorioDAO dao;

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(Cartorio cartorio, RedirectAttributes redirectAttributes) {

		if(cartorio.getName() == null || cartorio.getName().isEmpty()) {
			return form(cartorio);
		}
		
		dao.gravar(cartorio);
		
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		
		return new ModelAndView("redirect:cartorios");
	}

	@RequestMapping("form")
	public ModelAndView form(Cartorio cartorio) {
		ModelAndView modelAndView = new ModelAndView("cartorios/form");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Cartorio> cartorios = dao.listar();
		ModelAndView modelAndView = new ModelAndView("cartorios/lista");
		modelAndView.addObject("cartorios", cartorios);

		return modelAndView;
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView update(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("cartorios/formedit");
		Cartorio cartorio = dao.find(id);
		modelAndView.addObject("cartorio", cartorio);
		return modelAndView;
	}
	
	@RequestMapping("/editsave")
	public String editsave(Cartorio cartorio) {
		return "redirect:/cartorios";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Cartorio cartorio = dao.find(id);
		dao.delete(cartorio);
		return "redirect:/cartorios";
	}
	
	@RequestMapping("/detalhes/{id}")
	public ModelAndView detalhes(@PathVariable Integer id) {
		Cartorio cartorio = dao.find(id);
		ModelAndView modelAndView = new ModelAndView("cartorios/detalhes");
		modelAndView.addObject("cartorio", cartorio);
		return modelAndView;
	}
}
