package br.com.caelum.jdbc.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.model.Funcionario;

public class TestaFuncionarioDAO {

    public static void main(String[] args) {
	
	// Adiciona Funcionario
	Funcionario funcionario = new Funcionario();
	funcionario.setNome("Caelum");
	funcionario.setUsuario("funcionario@email.com");
	funcionario.setSenha("1234");
	
	FuncionarioDAO dao = new FuncionarioDAO();
	
	dao.adiciona(funcionario);
	
	System.out.println("Gravado DAO!");
	System.out.println("Nome: " + funcionario.getNome());
	System.out.println("Usuario: " + funcionario.getUsuario());
	System.out.println("Senha: " + funcionario.getSenha() + "\n");
	
	// Pesquisa Funcionario
	int id = 1;
	Funcionario funcionarioloc = dao.pesquisar(id);
	
	System.out.println("FUNCIONARIO PESQUISA");
	System.out.println("ID LOCALIZADO: " + funcionarioloc.getId() + "\n");
	
	// Altera Funcionario
	funcionarioloc.setNome("Caelum Funcionário");
	funcionarioloc.setSenha("4321");
	dao.altera(funcionarioloc);

	int idAlt = funcionarioloc.getId().intValue();
	Funcionario funcionarioAlterado = dao.pesquisar(idAlt);
	System.out.println("FUNCIONARIO ALTERADO");
	System.out.println("ID ALTERADO: " + idAlt );
	System.out.println("ID: " + funcionarioAlterado.getId());
	System.out.println("Nome: " + funcionarioAlterado.getNome());
	System.out.println("Usuario: " + funcionarioAlterado.getUsuario());
	System.out.println("Senha: " + funcionarioAlterado.getSenha() + "\n");

	// Remove funcionario
	dao.remove(funcionarioAlterado);
	System.out.println("Funcionario Removido DAO!");
	
    }

}
