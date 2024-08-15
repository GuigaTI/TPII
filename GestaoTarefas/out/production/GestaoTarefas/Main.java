import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

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
        int menu = 1;
        while(menu != 0){
            System.out.println("Digite uma opção" + "\n" +
                    "1 - Criar Tarefa" + " \n " +
                    "2 - Excluir Tarefa" + "\n" +
                    "3 - Editar tarefa" + "\n" +
                    "4 - Exibir Tarefas" + "\n" +
                    "5 - Exibir por Categoria" + "\n" +
                    "6 - Exibir por Status" + "\n" +
                    "7 - Marcar como concluido" + "\n" +
                    "  - Digite 0 para sair - " + "\n" +
                    "-----------------------------------");
            int opM = scanOP1.nextInt();
            switch (opM) {
                case 1:
                    Tarefas.addTarefa();
                    break;
                case 2:
                    Tarefas.excluirTarefa();
                    break;
                case 3:
                    Tarefas.editarTarefas();
                    break;
                case 4:
                    Tarefas.exibirTarefas();
                    break;
                case 5:
                    Tarefas.exibirPCategoria();
                    break;
                case 6:
                    Tarefas.exibirPStatus();
                    break;
                case 7:
                    Tarefas.concluirTarefa();
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