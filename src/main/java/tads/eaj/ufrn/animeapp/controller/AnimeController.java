package tads.eaj.ufrn.animeapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tads.eaj.ufrn.animeapp.model.Anime;
import tads.eaj.ufrn.animeapp.service.AnimeService;

@Controller
public class AnimeController {

	AnimeService service;

	@Autowired
	public void setService(AnimeService service) {
		this.service = service;
	}

	@RequestMapping(value = {"/", "/anime"}, method = RequestMethod.GET)
	public String getHome(Model model){
		var listaAnimes = service.findAll();
		model.addAttribute("listaAnimes", listaAnimes);
		return "index";
	}

	@RequestMapping("/cadastro")
	public String getFormCadastro(Model model){
		Anime anime = new Anime();
		model.addAttribute("anime", anime);
		return "cadastro";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String doSalvar(@ModelAttribute Anime pipoquinha){
		service.save(pipoquinha);
		return "redirect:/";
	}

	@RequestMapping("/deletar/{id}")
	public String doDelete(@PathVariable(name = "id") Long id){
		service.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/editar/{id}")
	public ModelAndView getFormEdicao(@PathVariable(name = "id") Long id){
		ModelAndView modelAndView = new ModelAndView("edicao");
		Anime anime = service.findById(id);
		modelAndView.addObject("anime", anime);
		return modelAndView;
	}
}
