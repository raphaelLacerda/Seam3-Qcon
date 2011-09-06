package br.com.qcon.mb;

import java.io.InputStream;
import java.net.URL;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.jboss.seam.solder.resourceLoader.Resource;

@Model
public class RecursoMB {

	@Inject
	@Resource("WEB-INF/classes/META-INF/beans.xml")
	private URL			beansXml;
	@Inject
	@Resource("WEB-INF/classes/META-INF/beans.xml")
	private InputStream	beansXmlFile;
	@Inject
	@Resource("WEB-INF/web.xml")
	private InputStream	webXml;

	public void processar() {

		System.out.println(beansXml);
		System.out.println(beansXmlFile);
		System.out.println(webXml);
	}

}
