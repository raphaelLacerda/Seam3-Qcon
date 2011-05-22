package br.com.qcon.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.jboss.seam.faces.validation.InputField;

@FacesValidator("locationValidator")
public class LocalitonValidator implements Validator {

	@Inject
	@InputField
	private String	cidade;
	@Inject
	@InputField
	private String	estado;
	@Inject
	@InputField
	private String	cep;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		System.out.println(cidade);
		System.out.println(estado);
		System.out.println(cep);
	}
}
