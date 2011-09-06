package br.com.qcon.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.jboss.seam.faces.validation.InputField;

@FacesValidator("senhaValidator")
public class SenhaValidator implements Validator {

	@Inject
	@InputField
	private String	senha;
	@Inject
	@InputField
	private String	confirmacao;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		if (!senha.equals(confirmacao)) {
			throw new ValidatorException(new FacesMessage("Confirmação diferente da senha"));
		}
	}
}
