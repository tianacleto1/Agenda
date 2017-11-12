package org.com.tests;

import java.text.SimpleDateFormat;
import org.com.dao.ContatoDAO;
import org.com.model.Contato;

public class GetByIdTest {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		Contato contato = dao.getById(10L);
		
		if (contato != null) {
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
			System.out.println("Data Nascimento: " + format.format(contato.getDataNascimento().getTime()));
		} else {
			System.out.println("Contato not found...");
		}
	}
}
