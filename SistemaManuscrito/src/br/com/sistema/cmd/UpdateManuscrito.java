package br.com.sistema.cmd;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class UpdateManuscrito {

	public static void main(String[] args) {
		try {
			//abri conexao com banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//Vamos salvar nas variaveis os  dados que serão inserido no banco
			//Importa a classe de transição de dados do sql
			Manuscrito manuscrito = new Manuscrito();
			
			
			//Envia os dados para a classe Manuscrito()
			manuscrito.setId(JOptionPane.showInputDialog("Entre com o ID a ser alterado"));
			manuscrito.settitulo(JOptionPane.showInputDialog("Entre com o Titulo do Manuscrito"));
			manuscrito.setAutor(JOptionPane.showInputDialog("Entre com o nome do Autor"));
			
			String sql = "Update manuscrito set titulo = ?, autor = ? where id = ?,";
			
			
			
		//Update manuscrito set 
		//titulo = 'manuscrito.getTitulo()' and
		//autor = 'manuscrito.getAutor()'
		//where id = 'manuscrito.getID()';
			
			
			System.out.println(sql);
			
			//Criando um comando para passar o Sql
			java.sql.PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, manuscrito.gettitulo());
			cmd.setString(2, manuscrito.getAutor());
			cmd.setString(3, manuscrito.getId());
			
			cmd.executeUpdate();
			
			JOptionPane.showConfirmDialog(null, "Dado atualizado com sucesso");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
