package br.edu.fatecpg.apigemini.view;

import br.edu.fatecpg.apigemini.services.ConsomeAPI;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        String pergunta;
        int menu = 1;
        int op;
        do{
            System.out.println("Digite sua pergunta - Digite Quit ou Sair para finalizar ");
            pergunta = scan.nextLine();
            if(!Objects.equals(pergunta, "Quit") && !Objects.equals(pergunta, "Sair")){
                System.out.println(ConsomeAPI.fazerPergunta(pergunta));
            }else{
                menu = 0;
                System.out.println("Saindo....");
            }
        }while(menu != 0);
    }
}
