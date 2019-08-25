package br.com.caelum.jdbc.test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.model.Contato;

public class TestaListaDAO {

    public static void main(String[] args) {

	ContatoDAO dao = new ContatoDAO();

	String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ";
	Locale locale = new Locale("pt", "BR");
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);

	List<Contato> contatos = dao.getLista();

	for (Contato contato : contatos) {
	    System.out.println("Nome: " + contato.getNome());
	    System.out.println("Email: " + contato.getEmail());
	    System.out.println("Endereço: " + contato.getEndereco());
	    System.out.println(
		    "Data de Nascimento: " + simpleDateFormat.format(contato.getDataNascimento().getTime()) + "\n");

	}

	int id = 4;
	Contato contato = dao.pesquisar(id);
	System.out.println("CONTATO LOCALIZADO");
	System.out.println("ID PESQUISADO: " + id );
	System.out.println("ID: " + contato.getId());
	System.out.println("Nome: " + contato.getNome());
	System.out.println("Email: " + contato.getEmail());
	System.out.println("Endereço: " + contato.getEndereco());
	System.out.println(
		"Data de Nascimento: " + simpleDateFormat.format(contato.getDataNascimento().getTime()) + "\n");

    }

}
