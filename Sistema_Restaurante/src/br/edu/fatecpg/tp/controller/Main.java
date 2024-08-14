package br.edu.fatecpg.tp.controller;
import br.edu.fatecpg.tp.model.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) {
		
		try(var connection = db.connect()){
		if(connection != null) {
		System.out.println("Conectado ao Banco de Dados!");

		ItemPedido item1 = new ItemPedido("carne", 10,3);
		ItemPedido item2 = new ItemPedido("legumes", 5,4);
		
		List<ItemPedido> itens = new ArrayList<>();
		
		itens.add(item1);
		itens.add(item2);
		
		Pedido pedido1 = new Pedido(1, itens);
		
		
		System.out.println(pedido1);
		
		System.out.println(pedido1.TotalPedido());

		pedido1.adicionarItem(item2);
		
		System.out.println(pedido1);
		System.out.println(pedido1.TotalPedido());
		
		pedido1.removerItem(item2);
		System.out.println(pedido1);
		System.out.println(pedido1.TotalPedido());
		
		pedido1.reservarMesa(54);
		
		Restaurante restaurante = new Restaurante();
		restaurante.exibirPedidos();
		restaurante.adicionarPedido(pedido1);
		restaurante.exibirPedidos();

		restaurante.buscarPedido(pedido1);
		}else{
			System.out.println("Erro na conexão ao banco de dados");
		}
		
		}catch(SQLException e){
			System.err.println("Erro ao conectar: "+ e.getMessage());
		
	}

	}
	}
		
	


