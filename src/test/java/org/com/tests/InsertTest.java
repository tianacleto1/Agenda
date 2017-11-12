package org.com.tests;

import java.util.Calendar;
import org.com.dao.ContatoDAO;
import org.com.model.Contato;

public class InsertTest {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Teste 123");
		contato.setEmail("teste123@gmail.com");
		contato.setEndereco("r. Alvorada, 41");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.insert(contato);
		
		System.out.println("Contato saved...");
	}
}
