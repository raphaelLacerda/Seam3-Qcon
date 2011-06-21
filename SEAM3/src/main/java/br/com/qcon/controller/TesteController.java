package br.com.qcon.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Observes;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.jboss.seam.faces.context.conversation.Begin;
import org.jboss.seam.faces.context.conversation.End;
import org.jboss.seam.faces.event.qualifier.After;
import org.jboss.seam.faces.event.qualifier.Before;
import org.jboss.seam.faces.event.qualifier.InvokeApplication;
import org.jboss.seam.faces.event.qualifier.RenderResponse;
import org.jboss.seam.international.status.Messages;
import org.jboss.seam.solder.resourceLoader.Resource;
import br.com.qcon.model.Livro;

@Named
@ConversationScoped
//@Model
//@Veto
public class TesteController implements Serializable {

	//	@PersistenceContext
	@Inject
	private EntityManager	entityManager;
	@Inject
	private Messages		messages;
	private String			hello	= "SAY HELLo";

	//	@Inject
	//	private Expressions		expressions;

	@Inject
	@Resource("WEB-INF/classes/META-INF/beans.xml")
	private URL				beansXml;

	//	@Inject
	//	@Resource("WEB-INF/web.xml")
	//	private InputStream		webXml;

	//	@Inject
	//	private BeanManager		beanManager;

	@Inject
	private FacesContext	facesContext;

	@Inject
	private Conversation	conversation;

	@PostConstruct
	@Begin(timeout = 30000000)
	public void init() {

		System.out.println("iniciando");
		conversation.begin();
	}

	@End
	public void exit() {

		System.out.println("falou");
		conversation.end();
	}

	//	@Transactional(TransactionPropagation.REQUIRED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String salvaLivro() throws IOException {

		//		System.out.println(entityManager);
		Livro livro = new Livro("Livro 1 Teste");
		entityManager.persist(livro);
		//IAE? vai funcionar???
		messages.info("Um livro {0} foi salvo com sucesso", livro);

		//		String evaluateValueExpression = expressions.evaluateValueExpression("#{testeController.hello}", String.class);
		//		System.out.println(evaluateValueExpression);

		//		TesteController beanFromScope = (TesteController) beanManager.getBeanFromScope("testeController", facesContext);
		//		System.out.println(beanFromScope.getHello());

		return "index2?faces-redirect=true";
	}

	public String getHello() throws IOException {

		System.out.println(entityManager);
		//		System.out.println(webXml);
		System.out.println(beansXml);
		System.out.println(facesContext);
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
