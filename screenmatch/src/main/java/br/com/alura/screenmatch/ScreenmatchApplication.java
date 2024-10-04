package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		var consumoApi = new ConsumoApi();
		
//		var json = consumoApi.obterDados("http://www.omdbapi.com/?i=tt3896198&apikey=8b1d5fde");
//		System.out.println(json);
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=8b1d5fde");
		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
		
		
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		
		
	}
}
