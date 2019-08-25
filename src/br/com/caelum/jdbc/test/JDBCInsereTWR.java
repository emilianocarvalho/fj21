package br.com.caelum.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

public class JDBCInsereTWR {

    public static void main(String[] args) throws SQLException {
	
	// try-with-resources
	try (Connection con = new ConnectionFactory().getConnection()) {

	    String sql = "insert into contatos" + "(nome, email, endereco, dataNascimento) " + "values (?,?,?,?)";
	    PreparedStatement stmt = con.prepareStatement(sql);

	    stmt.setString(1, "Caelum");
	    stmt.setString(2, "contato@caelum.com.br");
	    stmt.setString(3, "Rua Vergueiro 3185 cj57");
	    stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

	    stmt.execute();
	    stmt.close();

	    System.out.println("Gravado!");
	    con.close();
	} catch (SQLException e) {
	    System.out.println(e);
	} 
    }

}
