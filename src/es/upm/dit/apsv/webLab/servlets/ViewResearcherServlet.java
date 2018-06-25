package es.upm.dit.apsv.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.webLab.dao.ResearcherDAO;
import es.upm.dit.apsv.webLab.dao.ResearcherDAOImpl;

@WebServlet("/ViewResearcherServlet")
public class ViewResearcherServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String rsi = req.getParameter("rsi");
			ResearcherDAO dao = ResearcherDAOImpl.getInstance();
			req.getSession().setAttribute("researcher", dao.read(rsi));
			resp.sendRedirect("/APSV/ViewResearcher.jsp");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
