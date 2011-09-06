package br.com.qcon.mb;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.logging.Logger;
import org.jboss.seam.international.status.Messages;
import br.com.qcon.model.Livro;

@Model
public class LivroMB {

	private Livro			livro	= new Livro();

	@Inject
	private Messages		messages;
	@Inject
	private EntityManager	em;

	@Inject
	private Logger			logger;

	public void cadastrar() {

		em.persist(livro);
		//mencionar artigo no blog, DI em generic DAOs

		logger.info("logger funcionando - um livro foi adicionado");
		messages.info("Um livro {0} foi salvo com sucesso", livro);
	}

	public Livro getLivro() {

		return livro;
	}

	public void buscar() {

		System.out.println("indo buscar o livro" + livro.getId());
		this.livro = em.find(Livro.class, livro.getId());
	}

}
