package br.edu.fatecpg.tp.model;

public class ItemPedido {
	private String nomeDoPrato;
	private double precoUnitario;
	private double quantidade;
	
	public ItemPedido(String nomeDoPrato, double precoUnitario, double quantidade) {
		this.nomeDoPrato=nomeDoPrato;
		this.precoUnitario=precoUnitario;
		this.quantidade=quantidade;
		
		
	}


	public String getNome() {
		return nomeDoPrato;
	}

	public void setNome(String nomeDoPrato) {
		this.nomeDoPrato = nomeDoPrato;
	}

	public double getPreco() {
		return precoUnitario;
	}

	public void setPreco(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Item [nome=" + nomeDoPrato + ", preco=" + precoUnitario + ", quantidade=" + quantidade + "]";
	}
	
	
	
}
