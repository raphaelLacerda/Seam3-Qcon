package br.com.qcon.log;

import org.jboss.logging.LogMessage;
import org.jboss.seam.solder.logging.MessageLogger;
import org.jboss.seam.solder.messages.Message;
import br.com.qcon.model.Livro;

@MessageLogger
public interface LivroLogger {

	@LogMessage
	@Message("Livro %s adicionado")
	void livroAdicionado(Livro livro);

	@LogMessage
	@Message("Livro %s adicionado")
	void livroRemovido(Livro livro);

	//How to Define the level?
}
