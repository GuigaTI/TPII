package br.edu.fatecpg.model;

import java.util.ArrayList;

public class Aeroporto {

    private ArrayList<Voo> voos = new ArrayList<>();

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    public void addVoo(Voo voo){
        voos.add(voo);
    }
    public void addVoo(String numVoo, String origem, String destino, int assentD){
        Voo inst = new Voo(numVoo,origem,destino,assentD);
        voos.add(inst);
    }

    public void excVoo(Voo voo){
        voos.remove(voo);
    }

    public void imprimirVoos(){
        this.voos.forEach((v) -> System.out.println(v.toString()));
    }

    public Object imprimirVoo(int indice){
        return  voos.get(indice).toString();
    }


    public int buscarVoo(String numVoo) {
        for (Voo v : this.voos) {
            if (v.getNumVoo().equals(numVoo)) return voos.indexOf(v);
        }
       return -1;
    }

    public Voo getVoo(String numVoo) {
        return voos.get(buscarVoo(numVoo));
    }

}