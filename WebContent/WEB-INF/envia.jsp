<%@ page
	import="java.util.Properties, javax.mail.*, javax.mail.internet.*, javax.activation.*, java.io.*, javax.servlet.*, javax.servlet.http.*"%>
<%
	try {

		String to = "email@seudominio.com.br";
		String from = request.getParameter("de");

		Properties props = new Properties();
		props.put("mail.smtp.host", "localhost");

		Session sessao = Session.getInstance(props);
		sessao.setDebug(true);

		MimeMessage message = new MimeMessage(sessao);

		message.setFrom(new InternetAddress(from));
		Address toAddress = new InternetAddress(to);
		message.addRecipient(Message.RecipientType.TO, toAddress);

		message.setSubject(request.getParameter("assunto"));
		message.setText(request.getParameter("comenta"));

		Transport.send(message);
		out.println("<br><br><br>");
		out.println("<html>");
		out.println("<div align=center>");
		out.println("<body>");
		out.println("Sua mensagem foi enviada com sucesso.<p>Em breve responderemos, Obrigado!");
		out.println("</body>");
		out.println("</html>");
	} catch (MessagingException e) {
		out.println(
				"Email nao pode ser enviado! Verifique se preencheu os campos corretamente! " + e.getMessage());
	}
%>