package despachante.email;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class GerenciaEmail {
	public GerenciaEmail() throws EmailException, MalformedURLException {
		enviaEmailSimples();
	}
	/**
	 * envia email simples(somente texto)
	 * @throws EmailException
	 */
	public void enviaEmailSimples() throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("mail.myserver.com");

		email.addTo("rsanttos22@gmail.com", "Ramon Santos"); //destinatário
		email.setFrom("rsanttos1@hotmail.com", "Ramon"); // remetente
		email.setSubject("E-mail teste"); // assunto do e-mail
		email.setMsg("Este é um email teste"); //conteudo do e-mail
		email.setSSL(true);
		email.send();	
	}

	public static void main(String[] args) throws EmailException, MalformedURLException {
		new GerenciaEmail();
	}
}
