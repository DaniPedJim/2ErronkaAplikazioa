package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class LangileOrokorra extends Pertsona {
	//Konstruktorea
	public LangileOrokorra() {};
	public LangileOrokorra(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak	
	public boolean gehitu(Produktua p) {
		String sqlInsert = "INSERT INTO produktuak (izena, mota, prezioa, kantitatea, egoera, deskribapena, saltzeko_egoera, konponketa,argazkia) "
	                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sqlInsert)) {

	            ps.setString(1, p.getIzena());
	            ps.setString(2, p.getMota());
	            ps.setDouble(3, p.getPrezioa());
	            ps.setInt(4, p.getKantitatea());
	            ps.setString(5, p.getEgoera());
	            ps.setString(6, p.getDeskribapena());
	            ps.setBoolean(7, p.isSaltzekoEgoera());
	            ps.setString(8, p.getKonponketa());
	            ps.setString(9, p.getArgazkia());

	            int emaitza = ps.executeUpdate();
	            return emaitza > 0;

	        } catch (SQLException e) {
	            System.out.println("Errorea datu-basearekin: " + e.getMessage());
	            return false;
	}    
}
}
