package tads.eaj.ufrn.animeapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.animeapp.model.Anime;
import tads.eaj.ufrn.animeapp.repository.AnimeRepository;

import java.util.List;

@Service
public class AnimeService {

	AnimeRepository repository;

	@Autowired
	public void setRepository(AnimeRepository repository) {
		this.repository = repository;
	}

	public List<Anime> findAll(){
		return repository.findAll();
	}

	public void save(Anime a){
		 repository.save(a);
	}

	public void delete(Long id){
		repository.deleteById(id);
	}

	public Anime findById(Long id){
		return repository.getById(id);
	}
}