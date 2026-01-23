package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Informatikoa extends LangileOrokorra{
	//Konstruktorea
	public Informatikoa(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//PROBISIONAL
	public Informatikoa() {};
	//Metodoak
	public void IkusiKonpontzekoProduktuak(JTable table) {
		try (Connection conn = DatabaseConnection.getConnection()) {
            // === PRODUKTUAK SALTZEKO EGOERA = 0 (Ez salgai) ===
            String sql = "SELECT izena, mota, kantitatea, egoera, saltzeko_egoera, konponketa FROM produktuak WHERE saltzeko_egoera = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Lortu produktuak
            DefaultTableModel model = new DefaultTableModel();
			model.addColumn("izena");
			model.addColumn("mota");
			model.addColumn("kantitatea");
			model.addColumn("egoera");
			model.addColumn("saltzeko_egoera");
			model.addColumn("konponketa");
			
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			TableColumnModel cm = table.getColumnModel();
			cm.getColumn(0).setPreferredWidth(150);
			cm.getColumn(1).setPreferredWidth(150);
			cm.getColumn(2).setPreferredWidth(90);
			cm.getColumn(3).setPreferredWidth(110);
			cm.getColumn(4).setPreferredWidth(90);
			cm.getColumn(5).setPreferredWidth(120);
			String[] array=new String[6];
			
			array[0]="Izena";
			array[1]="Mota";
			array[2]="Kopurua";
			array[3]="Egoera";
			array[4]="SEgoera";
			array[5]="Konponketa";
			model.addRow(array);
			
			try {
				while(rs.next()) {
					array[0]=rs.getString(1);
					array[1]=rs.getString(2);
					array[2]=rs.getString(3);
					array[3]=rs.getString(4);
					array[4]=rs.getString(5);
					array[5]=rs.getString(6);
					model.addRow(array);
				}
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
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