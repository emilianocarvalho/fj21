package br.com.caelum.jdbc.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.model.Contato;

public class TestaContatoDAO {

    public static void main(String[] args) {
	
	String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ";
	Locale locale = new Locale("pt", "BR");
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);

	// Adiciona Contato
	Contato contato = new Contato();
	contato.setNome("Caelum");
	contato.setEmail("contato@email.com");
	contato.setEndereco("Rua Vergueiro 3185 cj57");
	contato.setDataNascimento(Calendar.getInstance());
	
	ContatoDAO dao = new ContatoDAO();
	
	dao.adiciona(contato);
	
	System.out.println("Gravado DAO!");
	System.out.println("Nome: " + contato.getNome());
	System.out.println("Email: " + contato.getEmail());
	System.out.println("Endereço: " + contato.getEndereco());
	System.out.println(
		"Data de Nascimento: " + simpleDateFormat.format(contato.getDataNascimento().getTime()) + "\n");
	
	// Pesquisa Contato
	int id = 1;
	Contato contatoloc = dao.pesquisar(id);
	
	System.out.println("CONTATO PESQUISA");
	System.out.println("ID LOCALIZADO: " + contatoloc.getId() + "\n");
	
	// Altera Contato
	contatoloc.setEmail("novoemailalterado@email.com");
	contatoloc.setNome("Caelum Cursos");
	dao.altera(contatoloc);

	int idAlt = contatoloc.getId().intValue();
	Contato contatoAlterado = dao.pesquisar(idAlt);
	System.out.println("CONTATO ALTERADO");
	System.out.println("ID ALTERADO: " + idAlt );
	System.out.println("ID: " + contatoAlterado.getId());
	System.out.println("Nome: " + contatoAlterado.getNome());
	System.out.println("Email: " + contatoAlterado.getEmail());
	System.out.println("Endereço: " + contatoAlterado.getEndereco());
	System.out.println(
		"Data de Nascimento: " + simpleDateFormat.format(contatoAlterado.getDataNascimento().getTime()) + "\n");
	
	// Remove contato
	dao.remove(contatoAlterado);
	System.out.println("Contato Removido DAO!");
	
    }

}
