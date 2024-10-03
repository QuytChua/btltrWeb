package vn.iotstar.Controllers.manager;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.Models.UserModel;

@WebServlet(urlPatterns = { "/manager/home" })
public class ManagerHomeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			UserModel u = (UserModel) session.getAttribute("account");
			req.setAttribute("username", u.getUserName());
			req.setAttribute("password", u.getPassWord());
			req.setAttribute("email", u.getEmail());
			req.setAttribute("fullname", u.getFullName());
			req.setAttribute("phone", u.getPhone());
		}
		req.getRequestDispatcher("/views/manager/home.jsp").forward(req, resp);
	}
}
