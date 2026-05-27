package br.com.fiap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet(name = "Produto", urlPatterns = { "/Produto" })
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeProduto = request.getParameter("nomeProduto");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		request.setAttribute("nomeProduto", nomeProduto);
		request.setAttribute("quantidade", quantidade);
		request.setAttribute("preco", preco);
		
		request.getRequestDispatcher("ResultadoProduto.jsp").forward(request, response);
		
	}

}
