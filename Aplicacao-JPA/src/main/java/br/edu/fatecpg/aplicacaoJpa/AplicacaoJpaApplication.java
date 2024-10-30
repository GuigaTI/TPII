package br.edu.fatecpg.aplicacaoJpa;

import br.edu.fatecpg.aplicacaoJpa.controller.buscaEndereco;
import br.edu.fatecpg.aplicacaoJpa.model.Endereco;
import br.edu.fatecpg.aplicacaoJpa.service.EnderecoBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;



@SpringBootApplication
public class AplicacaoJpaApplication implements CommandLineRunner {

	@Autowired
	private EnderecoBanco banco; // Injeta o serviço EnderecoBanco automaticamente

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanOP1 = new Scanner(System.in);
		int menu = 1;
		while (menu != 0) {
			System.out.println("Digite uma opção" + "\n" +
					"1 - Consultar cep" + " \n" +
					"2 - Ver CEPs Banco" + "\n" +
					"- Digite 0 para sair - " + "\n" +
					"-----------------------------------");
			int opM = scanOP1.nextInt();
			switch (opM) {
                case 1:
                    System.out.print("Digite o CEP a ser consultado (ex: 01001-000): ");
                    Scanner scanner = new Scanner(System.in);
                    String codigo = scanner.nextLine();
                    Endereco endereco = buscaEndereco.consultarCepNaApi(codigo);
                    Endereco enderecoSalvo;
                    if (endereco != null) {
						enderecoSalvo = banco.saveEndereco(endereco);
						if (enderecoSalvo != null) {
							System.out.println("CEP consultado e armazenado: " + endereco.getCodigo());
						} else {
							System.out.println("O CEP " + endereco.getCodigo() + " já está armazenado no banco de dados.");
						}
					}else{
							System.out.println("CEP não encontrado.");
						}
					break;
				case 2:
					List<Endereco> enderecos = banco.findEndereco();
					if(enderecos.isEmpty()){
						System.out.println("Nenhum endereco encontrado.");
					}else{
						System.out.println("Endereços encontrados:");
						enderecos.forEach(System.out::println);
					}
					break;
				case 0:
					menu = 0;
					System.out.println("Programa encerrado!!!!!");
					break;
				default:
					System.out.println("Digite uma opção valida");
					break;

			}
		}
	}
}
