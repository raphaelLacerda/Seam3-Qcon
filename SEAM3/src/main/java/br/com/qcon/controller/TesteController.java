package br.com.qcon.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.jboss.seam.faces.event.qualifier.After;
import org.jboss.seam.faces.event.qualifier.Before;
import org.jboss.seam.faces.event.qualifier.InvokeApplication;
import org.jboss.seam.faces.event.qualifier.RenderResponse;
import org.jboss.seam.international.status.Messages;
import org.jboss.seam.solder.el.Expressions;
import org.jboss.seam.solder.resourceLoader.Resource;
import br.com.qcon.model.Livro;

@Named
@RequestScoped
//@Model
//@Veto
public class TesteController {

	//	@PersistenceContext
//	@Inject
//	private EntityManager	entityManager;
	@Inject
	private Messages		messages;
	private String			hello	= "SAY HELLo";

	@Inject
	private Expressions		expressions;

	@Inject
	@Resource("WEB-INF/classes/META-INF/beans.xml")
	private URL				beansXml;

	@Inject
	@Resource("WEB-INF/web.xml")
	private InputStream		webXml;

	//	@Inject
	//	private BeanManager		beanManager;

	@Inject
	private FacesContext	facesContext;

//	@Transactional(TransactionPropagation.REQUIRED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvaLivro() throws IOException {

//		System.out.println(entityManager);
		Livro livro = new Livro("Livro 1 Teste");
//		entityManager.persist(livro);
		//IAE? vai funcionar???
		messages.info("Um livro {0} foi salvo com sucesso", livro);

		String evaluateValueExpression = expressions.evaluateValueExpression("#{testeController.hello}", String.class);
		System.out.println(evaluateValueExpression);

		//		TesteController beanFromScope = (TesteController) beanManager.getBeanFromScope("testeController", facesContext);
		//		System.out.println(beanFromScope.getHello());
	}

	public String getHello() throws IOException {

//		System.out.println(entityManager);
		System.out.println(webXml);
		return hello;
	}

	public void observeBefore(@Observes @Before PhaseEvent e) {

		System.out.println("before any event");
	}

	public void observeAfter(@Observes @After PhaseEvent e) {

		System.out.println("after any event");

	}

	public void observeRenderResponse(@Observes @After @RenderResponse PhaseEvent e) {

		System.out.println("before render event");
	}

	public void observeInvokeApplication(@Observes @InvokeApplication PhaseEvent e) {

		System.out.println("invoke" + e.getSource());

	}
}
