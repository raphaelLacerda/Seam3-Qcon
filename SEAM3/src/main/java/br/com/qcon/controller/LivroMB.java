package br.com.qcon.controller;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.faces.context.Flash;
import javax.inject.Inject;
import org.jboss.seam.solder.core.Requires;
import br.com.qcon.model.Endereco;
import br.com.qcon.model.Livro;

//N‹o funfou
//@RenderScoped
//@Named
@Model
@Requires(value = "Flash")
public class LivroMB implements Serializable {

	private static final long	serialVersionUID	= 1L;
	private Livro				livro				= new Livro();
	private Endereco			endereco			= new Endereco();

	@Inject
	private Flash				flash;

	//testar JBoSS EL
	public void montaLivro() {

		livro = new Livro("Livro do Rafa");

		flash.putNow("livroFlash", livro);
		flash.keep("livroFlash");
	}

	public void atualiza(String a) {

		System.out.println(a);
		System.out.println(endereco);
		System.out.println("atualizando");
	}

	public Livro getLivro() {

		return livro;
	}

	public Endereco getEndereco() {

		return endereco;
	}

	public void buscaLivro() {

		System.out.println("indo buscar o livro" + livro.getId());
	}
}
