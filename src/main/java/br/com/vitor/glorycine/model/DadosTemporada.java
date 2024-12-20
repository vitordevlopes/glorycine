package br.com.vitor.glorycine.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Season") Integer Temporada,

                             @JsonAlias("Episodes") List<DadosEpisodio> episodios) {
}
