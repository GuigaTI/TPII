package br.edu.fatecpg.main;

import br.edu.fatecpg.model.Aeroporto;
import br.edu.fatecpg.model.Voo;
import br.edu.fatecpg.view.Principal;

public class Main {
    public static void main(String[] args) {
        Aeroporto a = new Aeroporto();
        new Principal(a);

    }
}