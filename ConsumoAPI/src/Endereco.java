import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Endereco {
    public String cep;

@SerializedName("logradouro")
    public String rua;
    public String bairro;

@SerializedName("localidade")
public String cidade;

    public String uf;


    public static void consultaBanco() throws SQLException {
        String queryEx = "SELECT * FROM endereco ORDER BY id ASC";
        PreparedStatement stmt = connection.prepareStatement(queryEx);
        try(ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                int id2 = rs.getInt("id");
                String CEP = rs.getString("CEP");
                String RUA = rs.getString("RUA");
                String CIDADE = rs.getString("CIDADE");
                System.out.println("ID: " + id2 + "\n" +
                        "CEP: " + CEP + "\n" +
                        "Rua: " + RUA + "\n" +
                        "Cidade: " + CIDADE + "\n" +
                        "--------------------------------");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ENDEREÇO" +
                "\nCEP: " + cep +
                "\nRUA: " + rua +
                "\nBAIRRO: " + bairro +
                "\nCIDADE: " + cidade +
                "\nUF: " + uf;
    }
    static Connection connection;

    static {
        try {
            connection = Banco.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void adicionaBanco() throws SQLException {
        String query = "INSERT INTO endereco(CEP,RUA,CIDADE) VALUES(?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1,getCep());
        stmt.setString(2,getRua());
        stmt.setString(3,getCidade());
        stmt.execute();
        String nomeArquivo = "LOG.txt";
        try {
            File arquivo = new File(nomeArquivo);
            if (!arquivo.exists()) {
                // Cria o arquivo se não existir
                if (arquivo.createNewFile()) {
                    System.out.println("Arquivo criado com sucesso: " + nomeArquivo);
                } else {
                    System.out.println("Ocorreu um erro ao criar o arquivo.");
                }
            }
            // Usa o FileWriter para escrever no arquivo
            FileWriter escrita = new FileWriter(arquivo, true); // 'true' para append (acrescentar ao conteúdo existente)
            String jsonTempo = BuscaEndereco.consomeAPI();
            Gson gson = new Gson();
            Tempo tempo = gson.fromJson(jsonTempo,Tempo.class);
            String queryEx = "SELECT * FROM endereco WHERE CEP = ? ORDER BY id DESC LIMIT 1";
            stmt = connection.prepareStatement(queryEx);
            stmt.setString(1,cep);
            int id2 = 0;
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                   id2 = rs.getInt("id");
                   String info = "ID: " + id2 + " - CEP: " + cep + " - Data e hora: " + tempo.horario + " - " + tempo.local + "\n";
                    escrita.write(info);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }


            escrita.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as informaçeõs de LOG");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
