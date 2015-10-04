package br.com.struts.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.struts.controller.LoginFacebookController;

public class LoginResponseServlet extends HttpServlet {

	private static final long serialVersionUID = -2515924426598291533L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		LoginFacebookController loginFacebook = new LoginFacebookController();
		
		try {
			req.getSession().setAttribute("usuarioFacebook", loginFacebook.obterUsuarioFacebook(req.getParameter("code")));
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		
		resp.sendRedirect("hello.do");
	}
	
}
