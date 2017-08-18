package cm.gasmyr.mougang.it.sgs.mail;

public class Message {

	private String name;
	private String email;
	private String content;
	private boolean hasfail;
	private boolean reponse;

	public Message() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isHasfail() {
		return hasfail;
	}

	public void setHasfail(boolean hasfail) {
		this.hasfail = hasfail;
	}

	public boolean isReponse() {
		return reponse;
	}

	public void setReponse(boolean reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Message [hasfail=" + hasfail + ", reponse=" + reponse + "]";
	}
	
	

}
