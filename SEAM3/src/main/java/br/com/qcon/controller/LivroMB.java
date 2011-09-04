package br.com.qcon.controller;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.logging.Logger;
import org.jboss.seam.solder.logging.Category;
import br.com.qcon.log.LivroLogger;
import br.com.qcon.model.Endereco;
import br.com.qcon.model.Livro;

@Model
public class LivroMB {

	private Livro			livro		= new Livro();
	private Endereco		endereco	= new Endereco();

	//	@Inject
	//	private Flash				flash;

	@Inject
	private FacesContext	facesContext;
	@Inject
	private EntityManager	em;

	@Inject
	@Category("livro")
	private LivroLogger		log;

	@Inject
	private Logger			logger;

	//testar JBoSS EL
	public void montaLivro() {

		livro = new Livro("Livro do Rafa");

		log.livroAdicionado(livro);
		log.livroRemovido(livro);
		
		
		logger.info("logger funcionando - um livro foi adicionado");
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
