package es.upm.dit.apsv.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImpl;
import es.upm.dit.apsv.webLab.dao.model.Researcher;

@WebServlet("/UpdateResearcherServlet")
public class UpdateResearcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String affiliation = req.getParameter("affiliation");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		
		ResearcherDAO dao = ResearcherDAOImpl.getInstance();
		Researcher r = new Researcher(id, name, email, affiliation);
		r.setPassword(password);
		dao.update(r);
		
		resp.sendRedirect("ViewResearcherServlet?rsi="+id);
	}
	

}