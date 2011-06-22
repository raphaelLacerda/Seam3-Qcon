package br.com.qcon.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.seam.solder.resourceLoader.Resource;

@Model
//@Veto
public class TesteController {

	private String			hello	= "SAY HELLo";

	@Inject
	private EntityManager	entityManager;
	@Inject
	@Resource("WEB-INF/classes/META-INF/beans.xml")
	private URL				beansXml;
	@Inject
	@Resource("WEB-INF/web.xml")
	private InputStream		webXml;
	@Inject
	private FacesContext	facesContext;

	public String getHello() throws IOException {

		System.out.println(webXml);
		System.out.println(beansXml);
		System.out.println(facesContext);
		System.out.println(entityManager);
		return hello;
	}

}
