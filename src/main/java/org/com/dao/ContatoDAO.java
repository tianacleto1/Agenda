package org.com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.com.model.Contato;
import org.com.utils.ConnectionFactory;

public class ContatoDAO {

	private Connection connection;
	
	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Contato contato) {
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());
			statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getAll() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			String sql = "SELECT * FROM contatos";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id_contato"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(date);
				contatos.add(contato);
			}
			
			rs.close();
			statement.close();
			
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato getById(Long id) {
		try {
			Contato contato = null;
			String sql = "SELECT * FROM contatos WHERE id_contato = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getLong("id_contato"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(date);
			}
			
			rs.close();
			statement.close();
			
			return contato;
		} catch (SQLException e) { 
			throw new RuntimeException(e);
		}
	}
	
	public void update(Contato contato) {
		try {
			String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id_contato = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());
			statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			statement.setLong(5, contato.getId());
			
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Long id) {
		try {
			String sql = "DELETE FROM contatos WHERE id_contado = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, id);
			
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
