package br.com.qcon.model;

public class Usuario {

	private String	senha;
	private String	confirmacao;

	public String getConfirmacao() {

		return confirmacao;
	}

	public void setConfirmacao(String usuario) {

		this.confirmacao = usuario;
	}

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	@Override
	public String toString() {

		return "Usuario [senha=" + senha + ", confirmacao=" + confirmacao + "]";
	}

}
