package es.upm.dit.apsv.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.webLab.dao.ResearcherDAOImpl;
import es.upm.dit.apsv.webLab.dao.model.Researcher;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final String admin = "root";
	private final String adminPassword = "root";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String user = req.getParameter("user");
			String pwd = req.getParameter("pwd");
			
			ResearcherDAOImpl dao = ResearcherDAOImpl.getInstance();
			Researcher r = dao.readUser(user, pwd);

			if (admin.equals(user) && adminPassword.equals(pwd)) {
		               // dummy Researcher for the root user 
				req.getSession().setAttribute("user", new Researcher("", "root", "", ""));
				resp.sendRedirect("/APSV/RootView.jsp");
			} else if (null != r){
				req.getSession().setAttribute("user", r);
				req.getSession().setAttribute("researcher", r);
				resp.sendRedirect("/APSV/ViewResearcher.jsp");
			} else{
				resp.sendRedirect("/APSV/index.html");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
