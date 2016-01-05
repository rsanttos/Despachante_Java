package despachante.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Service que efetua o envio de e-mails
 * 
 * @author itamir, andre
 *
 */
public class EmailService {
	
	/**
	 * Método que efetua o envio de e-mail de acordo com os parâmetros recebidos
	 * 
	 * @param from, to, assunto, texto
	 */
	public static void enviarEmail(String from, String to, String assunto, String texto) {
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("naoresponder@imd.ufrn.br","$1$t3m@s1md3v");
				}
			});
 
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(assunto);
			message.setText(texto);
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void enviarEmailNovoUsuario(String to, String senha, String login, String nomeUsuario, String nomeSistema, String urlSistema){
		
		String from = "no-reply@sistemas.imd.ufrn.br";
		String assunto = "[" + nomeSistema + "] Cadastro no sistema " + nomeSistema ;
		
		enviarEmail(from, to ,assunto, 
				"Prezado(a) " + nomeUsuario + ",\n"+
						"Seu cadastro no sistema " + nomeSistema + " foi realizado com sucesso. Seguem seus dados de acesso: \n\nLogin: "+login
				+"\nSenha: "+senha
				+"\n\nSua senha atual foi gerada automaticamente, e para segurança das suas informações, recomendamos que realize"
				+" a alteração para uma senha de sua preferência através do seguinte endereço: "+ urlSistema+" \n\n"
				+"E-mail emitido automaticamente, por favor não responder. \n\nAtenciosamente, \n Equipe Inova\n IMD/UFRN");
		
	}
}

