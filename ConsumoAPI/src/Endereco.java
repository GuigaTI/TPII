import com.google.gson.annotations.SerializedName;

public class Endereco {
    public String cep;

    @SerializedName("logradouro")
    public String rua;
    public String bairro;
    @SerializedName("localidade")
    public String cidade;
    public String uf;

    @Override
    public String toString() {
        return "Endereco \n" +
                "CEP: " + cep + "\n" +
                "RUA: " + rua + "\n" +
                "BAIRRO: " + bairro + "\n" +
                "CIDADE: " + cidade + "\n" +
                "ESTADO: " + uf + "\n";
    }
}
