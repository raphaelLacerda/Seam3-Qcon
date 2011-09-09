package br.com.qcon.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.jboss.seam.solder.core.ExtensionManaged;

public class JPAUtil {

	@PersistenceUnit(unitName="seam3")
	@Produces
	@ExtensionManaged
	@RequestScoped
	EntityManagerFactory entityManagerFactory;
}
