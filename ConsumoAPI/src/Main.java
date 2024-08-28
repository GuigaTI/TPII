import com.google.gson.Gson;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        Scanner scan = new Scanner(System.in);
        Scanner scanOP1 = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = Banco.connection();
            System.out.println("Conexão bem sucedida");
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro na conexão" + e.getMessage());
        }
        Gson gson = new Gson();
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
                    var buscaEnd = new BuscaEndereco();
                    System.out.println("Digite o CEP:");
                    String json = buscaEnd.consomeApi(scan.nextLine());
                    Endereco enderecoFatec = gson.fromJson(json, Endereco.class);
                    enderecoFatec.adicionaBanco();
                    break;
                case 2:
                    Endereco.consultaBanco();
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