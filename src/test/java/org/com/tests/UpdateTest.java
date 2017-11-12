package org.com.tests;

import org.com.dao.ContatoDAO;
import org.com.model.Contato;

public class UpdateTest {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		
		Contato contato = dao.getById(3L);
		contato.setNome("Felipe Santos");
		contato.setEmail("felipe.santos@gmail.com");
		
		dao.update(contato);
	}
}
