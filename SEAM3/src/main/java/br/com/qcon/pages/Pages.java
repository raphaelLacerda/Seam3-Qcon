package br.com.qcon.pages;

import org.jboss.seam.faces.rewrite.UrlMapping;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;

@ViewConfig
public interface Pages {

	static enum Pages1 {

		@UrlMapping(pattern = "/busca/livro/#{id}")
		@ViewPattern("/livro.xhtml")
		LIVRO;
	}
}
