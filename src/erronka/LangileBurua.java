package erronka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LangileBurua extends LangileOrokorra{
	//Konstruktorea
	public LangileBurua() {}
	public LangileBurua(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak
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
				Produktua p=new Produktua(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getBoolean(7),rs.getString(8),rs.getString(9));
				array[0]=p.getIzena();
				array[1]=p.getMota();
				array[2]=Integer.toString(p.getKantitatea());
				model.addRow(array);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
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
				Erosketak e=new Erosketak(rs.getInt(1),rs.getDate(2),rs.getDate(3));
				array[0]=Integer.toString(e.getId());
				array[1]=sdf.format(e.getBidalketa_data());
				array[2]=sdf.format(e.getData());
				model.addRow(array);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void InformatikoakGehitu() {}
	
	public void ProduktuKantitateaGehitu() {}
	
	public void ProduktuPrezioaAldatu() {}
}