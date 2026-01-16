package erronka;

public class Admin {
	private int id;
	private String izena;
	private String abizena;
	private String kargua;
	private String email;
	private char telefonoa;
	private String pasahitza;
	//Konstruktorea
	public Admin(int id,String ize,String abi,String kar,String ema,char tel,String pas) {
		this.id=id;
		this.izena=ize;
		this.abizena=abi;
		this.kargua=kar;
		this.email=ema;
		this.telefonoa=tel;
		this.pasahitza=pas;
	}
	//Metodoak
	public void IritziakEzabatu() {}
	
	public void IritziakIrakurri() {}
	
	public void PasahitzaAldatu() {}
	
	public void ErosketaIkusi() {}
	
	public void LangileenInformazioaIkusi() {}
	
	public void KonpondutakoProduktuakIkusi() {}
	
	public void ErabiltzaileakIkusi() {}
	
	public void ErabiltzaileakEzabatu() {}
	
	public void Fitxatu() {}
	//Getter eta Setter
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
	public String getKargua() {
		return kargua;
	}
	public void setKargua(String kargua) {
		this.kargua = kargua;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getTelefonoa() {
		return telefonoa;
	}
	public void setTelefonoa(char telefonoa) {
		this.telefonoa = telefonoa;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
}