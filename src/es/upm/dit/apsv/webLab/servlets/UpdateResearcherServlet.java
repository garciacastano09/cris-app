package es.upm.dit.apsv.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImplOfy;
import es.upm.dit.apsv.webLab.dao.model.Researcher;

@WebServlet("/UpdateResearcherServlet")
public class UpdateResearcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ResearcherDAO resDAO = ResearcherDAOImplOfy.getInstance();
			String id = req.getParameter("id");
			String password = req.getParameter("pwd");
			
			Researcher r = new Researcher(
					id, 
					req.getParameter("name"), 
					req.getParameter("email"), 
					req.getParameter("affiliation")
			);
			r.setPassword(password);
			resDAO.update(r);
			resp.sendRedirect("ViewResearcherServlet?rsi="+id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}