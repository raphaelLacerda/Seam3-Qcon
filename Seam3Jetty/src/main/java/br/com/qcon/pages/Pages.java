package br.com.qcon.pages;

import org.jboss.seam.faces.rewrite.UrlMapping;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;

@ViewConfig
public interface Pages {

	static enum Pages1 {

		@ViewPattern("/get.xhtml")
		@UrlMapping(pattern = "/pesquisa/#{id}")
		LIVRO,

		@ViewPattern("/index.xhtml")
		@UrlMapping(pattern = "/home")
		PRINCIPAL;
	}
}
