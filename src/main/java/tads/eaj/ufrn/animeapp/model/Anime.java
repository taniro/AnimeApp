package tads.eaj.ufrn.animeapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.animeapp.message.Mensagem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Anime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String genero;
	@Size(min = 3, max = 10, message = Mensagem.ERRO_TAMANHO_STRING)
	String titulo;
	@Min(value = 1900, message = Mensagem.ERRO_ANO_MINIMO)
	Integer anolancamento;
	Integer temporadas;
	Integer episodios;
	String classificacao;
}