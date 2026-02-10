package erronka;

public class Feedback {
	private int id;
	private String email;
	private String mezua;

	public Feedback(int id, String email, String mezua) {
		this.id = id;
		this.email = email;
		this.mezua = mezua;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMezua() {
		return mezua;
	}

	public void setMezua(String mezua) {
		this.mezua = mezua;
	}
}