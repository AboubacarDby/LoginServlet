package fr.cesi.loginservletapp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupère la session existante sans en créer une nouvelle
		HttpSession session = request.getSession(false);
		
		//vérifier si l'utilisateur est connecter, afficher la page history
		if (session != null && session.getAttribute("username") != null){
			request.getRequestDispatcher("history.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}



}
