package erronka;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public abstract class LangileOrokorra {
	private int id;
	private String izena;
	private String abizena;
	private String kargua;
	private String email;
	private int telefonoa;
	private String pasahitza;
	//Konstruktorea
	public LangileOrokorra(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		this.id=id;
		this.izena=ize;
		this.abizena=abi;
		this.kargua=kar;
		this.email=ema;
		this.telefonoa=tel;
		this.pasahitza=pas;
	}
	//PROBISIONAL
	public LangileOrokorra() {};
	//Metodoak
	public void Login(String rol,Informatikoa i) {
		switch (rol.toLowerCase()) {
        case "admin":
            break;
        case "langileen burua":
            break;
        case "informatikoa":
        	//EGITEN (EZ BUKATUTA)
        	
        	break;
        default:
            System.out.println("Kargua ezagutzen ez dena.");
    }
	}
	
	public void Fitxatu(Informatikoa i, String mota) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Ezin da konektatu datu-basera.");
                return;
            }

            String sql = "INSERT INTO fitxategiak (langileen_id, data, mota, ordua) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, i.getId());
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
	
	public void EkipoakErregistratu() {
		Scanner sc = new Scanner(System.in);

        System.out.println("=== PRODUKTU BERRIA GEHITU ===");

        System.out.print("Produktuaren izena: ");
        String izena = sc.nextLine();

        System.out.print("Produktuaren mota (Ordenagailua, Mugikorra, Konponenta...): ");
        String mota = sc.nextLine();

        System.out.print("Prezioa (€): ");
        double prezioa = sc.nextDouble();
        sc.nextLine();

        System.out.print("Kantitatea: ");
        int kantitatea = sc.nextInt();
        sc.nextLine();

        System.out.print("Egoera (Lehen eskua / Bigarren eskua): ");
        String egoera = sc.nextLine();

        System.out.print("Deskribapena: ");
        String deskribapena = sc.nextLine();

        System.out.print("Saltzeko egoera (True = Salgai - False = Ez salgai): ");
        boolean saltzekoEgoera = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Konponketa egoera (adib. 'Konponduta', 'Konpontzen', 'Zain' edo hutsik): ");
        String konponketa = sc.nextLine();

        Produktua p = new Produktua(izena, mota, prezioa, kantitatea, egoera, deskribapena, saltzekoEgoera, konponketa);

        if (Produktua.gehitu(p) == true) {
            System.out.println("✅ Produktua ondo gehitu da datu-basera!");
        } else {
            System.out.println("❌ Errorea gertatu da produktua gehitzean.");
        }
    }
	//Getter eta Setter
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
