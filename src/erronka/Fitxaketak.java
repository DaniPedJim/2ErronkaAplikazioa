package erronka;

import java.sql.Date;
import java.sql.Time;

public class Fitxaketak {
	private int langileId;
	private Date data;
	private String mota;
	private Time ordua;
	
	public Fitxaketak(int id,Date data,String mota,Time ordua) {
		this.langileId=id;
		this.data=data;
		this.mota=mota;
		this.ordua=ordua;
	}
	public int getLangileId() {
		return langileId;
	}
	public void setLangileId(int langileId) {
		this.langileId = langileId;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public Time getOrdua() {
		return ordua;
	}
	public void setOrdua(Time ordua) {
		this.ordua = ordua;
	}
}
