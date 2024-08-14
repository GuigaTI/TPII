package br.edu.fatecpg.tp.model;
import java.util.ArrayList;
import java.util.List;


public class Restaurante {
	
    private List<Pedido> pedidos = new ArrayList<>();
    
    

	public void adicionarPedido(Pedido pedido) {
		 pedidos.add(pedido);
	}

	public void removerPedido(Pedido pedido) {
		 pedidos.remove(pedido);
}
	public void exibirPedidos() {
		if(pedidos.isEmpty()) {
	    	System.out.println("Não há pedidos");

		}else {
        for(Pedido pedidos : this.pedidos) {
    	System.out.println("Lista de Pedidos"+pedidos);
        }
		}
	}
	
public void	buscarPedido(Pedido pedido) {
	if(pedidos.contains(pedido)) {
    	System.out.println("Existe este pedido e ele está na posição "+pedidos.indexOf(pedido));

	}
	
}
	
}