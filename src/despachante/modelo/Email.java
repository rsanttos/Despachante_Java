package despachante.modelo;

public class Email {
	private String to;
	private String from;
	private String assunto;
	private String texto;
	public Email() {
		this.to = new String();
		this.from = new String();
		this.assunto = new String();
		this.texto = new String();
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}	
}
