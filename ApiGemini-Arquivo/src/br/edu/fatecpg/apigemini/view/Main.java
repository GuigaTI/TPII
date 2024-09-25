package br.edu.fatecpg.apigemini.view;

import br.edu.fatecpg.apigemini.services.ConsomeAPI;
import br.edu.fatecpg.apigemini.services.txtMaker;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String resposta;
        String pergunta;
        int menu = 1;
        int contador = 3;
        do{
            while(contador!=0){
                System.out.println("Digite sua pergunta");
                pergunta = scan.nextLine();
                resposta = ConsomeAPI.fazerPergunta(pergunta);
                System.out.println(resposta);
                txtMaker.gerarLog(resposta);
                contador--;
            }
            System.out.println("Digite sua pergunta - Digite Quit ou Sair para finalizar ");
            pergunta = scan.nextLine();
            if(!Objects.equals(pergunta, "Quit") && !Objects.equals(pergunta, "Sair")){
                resposta = ConsomeAPI.fazerPergunta(pergunta);
                System.out.println(resposta);
                txtMaker.gerarLog(resposta);
            }else{
                menu = 0;
                txtMaker.gerarResumo();
                System.out.println("Saindo....");
            }
        }while(menu != 0);
    }
}
