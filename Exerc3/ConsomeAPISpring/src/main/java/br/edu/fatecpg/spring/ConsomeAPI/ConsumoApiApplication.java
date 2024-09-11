package br.edu.fatecpg.spring.ConsomeAPI;

import br.edu.fatecpg.spring.ConsomeAPI.model.Filme;
import br.edu.fatecpg.spring.ConsomeAPI.model.Serie;
import br.edu.fatecpg.spring.ConsomeAPI.service.ConsomeAPI;
import br.edu.fatecpg.spring.ConsomeAPI.service.ConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConsumoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanInt = new Scanner(System.in);
		int op;
		int menu = 1;

		while(menu != 0) {
			System.out.println("""
                ------Menu------\
                
                 1 - Buscar Serie\
                
                 2 - Buscar Filme\
                 
                 3 - Sair""");
			op = scanInt.nextInt();
			switch (op) {
				case 1:
					System.out.println("Digite a serie a ser buscada");
					String json = ConsomeAPI.obterDado();
					ConverteDado conversor = new ConverteDado();
					Serie serie = conversor.obterDado(json, Serie.class);
					System.out.println(serie);
					break;
				case 2:
					System.out.println("Digite o filme a ser buscada");
					json = ConsomeAPI.obterDado();
					conversor = new ConverteDado();
					Filme filme = conversor.obterDado(json, Filme.class);
					System.out.println(filme);
					break;
				case 3:
					menu = 0;
					break;
			}
		}


	}
}
