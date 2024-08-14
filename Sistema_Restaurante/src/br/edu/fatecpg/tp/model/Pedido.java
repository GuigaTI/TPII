package br.edu.fatecpg.tp.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int numero;
    private List<ItemPedido> itens = new ArrayList<>();
    private double taxaEntrega=10;

	public Pedido(int numero, List<ItemPedido> itens) {
		this.numero=numero;
		this.itens = itens;
	}
	
	public static void criarPedido(String string) {
		numero=Integer.parseInt(string);
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public double TotalPedido() {
        double soma= 0;
        for(ItemPedido itens : this.itens) {
			soma += itens.getQuantidade()*itens.getPreco();
		}
		return soma+taxaEntrega;
 
	}

	public void adicionarItem(ItemPedido item) throws SQLException {
		 itens.add(item);
			db.inserirItem(item);
	
			
	}



	public void removerItem(ItemPedido item) {
		 itens.remove(item);
		
	}
	
	public void reservarMesa(int numeroMesa) {
		System.out.println("Pedido Numero "+numero+" reservou a mesa " +numeroMesa);
	}
	

	
	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", Itens Pedidos: " +itens+"]";
	}
	
	
}
