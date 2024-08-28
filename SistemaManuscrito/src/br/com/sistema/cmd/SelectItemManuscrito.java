package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectItemManuscrito {

	public static void main(String[] args) {
		try {
			//abri conexao com banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//Criar variavel para buscar o registro no banco
			String id;
			
			//ID irá receber o valor digitado pelo usuário
			id = JOptionPane.showInputDialog("Digite o ID do manuscrito");
			
			//Criar o SQl para extrair os dados do banco
			String sql;
			
			sql = "select * from manuscrito where id = " + id + ";";
			
			//Linha abaixo para fazer o texto no banco de dados
			//System.out.println(sql);
			
			//Prepare para receber os dados
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//Excecutar o comando
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
			
		}
	}

}
