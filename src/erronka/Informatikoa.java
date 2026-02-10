package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Informatikoa extends LangileOrokorra {
	// Konstruktorea
	public Informatikoa() {
	};

	public Informatikoa(String ize, String abi, String ema, int tel, String pas, String kar) {
		super(ize, abi, ema, tel, pas, kar);
	}

	public Informatikoa(int id, String ize, String abi, String ema, int tel, String pas, String kar) {
		super(id, ize, abi, ema, tel, pas, kar);
	}

	// Metodoak
	public void IkusiKonpontzekoProduktuak(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select * from produktuak where egoera like 'Ez ikusgai'";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("IZENA");
		model.addColumn("MOTA");
		model.addColumn("KATEGORIA");

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);

		String[] array = new String[4];
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Produktua p = new Produktua(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10));
				array[0] = Integer.toString(p.getId());
				array[1] = p.getIzena();
				array[2] = p.getMota();
				array[3] = p.getKategoria();
				model.addRow(array);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void KonponketaAldatu(int produktuId) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select id from produktuak where egoera like 'Ez ikusgai'";
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.getInt(1) == produktuId) {
					sql = "update produktuak set egoera='Ikusgai' where id=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, rs.getInt(1));
					ps.executeUpdate();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}