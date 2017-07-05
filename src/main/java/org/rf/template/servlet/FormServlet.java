package org.rf.template.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Servlet implementation class FormServlet
 */
@Component("FormServlet")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = -6506682026701304964L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String field1 = request.getParameter("field1");
		String field2 = request.getParameter("field2");

		response.sendRedirect("test-home");

	}
}