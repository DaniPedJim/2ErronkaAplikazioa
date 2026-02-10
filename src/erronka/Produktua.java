package erronka;

public class Produktua {
	private int id;
	private String izena;
	private String kategoria;
	private String mota;
	private String modeloa;
	private double prezioa;
	private String konektibitatea;
	private String irudia;
	private String egoera;
	private int stock;

	public Produktua(int id, String ize, String kat, String mot, String mod, double pre, String kon, String iru,
			String ego, int sto) {
		this.id = id;
		this.izena = ize;
		this.kategoria = kat;
		this.mota = mot;
		this.modeloa = mod;
		this.prezioa = pre;
		this.konektibitatea = kon;
		this.irudia = iru;
		this.egoera = ego;
		this.stock = sto;
	}

	public Produktua(String ize, String kat, String mot, String mod, double pre, String kon, String iru, String ego,
			int sto) {
		this.izena = ize;
		this.kategoria = kat;
		this.mota = mot;
		this.modeloa = mod;
		this.prezioa = pre;
		this.konektibitatea = kon;
		this.irudia = iru;
		this.egoera = ego;
		this.stock = sto;
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

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getModeloa() {
		return modeloa;
	}

	public void setModeloa(String modeloa) {
		this.modeloa = modeloa;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public String getKonektibitatea() {
		return konektibitatea;
	}

	public void setKonektibitatea(String konektibitatea) {
		this.konektibitatea = konektibitatea;
	}

	public String getIrudia() {
		return irudia;
	}

	public void setIrudia(String irudia) {
		this.irudia = irudia;
	}

	public String getEgoera() {
		return egoera;
	}

	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
