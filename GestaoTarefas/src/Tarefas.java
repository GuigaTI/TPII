import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Tarefas {
    private String status;
    private String nomeTarefa;
    private String descTarefa;
    private String tipoTarefa;

    Scanner scan = new Scanner(System.in);
    static Connection connection;

    static {
        try {
            connection = Banco.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Tarefas(String tipoTarefa,String nomeTarefa,String descTarefa,String status) throws SQLException {
        this.tipoTarefa = tipoTarefa;
        this.nomeTarefa = nomeTarefa;
        this.descTarefa = descTarefa;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescTarefa() {
        return descTarefa;
    }

    public void setDescTarefa(String descTarefa) {
        this.descTarefa = descTarefa;
    }

    public String getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(String tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    @Override
    public String toString() {
        return "Tarefas{" +
                "status=" + status +
                ", nomeTarefa='" + nomeTarefa + '\'' +
                ", descTarefa='" + descTarefa + '\'' +
                ", tipoTarefa='" + tipoTarefa + '\'' +
                '}';
    }


    public static void addTarefa() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o tipo da tarefa: ");
        String tipo = scan.nextLine();
        System.out.println("Digite o nome da tarefa: ");
        String nome = scan.nextLine();
        System.out.println("Digite a desc da tarefa: ");
        String desc = scan.nextLine();
        System.out.println("Digite o status da tarefa: ");
        String stat = scan.nextLine();
        Tarefas tar = new Tarefas(tipo,nome,desc,stat);
        String query = "INSERT INTO tarefas(tipoTarefa,nomeTarefa,descTarefa,status) VALUES(?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1,tar.getTipoTarefa());
        stmt.setString(2,tar.getNomeTarefa());
        stmt.setString(3,tar.getDescTarefa());
        stmt.setString(4,tar.getStatus());
        stmt.execute();
    }

    public static void excluirTarefa() throws SQLException {
        Scanner scanInt = new Scanner(System.in);
        int id;
        System.out.println("Digite o id da tarefa a ser excluida: ");
        String queryDelete  = "DELETE FROM tarefas WHERE id = ?";
        PreparedStatement stmtD = connection.prepareStatement(queryDelete);
        stmtD.setInt(1,scanInt.nextInt());
        stmtD.execute();
        System.out.println("Tarefa excluida");
    }

    public static void exibirTarefas() throws SQLException {
        String queryEx = "SELECT * FROM tarefas ORDER BY id ASC";
        PreparedStatement stmt = connection.prepareStatement(queryEx);
        try(ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                int id2 = rs.getInt("id");
                String tipoTarefa = rs.getString("tipoTarefa");
                String nomeTarefa = rs.getString("nomeTarefa");
                String descTarefa = rs.getString("descTarefa");
                String status = rs.getString("status");
                System.out.println("ID: " + id2 + "\n" +
                        "Tipo da Tarefa: " + tipoTarefa + "\n" +
                        "Nome da Tarefa: " + nomeTarefa + "\n" +
                        "Descrição da Tarefa: " + descTarefa + "\n" +
                        "Status da Tarefa: " + status + "\n" +
                        "--------------------------------");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void exibirPStatus() throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o status das tarefas a ser mostrado: ");
        String stat = scan.nextLine();
        String queryEx = "SELECT * FROM tarefas WHERE status = ? ORDER BY id ASC";
        PreparedStatement stmt = connection.prepareStatement(queryEx);
        stmt.setString(1, stat);
        try(ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                int id2 = rs.getInt("id");
                String tipoTarefa = rs.getString("tipoTarefa");
                String nomeTarefa = rs.getString("nomeTarefa");
                String descTarefa = rs.getString("descTarefa");
                String status = rs.getString("status");
                System.out.println("ID: " + id2 + "\n" +
                        "Tipo da Tarefa: " + tipoTarefa + "\n" +
                        "Nome da Tarefa: " + nomeTarefa + "\n" +
                        "Descrição da Tarefa: " + descTarefa + "\n" +
                        "Status da Tarefa: " + status + "\n" +
                        "--------------------------------");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void editarTarefas() throws SQLException {
        Scanner scanOp = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o que deve ser editado" + "\n" +
                "1 - Nome da Tarefa" + " \n " +
                "2 - Descrição da Tarefa" + "\n" +
                "3 - Categoria da Tarefa" + "\n" +
                "4 - Status da tarefa");
        int op = scanOp.nextInt();
        int id = 0;
        String query;
        PreparedStatement stmt = null;
        switch (op){
            case 1:
                System.out.println("Digite o id da tarefa a ser editada:");
                id = scanInt.nextInt();
                query = "UPDATE tarefas SET nomeTarefa = ? WHERE id = ?";
                stmt = connection.prepareStatement(query);
                System.out.println("Digite o novo nome da Tarefa: ");
                stmt.setString(1,scan.nextLine());
                stmt.setInt(2,id);
                stmt.executeUpdate();
                System.out.println("Nome Atualizado");
                break;
            case 2:
                System.out.println("Digite o id da tarefa a ser editada:");
                id = scanInt.nextInt();
                query = "UPDATE tarefas SET descTarefa = ? WHERE id = ?";
                stmt = connection.prepareStatement(query);
                System.out.println("Digite a nova descrição da Tarefa: ");
                stmt.setString(1,scan.nextLine());
                stmt.setInt(2,id);
                stmt.executeUpdate();
                System.out.println("Descrição Atualizada");
                break;
            case 3:
                System.out.println("Digite o id da tarefa a ser editada:");
                id = scanInt.nextInt();
                query = "UPDATE tarefas SET tipoTarefa = ? WHERE id = ?";
                stmt = connection.prepareStatement(query);
                System.out.println("Digite a nova categoria da Tarefa: ");
                stmt.setString(1,scan.nextLine());
                stmt.setInt(2,id);
                stmt.executeUpdate();
                System.out.println("Categoria Atualizada");
                break;
            case 4:
                System.out.println("Digite o id da tarefa a ser editada:");
                id = scanInt.nextInt();
                query = "UPDATE tarefas SET status = ? WHERE id = ?";
                stmt = connection.prepareStatement(query);
                System.out.println("Digite a nova descrição da Tarefa: ");
                stmt.setString(1,scan.nextLine());
                stmt.setInt(2,id);
                stmt.executeUpdate();
                System.out.println("Status alterado");
                break;
            default:
                System.out.println("Digite uma operação valida");
                break;
        }
    }

    public static  void exibirPCategoria() throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a categoria a ser mostrada: ");
        String categoria = scan.nextLine();
        String queryEx = "SELECT * FROM tarefas WHERE tipoTarefa = ? ORDER BY id ASC";
        PreparedStatement stmt = connection.prepareStatement(queryEx);
        stmt.setString(1, categoria);
        try(ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                int id2 = rs.getInt("id");
                String tipoTarefa = rs.getString("tipoTarefa");
                String nomeTarefa = rs.getString("nomeTarefa");
                String descTarefa = rs.getString("descTarefa");
                String status = rs.getString("status");
                System.out.println("ID: " + id2 + "\n" +
                        "Tipo da Tarefa: " + tipoTarefa + "\n" +
                        "Nome da Tarefa: " + nomeTarefa + "\n" +
                        "Descrição da Tarefa: " + descTarefa + "\n" +
                        "Status da Tarefa: " + status + "\n" +
                        "--------------------------------");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void concluirTarefa() throws SQLException{
        PreparedStatement stmt;
        String query;
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        Scanner op = new Scanner(System.in);
        System.out.println("Digite 1 para utilizar o ID e 2 para utilizar o nome");
        int OP = op.nextInt();
        switch (OP){
            case 1:
                System.out.println("Digite o id da tarefa a ser concluida:");
                int id = scanInt.nextInt();
                query = "UPDATE tarefas SET status = ? WHERE id = ?";
                stmt = connection.prepareStatement(query);
                stmt.setString(1,"Concluido");
                stmt.setInt(2,id);
                stmt.executeUpdate();
                System.out.println("Status marcado como Concluido");
                break;
            case 2:
                System.out.println("Digite o nome da tarefa a ser editada:");
                String nmTarefa = scan.nextLine();
                query = "UPDATE tarefas SET status = ? WHERE nomeTarefa = ?";
                stmt = connection.prepareStatement(query);
                stmt.setString(1,"Concluído");
                stmt.setString(2,nmTarefa);
                stmt.executeUpdate();
                System.out.println("Status marcado como Concluido");
                break;
        }

    }

}