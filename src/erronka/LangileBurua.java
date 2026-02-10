package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LangileBurua extends LangileOrokorra {
	// Konstruktorea
	public LangileBurua() {
	}

	public LangileBurua(String ize, String abi, String ema, int tel, String pas, String kar) {
		super(ize, abi, ema, tel, pas, kar);
	}

	public LangileBurua(int id, String ize, String abi, String ema, int tel, String pas, String kar) {
		super(id, ize, abi, ema, tel, pas, kar);
	}

	// Metodoak
	public void ErosketaIkusi(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select eros.id,erabil.izena,eros.data,eros.bidalketa_egoera from erosketak eros inner join erabiltzaileak erabil on eros.erabiltzailea_id=erabil.id where eros.bidalketa_egoera not like 'prest'";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("IZENA");
		model.addColumn("DATA");
		model.addColumn("EGOERA");

		table.setModel(model);

		String[] array = new String[4];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Erosketak e = new Erosketak(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4));
				array[0] = Integer.toString(e.getId());
				array[1] = e.getIzena();
				array[2] = sdf.format(e.getData());
				array[3] = e.getBidalketa_egoera();
				model.addRow(array);
			}
		} catch (SQLException e1) {
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

	public void KonpondutakoProduktuakIkusi(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select * from produktuak where egoera='Ikusgai'";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("IZENA");
		model.addColumn("PREZIOA");
		model.addColumn("STOCK");

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
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
				array[2] = String.valueOf(p.getPrezioa());
				array[3] = Integer.toString(p.getStock());
				model.addRow(array);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void ProduktuKantitateaGehitu(int id, int kopurua) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "update produktuak set stock=stock+? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, kopurua);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ProduktuPrezioaAldatu(int idProduktu, Double prezioa) {
		String sql = "select id from produktuak where egoera like 'Ikusgai'";
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (idProduktu == rs.getInt(1)) {
					sql = "update produktuak set prezioa=? where id=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setDouble(1, prezioa);
					ps.setInt(2, rs.getInt(1));
					ps.executeUpdate();
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
