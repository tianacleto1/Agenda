package org.com.tests;

import java.text.SimpleDateFormat;
import java.util.List;
import org.com.dao.ContatoDAO;
import org.com.model.Contato;

public class GetAllTest {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getAll();
		
		for (Contato contato : contatos) {
			System.out.println("\nID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
			System.out.println("Data Nascimento: " + format.format(contato.getDataNascimento().getTime()));
		}
	}
}
