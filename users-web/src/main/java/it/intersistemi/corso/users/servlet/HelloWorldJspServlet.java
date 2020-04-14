package it.intersistemi.corso.users.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloWorldJsp")
public class HelloWorldJspServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String who = request.getParameter("who");
		String helloMessage = null;
		if (who != null) {
			helloMessage = "Hello " + who + "!!!";
		} else {
			helloMessage = "Hello World!!!";
		}

		request.setAttribute("who", who);
		request.setAttribute("helloMessage", helloMessage);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
