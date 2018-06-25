package es.upm.dit.apsv.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImplOfy;

@WebServlet("/ListResearchersServlet")
public class ListResearchersServlet extends HttpServlet {
	

	private static final long serialVersionUID = 2175712387850828259L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ResearcherDAO resDAO = ResearcherDAOImplOfy.getInstance();
		req.getSession().setAttribute("rs", resDAO.readAll());
		resp.sendRedirect("ListResearchers.jsp");
	}

}
