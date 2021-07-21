package tads.eaj.ufrn.animeapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Anime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String genero;
	String titulo;
	Integer anolancamento;
	Integer temporadas;
	Integer episodios;
	String classificacao;
}