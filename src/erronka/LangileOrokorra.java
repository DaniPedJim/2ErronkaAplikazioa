package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class LangileOrokorra extends Pertsona {
	//Konstruktorea
	public LangileOrokorra() {};
	public LangileOrokorra(String ize,String abi,String kar,String ema,int tel,String pas) {
		super(ize,abi,kar,ema,tel,pas);
	}
	public LangileOrokorra(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak	
	public boolean gehitu(Produktua p) {
		String sqlInsert = "INSERT INTO produktuak (izena, kategoria, mota, modeloa, prezioa, konektibitatea, irudia, egoera, stock) "
	                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sqlInsert)) {

	            ps.setString(1, p.getIzena());
	            ps.setString(2, p.getKategoria());
	            ps.setString(3, p.getMota());
	            ps.setString(4, p.getModeloa());
	            ps.setDouble(5, p.getPrezioa());
	            ps.setString(6, p.getKonektibitatea());
	            ps.setString(7, p.getIrudia());
	            ps.setString(8, p.getEgoera());
	            ps.setInt(9, p.getStock());
	            
	            int emaitza = ps.executeUpdate();
	            return emaitza > 0;

	        } catch (SQLException e) {
	            System.out.println("Errorea datu-basearekin: " + e.getMessage());
	            return false;
	}    
}
}
