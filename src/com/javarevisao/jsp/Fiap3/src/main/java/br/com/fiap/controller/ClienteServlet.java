package br.com.fiap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// repare no import do cliente de bean
import br.com.fiap.bean.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/Cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente("Carlos", 30);
		
		// Armazena o objeto 'cliente' no escopo do request, associando-o à chave "clienteKey".
		// Essa chave será usada na JSP para recuperar o objeto via ${clienteKey} ou request.getAttribute("clienteKey")
		request.setAttribute("clienteKey", cliente);
		
		// Obtém um RequestDispatcher apontando para "BeanResultado.jsp" e faz um FORWARD:
		// o processamento é transferido para a JSP no LADO DO SERVIDOR (sem redirect ao navegador),
		// mantendo a mesma requisição (e os atributos nela armazenados, como o "clienteKey")
		request.getRequestDispatcher("BeanResultado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
