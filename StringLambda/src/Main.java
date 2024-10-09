import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> emails = Comentarios.listaEmail();
        System.out.println("Os emails de usuarios que fizeram comentarios são: ");
        emails.forEach(System.out::println);


    }
}
