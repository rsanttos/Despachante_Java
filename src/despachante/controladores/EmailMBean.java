package despachante.controladores;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import despachante.email.EmailService;
import despachante.modelo.Email;

@ManagedBean
@RequestScoped
public class EmailMBean {
	private Email email;
	private EmailService emailservice;

	public EmailMBean() {
		this.email = new Email();
		this.emailservice = new EmailService();
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public EmailService getEmailservice() {
		return emailservice;
	}

	public void setEmailservice(EmailService emailservice) {
		this.emailservice = emailservice;
	}
	
	public void enviaEmail(){
		EmailService.enviarEmail(this.email.getFrom(), this.email.getTo(), this.email.getAssunto(), this.email.getTexto());
	}
	
}
