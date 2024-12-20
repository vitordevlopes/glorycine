package br.com.vitor.glorycine.principal;


import br.com.vitor.glorycine.model.DadosSerie;
import br.com.vitor.glorycine.model.DadosTemporada;
import br.com.vitor.glorycine.service.ConsumoAPI;
import br.com.vitor.glorycine.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private ConverteDados conversor = new ConverteDados();
    private ObjectMapper mapper = new ObjectMapper();
    private ConsumoAPI consumo = new ConsumoAPI();
    private Scanner scanner = new Scanner(System.in);
    private static final String ENDERECO = "https://www.omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=823cdbd2";


    public void exibirMenu() {

        System.out.println("Nome da série: ");
        String nomeSerie = scanner.nextLine();

        var json =  consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);

        System.out.println(serie);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= serie.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }

        temporadas.forEach(System.out::println);

//        for (int i = 0; i < serie.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for(int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//
//        }

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));



    }

}
