package es.upm.dit.apsv.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.webLab.dao.PublicationDAO;
import es.upm.dit.apsv.webLab.dao.PublicationDAOImplOfy;
import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImplOfy;
import es.upm.dit.apsv.webLab.dao.model.Publication;
import es.upm.dit.apsv.webLab.dao.model.Researcher;

@WebServlet("/CreatePublicationServlet")
public class CreatePublicationServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PublicationDAO pubDAO = PublicationDAOImplOfy.getInstance();
			ResearcherDAO resDAO = ResearcherDAOImplOfy.getInstance();

			String authId = req.getParameter("authId");
			
			Publication p = new Publication(
					req.getParameter("id"), 
					req.getParameter("title"), 
					Integer.parseInt(req.getParameter("citecount"))
			);
			
			Researcher r = resDAO.read(authId);
			r.getPublications().add(p);
			pubDAO.update(p);
					
			resp.sendRedirect("ViewResearcherServlet?rsi="+authId);

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
