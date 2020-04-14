package it.intersistemi.corso.users.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloWorld")
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String who = request.getParameter("who");
		String helloMessage = null;
		if (who != null) {
			helloMessage = "Hello " + who + "!!!";
		} else {
			helloMessage = "Hello World!!!";
		}
		response.getWriter().append("<!DOCTYPE html>").append("\n")
			.append("<html>")
			.append("<head><title>").append(helloMessage).append("</title></head>")
				.append("<body>")
					.append("<h1>").append(helloMessage)
					.append("</h1>")
				.append("</body>")
			.append("</html>");
	}

}
