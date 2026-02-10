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
	// Konstruktorea
	public Admin() {
	}

	public Admin(int id, String ize, String abi, String ema, int tel, String pas, String kar) {
		super(id, ize, abi, ema, tel, pas, kar);
	}

	// Metodoak
	public void IritziakEzabatu(int iritzi_id) {
		try (Connection conn = DatabaseConnection.getConnection()) {
			if (conn == null) {
				System.out.println("❌ Ezin izan da konektatu datu-basera.");
				return;
			}
			String sql = "DELETE FROM feedback WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iritzi_id);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(" Errorea datu-basearekin: " + e.getMessage());
		}
	}

	public void IritziakIrakurri(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select f.id,f.email,e.email,f.mezua from feedback f left join erabiltzaileak e on f.erabiltzailea_id=e.id";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("EMAIL");
		model.addColumn("IRITZIAK");

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);

		String[] array = new String[3];
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			String email;
			while (rs.next()) {
				if (rs.getString(2) == null) {
					email = rs.getString(3);
				} else {
					email = rs.getString(2);
				}
				Feedback f = new Feedback(rs.getInt(1), email, rs.getString(4));
				array[0] = Integer.toString(f.getId());
				array[1] = f.getEmail();
				array[2] = f.getMezua();
				model.addRow(array);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void PasahitzaAldatu(String pasahitz_berria, int langile_id) {
		try (Connection conn = DatabaseConnection.getConnection()) {
			if (conn == null) {
				System.out.println("❌ Ezin izan da konektatu datu-basera.");
				return;
			}
			String sql = "UPDATE langileak SET pasahitza=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pasahitz_berria);
			ps.setInt(2, langile_id);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(" Errorea datu-basearekin: " + e.getMessage());
		}
	}

	public void ErosketaIkusi(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select eros.id,erabil.izena,eros.data,eros.bidalketa_egoera from erosketak eros inner join erabiltzaileak erabil on eros.erabiltzailea_id=erabil.id";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("IZENA");
		model.addColumn("DATA");
		model.addColumn("EGOERA");

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

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

	public void LangileenInformazioaIkusi(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select * from langileak";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("IZENA");
		model.addColumn("ABIZENA");
		model.addColumn("PASAHITZA");

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		String[] array = new String[4];
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Pertsona p;
				if (rs.getString(4).equals("Informatikoa")) {
					p = new Informatikoa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6), rs.getString(7));
				} else if (rs.getString(4).equals("Admin")) {
					p = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6), rs.getString(7));
				} else {
					p = new LangileBurua(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6), rs.getString(7));
				}
				array[0] = Integer.toString(p.getId());
				array[1] = p.getIzena();
				array[2] = p.getAbizena();
				array[3] = p.getPasahitza();
				model.addRow(array);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void KonpondutakoProduktuakIkusi(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select * from produktuak where egoera='Ikusgai'";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IZENA");
		model.addColumn("MOTA");
		model.addColumn("STOCK");

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);

		String[] array = new String[3];
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Produktua p = new Produktua(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
				array[0] = p.getIzena();
				array[1] = p.getMota();
				array[2] = Integer.toString(p.getStock());
				model.addRow(array);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void ErabiltzaileakIkusi(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select * from erabiltzaileak";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("IZENA");
		model.addColumn("ABIZENA");

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);

		String[] array = new String[3];
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Bezeroak b = new Bezeroak(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getString(9));
				array[0] = Integer.toString(b.getId());
				array[1] = b.getIzena();
				array[2] = b.getAbizena();
				model.addRow(array);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void ErabiltzaileakEzabatu(int erabiltzaile_id) {
		try (Connection conn = DatabaseConnection.getConnection()) {
			if (conn == null) {
				System.out.println("❌ Ezin izan da konektatu datu-basera.");
				return;
			}
			String sql = "DELETE FROM erabiltzaileak WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, erabiltzaile_id);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(" Errorea datu-basearekin: " + e.getMessage());
		}
	}
}