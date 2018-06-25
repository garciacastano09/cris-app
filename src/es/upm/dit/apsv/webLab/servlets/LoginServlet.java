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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (req.getUserPrincipal() == null) {
				resp.sendRedirect("/index.jsp");
			}
			String userGmail = req.getUserPrincipal().getName();
			String user = req.getParameter("user");
			ResearcherDAO dao = ResearcherDAOImplOfy.getInstance();
			Researcher r = dao.readEmail(user);
			if ((user != null) && user.equals("root")) { 
				req.getSession().setAttribute("user",
						new Researcher("0", "root", userGmail, ""));
				resp.sendRedirect("/RootView.jsp");
			} else if (r != null && user.equals(r.getName())){
				req.getSession().setAttribute("user", r);
				req.getSession().setAttribute("researcher", r);	
				resp.sendRedirect("/ViewProfile.jsp");
			} else {
				resp.sendRedirect("/index.jsp");			
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
