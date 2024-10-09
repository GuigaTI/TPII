import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class Comentarios {
    public int postID;
    public int id;

    public String email;
    @SerializedName("name")
            public String nome;
    @SerializedName("body")
            public String comentario;






    //O treeSet serve tanto para pegar as informações (somente os emails utilizando o stream e map, alem disso serve também para
    //garantir que não tenha emails duplicados
    public static TreeSet<String> pegaEmails() throws IOException, InterruptedException {
        buscaComentarios busca = new buscaComentarios(); //objeto do tipo busca
        String jsonResponse = busca.consomeApi(); //pega a API atraves do consumo
        Gson gson = new Gson(); // cria um Gson

        List<Comentarios> infos = gson.fromJson(jsonResponse,new TypeToken<List<Comentarios>>(){}.getType()); //cria uma lista do tipo Comentario que recebe os dados da API
        return infos.stream()
                .map(comentario -> comentario.email)
                .collect(Collectors.toCollection(TreeSet::new)); //retorna somentre os emails daqueles que possuem comentarios em forma de uma Tree
    }

    public static List<String> listaEmail() throws IOException, InterruptedException {
        return new ArrayList<>(pegaEmails()); //converte a tree para uma lista
    }

}
