package br.com.qcon.util;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.jboss.seam.solder.core.ExtensionManaged;

public class JPAUtil {

	@ExtensionManaged
	@Produces
	@PersistenceUnit
	//	@SessionScoped
	@RequestScoped
	EntityManagerFactory	producerField;

	/* This is just an ordinary resource producer field as defined by the CDI
	 * specification, however the presence of the @ExtensionManaged annotation
	 * tells seam to create a seam managed persistence context from this
	 * EntityManagerFactory. This managed persistence context can be injected
	 * normally, and has the same scope and qualifiers that are specified on the
	 * resource producer field.
	 * 
	 * 
	 * The more eagle eyed among you may have noticed that the resource producer
	 * field appears to be conversation scoped, which the CDI specification does
	 * not require containers to support. This is actually not the case, as the
	 * 
	 * @ConversationScoped annotation is removed by the seam persistence
	 * portable extension. It only specifies the scope of the created SMPC, not
	 * the EntityManagerFactory. */
}
