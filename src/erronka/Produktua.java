package erronka;

public class Produktua {
	private int id;
	private String izena;
	private String mota;
	private double prezioa;
	private int kantitatea;
	private String egoera;
	private String deskribapena;
	private boolean saltzekoEgoera;
	private String konponketa;
	private String argazkia;
	
	public Produktua(String ize,String mot,double pre,int kan,String ego,String des,boolean sal,String kon,String arg) {
		this.izena=ize;
		this.mota=mot;
		this.prezioa=pre;
		this.kantitatea=kan;
		this.egoera=ego;
		this.deskribapena=des;
		this.saltzekoEgoera=sal;
		this.konponketa=kon;
		this.argazkia=arg;
	}
	
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
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public double getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	public int getKantitatea() {
		return kantitatea;
	}
	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}
	public String getEgoera() {
		return egoera;
	}
	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}
	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	public boolean isSaltzekoEgoera() {
		return saltzekoEgoera;
	}
	public void setSaltzekoEgoera(boolean saltzeko_egoera) {
		this.saltzekoEgoera = saltzeko_egoera;
	}
	public String getKonponketa() {
		return konponketa;
	}
	public void setKonponketa(String konponketa) {
		this.konponketa = konponketa;
	}
	public String getArgazkia() {
		return argazkia;
	}
	public void setArgazkia(String argazkia) {
		this.argazkia = argazkia;
	}
}
