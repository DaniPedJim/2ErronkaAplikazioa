package erronka;

public class bezeroak {
	private int id;
	private String izena;
	private String abizena;
	private String email;
	private int telefono;
	private String pasahitza;
	private String helbidea;
	private String rol;
	private String iritzia;
	//Konstruktorea
	public bezeroak(int id, String ize, String abi, String ema, int tel, String pas, String hel, String rol, String iri) {
		this.id=id;
		this.izena=ize;
		this.abizena=abi;
		this.rol=rol;
		this.email=ema;
		this.telefono=tel;
		this.pasahitza=pas;
		this.helbidea=hel;
		this.iritzia=iri;
		
	}
	//Getter eta setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	public String getHelbidea() {
		return helbidea;
	}
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getIritzia() {
		return iritzia;
	}
	public void setIritzia(String iritzia) {
		this.iritzia = iritzia;
	}
}