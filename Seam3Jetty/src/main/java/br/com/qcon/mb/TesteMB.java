package br.com.qcon.mb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.seam.solder.resourceLoader.Resource;
import org.jboss.seam.solder.unwraps.Unwraps;

@Model
//@Veto
public class TesteMB {

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

	//must be proxyable
	@Unwraps
	public A ola() {

		System.out.println("hello");
		return new A();
	}

	/* The following Java types cannot be proxied by the container: • classes
	 * which don't have a non-private constructor with no parameters, and •
	 * classes which are declared final or have a final method, • arrays and
	 * primitive types. */
	class A {

	}
}
