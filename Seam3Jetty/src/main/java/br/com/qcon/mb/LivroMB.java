package br.com.qcon.mb;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.logging.Logger;
import org.jboss.seam.international.status.Messages;
import org.jboss.seam.solder.logging.Category;
import br.com.qcon.log.LivroLogger;
import br.com.qcon.model.Endereco;
import br.com.qcon.model.Livro;

@Model
public class LivroMB {

	private Livro			livro		= new Livro();
	private Endereco		endereco	= new Endereco();

	@Inject
	private Messages		messages;
	@Inject
	private EntityManager	em;

	@Inject
	@Category("livro")
	private LivroLogger		log;

	@Inject
	private Logger			logger;

	public void montaLivro() {


		em.persist(livro);
		//mencionar artigo no blog, DI em generic DAOs
		
		log.livroAdicionado(livro);
		log.livroRemovido(livro);
		logger.info("logger funcionando - um livro foi adicionado");

		messages.info("Um livro {0} foi salvo com sucesso", livro);
	}

	public void atualiza(String a) {

		System.out.println(a);
		System.out.println(endereco);
		System.out.println("atualizando");
	}

	public Livro getLivro() {

		return livro;
	}

}
