package br.com.struts.model;

import org.json.JSONObject;

public class UsuarioFacebook {

	private Long id; 
	private String name; 
	private Integer expires;
	private String accessToken;

	public UsuarioFacebook(JSONObject jsonUsuario, Integer expires, String accessToken){
		this.id = jsonUsuario.getLong("id");
		this.name = jsonUsuario.getString("name");
		this.expires = expires;
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "Id=" + id + "\nName=" + name + "\nExpires=" + expires + "\nAccessToken=" + accessToken;
	}
	
	public String getName() {
		return name;
	}
}
