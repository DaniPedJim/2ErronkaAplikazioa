package erronka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Pertsona {
	private int id;
	private String izena;
	private String abizena;
	private String email;
	private int telefonoa;
	private String pasahitza;
	private String kargua;

	// Konstruktorea
	public Pertsona() {
	};

	public Pertsona(String ize, String abi, String ema, int tel, String pas, String kar) {
		this.izena = ize;
		this.abizena = abi;
		this.kargua = kar;
		this.email = ema;
		this.telefonoa = tel;
		this.pasahitza = pas;
	}

	public Pertsona(int id, String ize, String abi, String ema, int tel, String pas, String kar) {
		this.id = id;
		this.izena = ize;
		this.abizena = abi;
		this.kargua = kar;
		this.email = ema;
		this.telefonoa = tel;
		this.pasahitza = pas;
	}

	// Metodoak
	public void Fitxatu(String mota) {
		try (Connection conn = DatabaseConnection.getConnection()) {
			Fitxaketak f = new Fitxaketak(this.id, Date.valueOf(LocalDate.now()), mota, Time.valueOf(LocalTime.now()));
			String sql = "INSERT INTO fitxaketak (langilea_id, data, mota, ordua) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, f.getLangileId());
			ps.setDate(2, f.getData());
			ps.setString(3, f.getMota());
			ps.setTime(4, f.getOrdua());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Errorea: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Getter eta setter
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

	public int getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(int telefonoa) {
		this.telefonoa = telefonoa;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
}