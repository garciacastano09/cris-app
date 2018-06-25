package es.upm.dit.apsv.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.webLab.dao.PublicationDAO;
import es.upm.dit.apsv.webLab.dao.PublicationDAOImpl;
import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImpl;
import es.upm.dit.apsv.webLab.dao.model.Publication;

@WebServlet("/CreatePublicationServlet")
public class CreatePublicationServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PublicationDAO pubDAO = PublicationDAOImpl.getInstance();
			ResearcherDAO resDAO = ResearcherDAOImpl.getInstance();

			String authId = req.getParameter("authId");
			
			Publication p = new Publication(
					req.getParameter("id"), 
					req.getParameter("title"), 
					Integer.parseInt(req.getParameter("citecount"))
			);
			
			p.getAuthors().add(resDAO.read(authId));
			pubDAO.update(p);
					
			resp.sendRedirect("ViewResearcherServlet?rsi="+authId);

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
