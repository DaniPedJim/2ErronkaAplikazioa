package erronka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class Datu1Aterea extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textSarrera;
	private JTextField textIzena;
	private JTextField textMota;
	private JTextField textPrezioa;
	private JTextField textFabrikatzailea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datu1Aterea frame = new Datu1Aterea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Datu1Aterea() {
		Connection conn = DatabaseConnection.getConnection();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 10, 242, 203);
		contentPane.add(table);
		
		JButton btnErakutsiInformazioa = new JButton("Informazioa erakutsi");
		btnErakutsiInformazioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select id,izena,prezioa from produktuak";
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("id");
				model.addColumn("izena");
				model.addColumn("prezioa");
				
				table.setModel(model);
				String[] array=new String[3];
				try {
					st=conn.createStatement();
					rs=st.executeQuery(sql);
					while(rs.next()) {
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						model.addRow(array);
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnErakutsiInformazioa.setBounds(63, 223, 132, 20);
		contentPane.add(btnErakutsiInformazioa);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(275, 11, 151, 12);
		contentPane.add(lblIzena);
		
		textIzena = new JTextField();
		textIzena.setBounds(275, 27, 151, 18);
		contentPane.add(textIzena);
		textIzena.setColumns(10);
		
		JLabel lblMota = new JLabel("Mota:");
		lblMota.setBounds(275, 55, 151, 12);
		contentPane.add(lblMota);
		
		textMota = new JTextField();
		textMota.setColumns(10);
		textMota.setBounds(275, 71, 151, 18);
		contentPane.add(textMota);
		
		JLabel lblPrezioa = new JLabel("Prezioa:");
		lblPrezioa.setBounds(275, 99, 151, 12);
		contentPane.add(lblPrezioa);
		
		textPrezioa = new JTextField();
		textPrezioa.setColumns(10);
		textPrezioa.setBounds(275, 115, 151, 18);
		contentPane.add(textPrezioa);
		
		JLabel lblFabrikatzailea = new JLabel("Fabrikatzailearen id:");
		lblFabrikatzailea.setBounds(275, 143, 151, 12);
		contentPane.add(lblFabrikatzailea);
		
		textFabrikatzailea = new JTextField();
		textFabrikatzailea.setColumns(10);
		textFabrikatzailea.setBounds(275, 159, 151, 18);
		contentPane.add(textFabrikatzailea);
		
		JButton btnGehituInformazioa = new JButton("Txertatu produktua");
		btnGehituInformazioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String izena=textIzena.getText();
				String mota=textMota.getText();
				String prezioa=textPrezioa.getText();
				String fabrikatzailea=textFabrikatzailea.getText();
				
				try {
					Connection conn=DatabaseConnection.getConnection();
					String sql="insert into produktuak(izena,mota,prezioa,fabrikatzaile_id) values(?,?,?,?);";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, izena);
					ps.setString(2, mota);
					ps.setString(3, prezioa);
					ps.setString(4, fabrikatzailea);
					ps.executeUpdate();	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnGehituInformazioa.setBounds(275, 198, 151, 20);
		contentPane.add(btnGehituInformazioa);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(262, 10, 6, 243);
		contentPane.add(separator);
	}
}
