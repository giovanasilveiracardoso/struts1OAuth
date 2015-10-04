package br.com.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(request.getSession().getAttribute("usuarioFacebook") != null){
			return mapping.findForward("hello");
		}else{
			return mapping.findForward("falha");
		}
	}
	
}
