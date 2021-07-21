package tads.eaj.ufrn.animeapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String getPage(Model model){

		Anime a = new Anime(0l, "Briga", "Naruto", 2010, 10,10, "Bom");
		service.save(a);

		var listaAnimes = service.findAll();
		model.addAttribute("listaAnimes", listaAnimes);
		return "index";
	}
}
