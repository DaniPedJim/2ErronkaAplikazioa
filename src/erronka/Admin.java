package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Admin extends Pertsona {
	//Konstruktorea
	public Admin() {}
	public Admin(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak
	public void IritziakEzabatu(int iritzi_id) {
		try (Connection conn = DatabaseConnection.getConnection()) {
	        if (conn == null) {
	           System.out.println("❌ Ezin izan da konektatu datu-basera.");
	           return;
	       }
	       String sql= "DELETE FROM feedback WHERE id=?";
	       PreparedStatement ps = conn.prepareStatement(sql);
	       ps.setInt(1, iritzi_id );
	       ps.executeUpdate();
	       
		}catch(Exception e){
			System.out.println(" Errorea datu-basearekin: " + e.getMessage());
		}
	}
	
	public void IritziakIrakurri(JTable table,Connection conn) {
		String sql = "select * from bezeroak";
		Statement st;
		ResultSet rs;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("izena");
		model.addColumn("iritziak");
		
		table.setModel(model);
		
		String[] array=new String[3];
		array[0]="ID";
		array[1]="IZENA";
		array[2]="IRITZIA";
		model.addRow(array);
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Bezeroak b=new Bezeroak(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				array[0]=Integer.toString(b.getId());
				array[1]=b.getIzena();
				array[2]=b.getIritzia();
				model.addRow(array);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void PasahitzaAldatu(String pasahitz_berria, int langile_id) {
		try (Connection conn = DatabaseConnection.getConnection()) {
	        if (conn == null) {
	           System.out.println("❌ Ezin izan da konektatu datu-basera.");
	           return;
	       }
	       String sql= "UPDATE langileak SET pasahitza=? WHERE id=?";
	       PreparedStatement ps = conn.prepareStatement(sql);
	       ps.setString(1, pasahitz_berria);
	       ps.setInt(2, langile_id);
	       ps.executeUpdate();
	       
		}catch(Exception e){
			System.out.println(" Errorea datu-basearekin: " + e.getMessage());
		}
	}
	
	public void ErosketaIkusi(JTable table,Connection conn) {
		String sql = "select * from erosketak";
		Statement st;
		ResultSet rs;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("bidalketa_data");
		model.addColumn("data");
		
		table.setModel(model);
		
		String[] array=new String[3];
		array[0]="ID";
		array[1]="BIDALKETA DATA";
		array[2]="DATA";
		model.addRow(array);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Erosketak e=new Erosketak(rs.getString(1),rs.getDate(2),rs.getDate(3));
				array[0]=e.getIzena();
				array[1]=sdf.format(e.getBidalketa_data());
				array[2]=sdf.format(e.getData());
				model.addRow(array);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void LangileenInformazioaIkusi(JTable table,Connection conn) {
		String sql = "select * from langileak";
		Statement st;
		ResultSet rs;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("izena");
		model.addColumn("abizena");
		model.addColumn("pasahitza");
		
		table.setModel(model);
		
		String[] array=new String[4];
		array[0]="ID";
		array[1]="IZENA";
		array[2]="ABIZENA";
		array[3]="PASAHITZA";
		model.addRow(array);
		
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Pertsona p;
				if(rs.getString(4).equals("Informatikoa")) {
					p=new Informatikoa(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
				}else if(rs.getString(4).equals("Admin")){
					p=new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
				}else{
					p=new LangileBurua(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
				}
				array[0]=Integer.toString(p.getId());
				array[1]=p.getIzena();
				array[2]=p.getAbizena();
				array[3]=p.getPasahitza();
				model.addRow(array);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void KonpondutakoProduktuakIkusi(JTable table,Connection conn) {
		String sql = "select * from produktuak where saltzeko_egoera=1";
		Statement st;
		ResultSet rs;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("izena");
		model.addColumn("mota");
		model.addColumn("stock");
		
		table.setModel(model);
		
		String[] array=new String[3];
		array[0]="IZENA";
		array[1]="MOTA";
		array[2]="STOCK";
		model.addRow(array);
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Produktua p=new Produktua(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
				array[0]=p.getIzena();
				array[1]=p.getMota();
				array[2]=Integer.toString(p.getStock());
				model.addRow(array);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void ErabiltzaileakIkusi(JTable table,Connection conn) {
		String sql = "select * from bezeroak";
		Statement st;
		ResultSet rs;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("izena");
		model.addColumn("abizena");
		
		table.setModel(model);
		
		String[] array=new String[3];
		array[0]="ID";
		array[1]="IZENA";
		array[2]="ABIZENA";
		model.addRow(array);
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Bezeroak b=new Bezeroak(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				array[0]=Integer.toString(b.getId());
				array[1]=b.getIzena();
				array[2]=b.getAbizena();
				model.addRow(array);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void ErabiltzaileakEzabatu(int erabiltzaile_id) {
		try (Connection conn = DatabaseConnection.getConnection()) {
	        if (conn == null) {
	           System.out.println("❌ Ezin izan da konektatu datu-basera.");
	           return;
	       }
	       String sql= "DELETE FROM erabiltzaileak WHERE id=?";
	       PreparedStatement ps = conn.prepareStatement(sql);
	       ps.setInt(1, erabiltzaile_id);
	       ps.executeUpdate();
	       
		}catch(Exception e){
			System.out.println(" Errorea datu-basearekin: " + e.getMessage());
		}
	}
	
}