package br.com.fiap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CalculadoraServlet
 */
@WebServlet("/Calculadora")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraServlet() {
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
		double valor1 = Double.parseDouble(request.getParameter("valor1"));
		double valor2 = Double.parseDouble(request.getParameter("valor2"));
		String operacao = request.getParameter("operacao");
		double resultadoCalc = 0;
		
		switch (operacao) {
		case "soma":
			resultadoCalc = valor1 + valor2;
			break;
		case "subtracao":
			resultadoCalc = valor1 - valor2;
			break;
		case "multiplicacao":
			resultadoCalc = valor1 * valor2;
			break;
		case "divisao":
			resultadoCalc = valor1 / valor2;
			break;
		}
		
		request.setAttribute("resultado", resultadoCalc);
		request.getRequestDispatcher("ResultadoCalc.jsp").forward(request, response);
	}

}
