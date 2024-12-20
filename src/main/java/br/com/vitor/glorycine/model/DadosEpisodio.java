package br.com.vitor.glorycine.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,

                            @JsonAlias("Episode") Integer Episódio,

                            @JsonAlias("imdbRating") String avaliacao,

                            @JsonAlias("Released") String dataLancamento) {

    @Override
    public String toString() {
        return "Título : " + titulo + "\n" +
                "Episódio : " + Episódio + "\n" +
                "Avaliação : " + avaliacao + "\n" +
                "dataLancamento : " + dataLancamento;
    }
}
