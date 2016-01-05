package despachante.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExemploMail extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try {

			String to = req.getParameter("to");

			String from = "teste@dominio.com.br";

			Properties props = new Properties();
			props.put("mail.smtp.host", "localhost");
			Session session = Session.getInstance(props, null);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			Address toAddress = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, toAddress);

			message.setSubject("teste de envio de e-mails");

			message.setContent("este eh um teste de envio", "text/plain");

			Transport.send(message);

			out.println("E-mail enviado");
		} catch (MessagingException e) {
			out.println("Email nao pode ser enviado! " + e.getMessage());
		}
	}
}