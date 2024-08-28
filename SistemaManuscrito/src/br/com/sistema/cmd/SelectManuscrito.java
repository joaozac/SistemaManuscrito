package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
		
		//criar o Sql para extrai os dados
		String sql = "select * from manuscrito";
		
		//Criar o comando
		PreparedStatement cmd = conexao.prepareStatement(sql);
		
		//executar o comando
		ResultSet resultado = cmd.executeQuery();
		
		//Criar uma variavel para receber os dados
		String manuscritos;
		manuscritos = "<< Manuscritos encontrados >>\n";
		while(resultado.next()) {
			manuscritos += "ID: " + resultado.getInt("id") 
			+ "- Titulo" + resultado.getString("titulo") 
			+ "- Autor: " + resultado.getString("autor")
			+"\n";
			
		}
		JOptionPane.showConfirmDialog(null, manuscritos);
		conexao.close();
		
		
	} catch (Exception e) {
		e.printStackTrace();
			
	}

	}

}
