package br.com.qcon.mb;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.qcon.model.Endereco;
import br.com.qcon.model.Livro;

@Model
public class LivroMB {

	private Livro			livro		= new Livro();
	private Endereco		endereco	= new Endereco();

	@Inject
	private FacesContext	facesContext;
	@Inject
	private EntityManager	em;

	//testar JBoSS EL
	public void montaLivro() {

		livro = new Livro("Livro do Rafa");

		//		flash.putNow("livroFlash", livro);
		//		flash.keep("livroFlash");
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
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
		this.livro = em.find(Livro.class, livro.getId());
	}
}
