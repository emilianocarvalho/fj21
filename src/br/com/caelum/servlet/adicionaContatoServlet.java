package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.servlet.dao.ContatoDAO;
import br.com.caelum.servlet.model.Contato;

@WebServlet("/adicionarContato")
public class adicionaContatoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	PrintWriter out = resp.getWriter();

	// parametros da request
	String nome = req.getParameter("nome");
	String endereco = req.getParameter("endereco");
	String email = req.getParameter("email");
	String dataEmTexto = req.getParameter("dataNascimento");

	Calendar dataNascimento = null;

	try {
	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
	    dataNascimento = Calendar.getInstance();
	    dataNascimento.setTime(date);
	} catch (ParseException e) {
	    out.println("Erro de conversão da data");
	    return;
	}

	Contato contato = new Contato();
	contato.setNome(nome);
	contato.setEmail(email);
	contato.setEndereco(endereco);
	contato.setDataNascimento(dataNascimento);

	ContatoDAO dao = new ContatoDAO();
	dao.adiciona(contato);

	out.println("<html>");
	out.println("<body>");
	out.println("Contato " + contato.getNome() + " adicionado com sucesso");
	out.println("</body>");
	out.println("</html>");

    }

}
