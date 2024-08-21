import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException, InterruptedException {
        Scanner scanInt = new Scanner(System.in);
        int menu = 1;
       do {
            System.out.println("Consumo de API - Digite 0 para sair - 1 para buscar");
            switch (scanInt.nextInt()){
                case 0:
                    menu = 0;
                    System.out.println("Programa finalizado!");
                    break;
                default:
                    Gson gson = new Gson();
                    var buscaEnd = new BuscaEndereco();
                    String json = buscaEnd.consomeAPI();
                    System.out.println(json);
                    Endereco enderecoFatec = gson.fromJson(json, Endereco.class);
                    System.out.println(enderecoFatec.toString());
            }

        }while(menu != 0);
    }
}
