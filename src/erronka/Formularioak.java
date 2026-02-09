package erronka;

public class Formularioak {
	private int id;
	private String izena;
	private String mota;
	private String mezua;
	
	public Formularioak(int id,String izena,String mota,String mezua) {
		this.id=id;
		this.izena=izena;
		this.mota=mota;
		this.mezua=mezua;
	}
	public int getId() {
		return id;
	}
	public String getIzena() {
		return izena;
	}
	public String getMota() {
		return mota;
	}
	public String getMezua() {
		return mezua;
	}
}