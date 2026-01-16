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
	private String kargua;
	private String email;
	private int telefonoa;
	private String pasahitza;
	//Konstruktorea
	public Pertsona(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		this.id=id;
		this.izena=ize;
		this.abizena=abi;
		this.kargua=kar;
		this.email=ema;
		this.telefonoa=tel;
		this.pasahitza=pas;
	}
	//Metodoak
	public void Fitxatu(String mota) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Ezin da konektatu datu-basera.");
                return;
            }
            String sql = "INSERT INTO fitxaketak (langile_id, data, mota, ordua) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setString(3, mota);
            ps.setTime(4, Time.valueOf(LocalTime.now()));

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Fitxaketa ongi gorde da!");
            } else {
                System.out.println("Errorea fitxaketa gordetzean.");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Errorea: " + e.getMessage());
            e.printStackTrace();
        }
	}
	//Getter eta setter
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