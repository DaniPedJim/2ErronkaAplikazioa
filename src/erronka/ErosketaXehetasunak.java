package erronka;

public class ErosketaXehetasunak {
	private int kantitatea;
	private String izena;
	private double prezioa;

	public ErosketaXehetasunak(int kan, String ize, double pre) {
		this.kantitatea = kan;
		this.izena = ize;
		this.prezioa = pre;
	}

	public int getKantitatea() {
		return kantitatea;
	}

	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
}