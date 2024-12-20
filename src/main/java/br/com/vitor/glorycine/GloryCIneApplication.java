package br.com.vitor.glorycine;

import br.com.vitor.glorycine.model.DadosEpisodio;
import br.com.vitor.glorycine.model.DadosSerie;
import br.com.vitor.glorycine.model.DadosTemporada;
import br.com.vitor.glorycine.principal.Principal;
import br.com.vitor.glorycine.service.ConsumoAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GloryCIneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GloryCIneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();

		principal.exibirMenu();
	}
}
