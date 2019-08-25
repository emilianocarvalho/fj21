package br.com.caelum.jdbc.test;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.model.Contato;

public class TestaContatoDAO {

    public static void main(String[] args) {
	Contato contato = new Contato();
	contato.setNome("Caelum");
	contato.setEmail("contato@email.com");
	contato.setEndereco("Rua Vergueiro 3185 cj57");
	contato.setDataNascimento(Calendar.getInstance());
	
	ContatoDAO dao = new ContatoDAO();
	
	dao.adiciona(contato);
	
	System.out.println("Gravado DAO!");

    }

}
