package erronka;

import java.sql.Date;

public class Erosketak {
	private String izena;
	private Date bidalketa_data;
	private Date data;
	//Konstruktorea
	public Erosketak(String izena,Date bidalketaData,Date data) {
		this.izena=izena;
		this.bidalketa_data=bidalketaData;
		this.data=data;
	}
	//Getter eta setter
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public Date getBidalketa_data() {
		return bidalketa_data;
	}
	public void setBidalketa_data(Date bidalketa_data) {
		this.bidalketa_data = bidalketa_data;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}