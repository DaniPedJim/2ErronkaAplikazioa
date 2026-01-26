package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Informatikoa extends LangileOrokorra{
	//Konstruktorea
	public Informatikoa() {};
	public Informatikoa(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak
	public void IkusiKonpontzekoProduktuak(JTable table,Connection conn) {
			String sql = "select * from produktuak where saltzeko_egoera=0";
			Statement st;
			ResultSet rs;
			int id=1;
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn(id);
			model.addColumn("izena");
			model.addColumn("mota");
			model.addColumn("egoera");
			
			table.setModel(model);
			
			String[] array=new String[4];
			array[0]="ID";
			array[1]="IZENA";
			array[2]="MOTA";
			array[3]="EGOERA";
			model.addRow(array);
			try {
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()) {
					Produktua p=new Produktua(rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getBoolean(8),rs.getString(9),rs.getString(10));
					array[0]=Integer.toString(id++);
					array[1]=p.getIzena();
					array[2]=p.getMota();
					array[3]=p.getEgoera();
					model.addRow(array);
				}
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	public void KonponketaAldatu(int produktuId,Connection conn) {
		String sql = "select id from produktuak where saltzeko_egoera=0";
		Statement st;
		ResultSet rs;
		int id=1;
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				if(id==produktuId) {
					sql="update produktuak set saltzeko_egoera=1 and egoera='Konponduta' where id=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, rs.getInt(1));
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