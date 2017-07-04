package org.rf.template.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rf.template.util.VerifyRecaptcha;
import org.springframework.stereotype.Component;

/**
 * Servlet implementation class LoginServlet
 */
@Component("LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -6506682026701304964L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		// get reCAPTCHA request param
		String gRecaptchaResponse = request
				.getParameter("g-recaptcha-response");
		System.out.println(gRecaptchaResponse);
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

		
		// logging example
		System.out.println("User=" + user + "::password=" + pwd
				+ "::Captcha Verify" + verify);

		if (user.equals("roberto") && pwd.equals("fernandez") && verify) {
			response.sendRedirect("test-home");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/login");
			PrintWriter out = response.getWriter();
			if (verify) {
				out.println("<font color=red>Either user name or password is wrong.</font>");
			} else {
				out.println("<font color=red>You missed the Captcha.</font>");
			}
			rd.include(request, response);
		}
	}
}