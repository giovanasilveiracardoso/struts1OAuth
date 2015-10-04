package br.com.struts.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.struts.controller.LoginFacebookController;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -2515924426598291533L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginFacebookController loginFacebook = new LoginFacebookController();
		
		resp.sendRedirect(loginFacebook.getLoginRedirectURL());
	}
	
}
