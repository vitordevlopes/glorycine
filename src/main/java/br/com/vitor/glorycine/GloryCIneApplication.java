package br.com.vitor.glorycine;

import br.com.vitor.glorycine.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GloryCIneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GloryCIneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ConsumoAPI consumoAPI = new ConsumoAPI();

		var json = consumoAPI.obterDados("https://www.omdbapi.com/?i=tt3896198&apikey=823cdbd2");

		System.out.println(json);

		json = consumoAPI.obterDados("https://random.imagecdn.app/v1/image?width=500&height=500");

		System.out.println(json);

	}
}
