package br.com.struts.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.json.JSONObject;

import br.com.struts.model.UsuarioFacebook;

public class LoginFacebookController {

    private static final String client_secret = "senha";
    private static final String client_id = "id"; 
    private static final String redirect_uri = "http://localhost:8080/struts1OAuth/loginResponse";

	public UsuarioFacebook obterUsuarioFacebook(String code) throws Exception {
		String retorno = readURL(new URL(this.getAuthURL(code)));

		Integer expires = null;
		String accessToken = null;
		
		String[] pairs = retorno.split("&");
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			
			if (kv.length != 2) {				
				throw new Exception("Resposta auth inesperada.");				
			} else {
				if (kv[0].equals("access_token")) {
					accessToken = kv[1];
				}
				if (kv[0].equals("expires")) {
					expires = Integer.valueOf(kv[1]);
				}
			}
		}

		JSONObject resp = new JSONObject(readURL(new URL("https://graph.facebook.com/me?access_token=" + accessToken)));

		return new UsuarioFacebook(resp, expires, accessToken);
	}

	private String readURL(URL url) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = url.openStream();
		int r;
		while ((r = is.read()) != -1) {
			baos.write(r);
		}
		return new String(baos.toByteArray());
	}

	public String getLoginRedirectURL() {
		return "https://graph.facebook.com/oauth/authorize?client_id="
				+ client_id + "&display=page&redirect_uri=" + redirect_uri
				+ "&scope=email,publish_actions,public_profile";
	}

	public String getAuthURL(String authCode) {
		return "https://graph.facebook.com/oauth/access_token?client_id="
				+ client_id + "&redirect_uri=" + redirect_uri
				+ "&client_secret=" + client_secret + "&code=" + authCode;
	}

}
