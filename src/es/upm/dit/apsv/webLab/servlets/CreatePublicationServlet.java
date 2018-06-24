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
import es.upm.dit.apsv.webLab.dao.model.Researcher;

@WebServlet("/CreatePublicationServlet")
public class CreatePublicationServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		int citeCount = Integer.parseInt(req.getParameter("citecount"));
		String authId = req.getParameter("authId");
		
		ResearcherDAO daor = ResearcherDAOImpl.getInstance();
		Researcher r = daor.read(authId);
		
		PublicationDAO daop = PublicationDAOImpl.getInstance();
		Publication p = new Publication(id, title, citeCount);
		p.getAuthors().add(r);
		
		daop.update(p);
				
		resp.sendRedirect("ViewResearcherServlet?rsi="+authId);
	}
}
