package br.edu.fatecpg.tp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class db {
	
	public static Connection connect() throws SQLException{
		
		try {
			var URL = "jdbc:mysql://localhost:3306/db_restaurante";
			var USER = "root";
			var PASSWORD = "";
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return null;
			
		}
				
	}
	
	
	public static void inserirItem(ItemPedido item) throws SQLException{		
		String query = "INSERT INTO ItemPedido (nomeDoPrato, precoUnitario, quantidade) VALUES (?, ?, ?)";
			var connection =db.connect();
			PreparedStatement stmt = connection.prepareStatement(query);
			
		      stmt.setString(1, item.getNome());
	          stmt.setDouble(2, item.getPreco());
	          stmt.setDouble(3, item.getQuantidade());
	          stmt.executeUpdate();
	            System.out.println("Item adicionado com sucesso ao banco de dados!");			
}
	

	
	
}
