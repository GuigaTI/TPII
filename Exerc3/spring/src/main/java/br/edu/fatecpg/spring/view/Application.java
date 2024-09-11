package br.edu.fatecpg.spring.view;


import br.edu.fatecpg.spring.model.Carros;

import br.edu.fatecpg.spring.service.ConsomeAPI;
import br.edu.fatecpg.spring.service.ConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanInt = new Scanner(System.in);
		int op;
		int menu = 1;

		while(menu != 0) {
			System.out.println("""
                ------Menu------\
                
                 1 - Buscar Carro\
                 
                 2 - Buscar Moto\
                 
                 3 - Buscar Caminhão\
                
                 4 - Sair""");
			op = scanInt.nextInt();
			switch (op) {
				case 1:
					String tipo = "carros";
					String json = ConsomeAPI.obterMarcas(tipo);
					ConverteDado conversor = new ConverteDado();
					System.out.println(json);
					System.out.println("Digite o codigo da marca");
					int cdMarca;
					cdMarca = scanInt.nextInt();
					String jsonModelo = ConsomeAPI.obterModelos(tipo,cdMarca);
					System.out.println(jsonModelo);
					System.out.println("Digite o codigo do modelo");
					int cdModelo;
					cdModelo = scanInt.nextInt();
					String jsonAno = ConsomeAPI.obterAnos(tipo,cdMarca, cdModelo);
					System.out.println(jsonAno);
					System.out.println("Digite o ano");
					Scanner scan = new Scanner(System.in);
					String ano;
					ano = scan.nextLine();
					String jsonValor = ConsomeAPI.obterValores(tipo,cdMarca, cdModelo, ano);
					Carros carro = conversor.obterDado(jsonValor, Carros.class);
					System.out.println("Carro \n" + carro);
					break;
				case 2:
					tipo = "motos";
					json = ConsomeAPI.obterMarcas(tipo);
					conversor = new ConverteDado();
					System.out.println(json);
					System.out.println("Digite o codigo da marca");
					cdMarca = scanInt.nextInt();
					jsonModelo = ConsomeAPI.obterModelos(tipo,cdMarca);
					System.out.println(jsonModelo);
					System.out.println("Digite o codigo do modelo");
					cdModelo = scanInt.nextInt();
					jsonAno = ConsomeAPI.obterAnos(tipo,cdMarca, cdModelo);
					System.out.println(jsonAno);
					System.out.println("Digite o ano");
					scan = new Scanner(System.in);
					ano = scan.nextLine();
					jsonValor = ConsomeAPI.obterValores(tipo,cdMarca, cdModelo, ano);
					carro = conversor.obterDado(jsonValor, Carros.class);
					System.out.println("Moto: \n" + carro);
					break;
				case 3:
					tipo = "caminhoes";
					json = ConsomeAPI.obterMarcas(tipo);
					conversor = new ConverteDado();
					System.out.println(json);
					System.out.println("Digite o codigo da marca");
					cdMarca = scanInt.nextInt();
					jsonModelo = ConsomeAPI.obterModelos(tipo,cdMarca);
					System.out.println(jsonModelo);
					System.out.println("Digite o codigo do modelo");
					cdModelo = scanInt.nextInt();
					jsonAno = ConsomeAPI.obterAnos(tipo,cdMarca, cdModelo);
					System.out.println(jsonAno);
					System.out.println("Digite o ano");
					scan = new Scanner(System.in);
					ano = scan.nextLine();
					jsonValor = ConsomeAPI.obterValores(tipo,cdMarca, cdModelo, ano);
					carro = conversor.obterDado(jsonValor, Carros.class);
					System.out.println("Caminhão: \n" + carro);
					break;
				case 4:
					System.out.println("Saindo....");
					menu = 0;
					break;
			}

			}
		}}




