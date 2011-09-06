package br.com.qcon.mb;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.jboss.seam.international.status.Messages;
import br.com.qcon.model.Usuario;

@Model
public class LoginMB {

	private Usuario		usuario	= new Usuario();

	@Inject
	private Messages	messages;

	public void logar() {

		System.out.println("Usuario logado: " + usuario);
		messages.info("Usuário " + usuario);
	}

	public Usuario getUsuario() {

		return usuario;
	}

	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;
	}
}
