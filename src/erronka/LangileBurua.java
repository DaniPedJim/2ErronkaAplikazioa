package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class LangileBurua extends LangileOrokorra{
	//Konstruktorea
	

	public LangileBurua() {}
	public LangileBurua(String ize,String abi,String kar,String ema,int tel,String pas) {
		super(ize,abi,kar,ema,tel,pas);
	}
	public LangileBurua(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak
	public void KonpondutakoProduktuakIkusi(JTable table,Connection conn) {
		String sql = "select * from produktuak where egoera like 'Ikusgai'";
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
	
	public void ErosketaIkusi(JTable table,Connection conn) {
		String sql = "select erabil.izena,eros.data,eros.bidalketa_egoera from erosketak eros inner join erabiltzaileak erabil";
		Statement st;
		ResultSet rs;
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("izena");
		model.addColumn("bidalketa_data");
		model.addColumn("data");
		
		table.setModel(model);
		
		String[] array=new String[3];
		array[0]="IZENA";
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
	
	public void LangileakGehitu(Pertsona p) {
		String sqlInsert = "INSERT INTO langileak (izena, abizena, email, telefonoa, pasahitza, kargua) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sqlInsert)) {

				ps.setString(1, p.getIzena());
				ps.setString(2, p.getAbizena());
				ps.setString(3, p.getEmail());
				ps.setInt(4, p.getTelefonoa());
				ps.setString(5, p.getPasahitza());
				ps.setString(6, p.getKargua());
   
				ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Errorea datu-basearekin: " + e.getMessage());
		}    
	}
	public void ProduktuKantitateaGehitu(int id,int kopurua) {
		Connection conn=DatabaseConnection.getConnection();
		String sql="update produktuak set stock=stock+? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, kopurua);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void ProduktuPrezioaAldatu(int idProduktu,Double prezioa) {
		String sql = "select id from produktuak where egoera like 'Ikusgai'";
		Connection conn=DatabaseConnection.getConnection();

		Statement st;
		ResultSet rs;
		int id=1;
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				if(id==idProduktu) {
					sql="update produktuak set prezioa=? where id=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setDouble(1, prezioa);
					ps.setInt(2, rs.getInt(1));
					ps.executeUpdate();
				}else {
					id++;
				}
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
}

