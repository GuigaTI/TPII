package br.edu.fatecpg.apiMkt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ApiMktApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiMktApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Defina o valor para promoção em numero inteiro:");
		int val = scan.nextInt();
		System.out.println("Lista dos produtos em promoção");
  		imperPromo.promo(val);
		System.out.println("Lista dos produtos imperdiveis");
		imperPromo.imper();



	}
}