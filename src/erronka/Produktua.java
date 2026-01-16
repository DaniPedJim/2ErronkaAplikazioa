package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public Produktua(String ize,String mot,double pre,int kan,String ego,String des,boolean sal,String kon) {
		this.izena=ize;
		this.mota=mot;
		this.prezioa=pre;
		this.kantitatea=kan;
		this.egoera=ego;
		this.deskribapena=des;
		this.saltzekoEgoera=sal;
		this.konponketa=kon;
	}

	public static boolean gehitu(Produktua p) {
		String sqlInsert = "INSERT INTO produktuak (izena, mota, prezioa, kantitatea, egoera, deskribapena, saltzeko_egoera, konponketa) "
	                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sqlInsert)) {

	            ps.setString(1, p.getIzena());
	            ps.setString(2, p.getMota());
	            ps.setDouble(3, p.getPrezioa());
	            ps.setInt(4, p.getKantitatea());
	            ps.setString(5, p.getEgoera());
	            ps.setString(6, p.getDeskribapena());
	            ps.setBoolean(7, p.isSaltzekoEgoera());
	            ps.setString(8, p.getKonponketa().isEmpty() ? null : p.getKonponketa());

	            int emaitza = ps.executeUpdate();
	            return emaitza > 0;

	        } catch (SQLException e) {
	            System.out.println("Errorea datu-basearekin: " + e.getMessage());
	            return false;
	}    
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
}
