package erronka;

import java.sql.Date;

public class Erosketak {
	private int id;
	private Date bidalketa_data;
	private Date data;
	//Konstruktorea
	public Erosketak(int id,Date bidalketaData,Date data) {
		this.id=id;
		this.bidalketa_data=bidalketaData;
		this.data=data;
	}
	//Getter eta setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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