package tads.eaj.ufrn.animeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.animeapp.model.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
