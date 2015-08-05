package ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		PrintWriter writer = resp.getWriter();
		writer.println("<h4>Accepted the request<h4/>");
		writer.println("<h4>Accepted the request<h4/>");
		resp.sendRedirect("/EndOfRidePage.jsp");
	}
}
