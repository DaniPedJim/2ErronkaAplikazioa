package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Informatikoa extends LangileOrokorra{
	//Konstruktorea
	public Informatikoa(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak
	public void IkusiKonpontzekoProduktuak() {
		try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("❌ Ezin izan da konektatu datu-basera.");
                return;
            }
            // === PRODUKTUAK SALTZEKO EGOERA = 0 (Ez salgai) ===
            System.out.println("\n=== SALGAI EZ DAUDEN PRODUKTUAK ===");
            String sqlEzSalgai = "SELECT izena, mota, prezioa, kantitatea, egoera, deskribapena, saltzeko_egoera, konponketa FROM produktuak WHERE saltzeko_egoera = 0";
            PreparedStatement psEzSalgai = conn.prepareStatement(sqlEzSalgai);
            ResultSet rsEzSalgai = psEzSalgai.executeQuery();
            //Lortu produktuak
            boolean aurkituta = false;
            while (rsEzSalgai.next()) {
            	Produktua p=new Produktua(rsEzSalgai.getString("izena"),rsEzSalgai.getString("mota"),rsEzSalgai.getDouble("prezioa"),rsEzSalgai.getInt("kantitatea"),
            			rsEzSalgai.getString("egoera"),rsEzSalgai.getString("deskribapena"),rsEzSalgai.getBoolean("saltzeko_egoera"),rsEzSalgai.getString("konponketa"));
                aurkituta = true;
                System.out.println();
                System.out.println("Izena: " + p.getIzena());
                System.out.println("Mota: " + p.getMota());
                System.out.println("Prezioa: " + p.getPrezioa() + " €");
                System.out.println("Egoera: " + p.getEgoera());
                System.out.println("Deskribapena: " + p.getDeskribapena());
            }

            if (!aurkituta) {
                System.out.println("Ez dago produktu ez-salgairik.");
            }
            System.out.println();
		}catch (SQLException e) {
            System.out.println(" Errorea datu-basearekin: " + e.getMessage());
        }
	}
	
	public void KonponketaErregistroa() {
		Scanner sc=new Scanner(System.in);
		// === MENUA ===
        System.out.println("\n=== PRODUKTUEN KUDEAKETA ===");
        System.out.println("1. Produktu baten SALTZEKO EGOERA aldatu");
        System.out.println("2. Produktu baten KONPONKETA EGOERA aldatu");
        System.out.print("Aukeratu (1-2): ");
        int aukera = sc.nextInt();
        sc.nextLine(); // buffer garbitu
        //EZ DAGO BUKATUTA
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("❌ Ezin izan da konektatu datu-basera.");
                return;
            }
        
        // === 1. SALTZEKO EGOERA ALDATU ===
        if (aukera == 1) {
            System.out.print("Sartu aldatu nahi duzun produktuaren IDa: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sqlCheck = "SELECT izena, saltzeko_egoera FROM produktuak WHERE id = ?";
            PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setInt(1, id);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                System.out.println(" Ez da aurkitu produkturik ID horrekin.");
                rs.close();
                psCheck.close();
                return;
            }

            String izena = rs.getString("izena");
            int egoera = rs.getInt("saltzeko_egoera");
            rs.close();
            psCheck.close();

            System.out.println("Produktuaren izena: " + izena);
            System.out.println("Oraingo saltzeko egoera: " + (egoera == 1 ? "Salgai" : "Ez salgai"));
            System.out.print("Sartu egoera berria (0 = Ez salgai, 1 = Salgai): ");
            int berria = sc.nextInt();

            if (berria != 0 && berria != 1) {
                System.out.println(" Balio okerra sartu duzu. 0 edo 1 izan behar da.");
                return;
            }

            String sqlUpdate = "UPDATE produktuak SET saltzeko_egoera = ? WHERE id = ?";
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, berria);
            psUpdate.setInt(2, id);
            int eguneratuak = psUpdate.executeUpdate();

            psUpdate.close();

            if (eguneratuak > 0) {
                System.out.println(" Saltzeko egoera ondo eguneratu da.");
            } else {
                System.out.println(" Ez da aldaketarik egin.");
            }

        // === 2. KONPONKETA EGOERA ALDATU ===
        } else if (aukera == 2) {
            System.out.print("Sartu aldatu nahi duzun produktuaren IDa: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sqlCheck = "SELECT izena, konponketa FROM produktuak WHERE id = ?";
            PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setInt(1, id);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                System.out.println(" Ez da aurkitu produkturik ID horrekin.");
                rs.close();
                psCheck.close();
                return;
            }

            String izena = rs.getString("izena");
            String konponketa = rs.getString("konponketa");
            rs.close();
            psCheck.close();

            System.out.println("Produktuaren izena: " + izena);
            System.out.println("Oraingo konponketa egoera: " + (konponketa == null ? "Ez dago" : konponketa));
            System.out.print("Sartu konponketa egoera berria ('Konponduta', 'Konpontzen', 'Zain' edo hutsik): ");
            String berria = sc.nextLine();

            String sqlUpdate = "UPDATE produktuak SET konponketa = ? WHERE id = ?";
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setString(1, berria);
            psUpdate.setInt(2, id);
            int eguneratuak = psUpdate.executeUpdate();

            psUpdate.close();

            if (eguneratuak > 0) {
                System.out.println(" Konponketa egoera ondo eguneratu da.");
            } else {
                System.out.println(" Ez da aldaketarik egin.");
            }

        } else {
            System.out.println(" Aukera ez da zuzena.");
        }

    } catch (SQLException e) {
        System.out.println(" Errorea datu-basearekin: " + e.getMessage());
    }
}
}