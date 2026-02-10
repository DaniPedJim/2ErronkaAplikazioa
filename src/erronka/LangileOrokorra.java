package erronka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class LangileOrokorra extends Pertsona {
	// Konstruktorea
	public LangileOrokorra() {
	};

	public LangileOrokorra(String ize, String abi, String ema, int tel, String pas, String kar) {
		super(ize, abi, ema, tel, pas, kar);
	}

	public LangileOrokorra(int id, String ize, String abi, String ema, int tel, String pas, String kar) {
		super(id, ize, abi, ema, tel, pas, kar);
	}

	// Metodoak
	public boolean gehitu(Produktua p) {
		String sql = "INSERT INTO produktuak (izena, kategoria, mota, modeloa, prezioa, konektibitatea, irudia, egoera, stock) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

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

			sql = "delete from formularioak where izena like '" + p.getIzena() + "' and mota like '" + p.getMota()
					+ "';";
			PreparedStatement psD = conn.prepareStatement(sql);
			psD.executeUpdate();

			return emaitza > 0;
		} catch (SQLException e) {
			System.out.println("Errorea datu-basearekin: " + e.getMessage());
			return false;
		}
	}

	public void formularioakIkusi(JTable table) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "select id,izena,mota,mezua from formularioak";
		Statement st;
		ResultSet rs;

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("IZENA");
		model.addColumn("MOTA");
		model.addColumn("MEZUA");

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
				Formularioak f = new Formularioak(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				array[0] = Integer.toString(f.getId());
				array[1] = f.getIzena();
				array[2] = f.getMota();
				array[3] = f.getMezua();
				model.addRow(array);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void fakturaEgin() {
	}
}
