package erronka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class Logina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textErabiltzailea;
	private JTextField textPasahitza;
	private JTable table;
	
	private Pertsona p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logina frame = new Logina();
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
	public Logina() {
		Connection conn = DatabaseConnection.getConnection();
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenuInfor = new JPanel();
		panelMenuInfor.setVisible(false);
		panelMenuInfor.setBounds(10, 10, 426, 253);
		contentPane.add(panelMenuInfor);
		panelMenuInfor.setLayout(null);
		
		JButton btnFitxatuS = new JButton("Fitxatu sarrera");
		btnFitxatuS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.Fitxatu("sarrera");
			}
		});
		btnFitxatuS.setBounds(296, 10, 120, 20);
		panelMenuInfor.add(btnFitxatuS);
		
		JButton btnFitxatuI = new JButton("Fitxatu irteera");
		btnFitxatuI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.Fitxatu("irteera");
			}
		});
		btnFitxatuI.setBounds(296, 42, 120, 20);
		panelMenuInfor.add(btnFitxatuI);
		
		table = new JTable();
		table.setBounds(10, 10, 276, 184);
		panelMenuInfor.add(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(104, 223, 84, 20);
		panelMenuInfor.add(btnNewButton);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(10, 10, 426, 253);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(141, 55, 105, 12);
		panelLogin.add(lblErabiltzailea);
		
		textErabiltzailea = new JTextField();
		textErabiltzailea.setBounds(141, 77, 106, 18);
		panelLogin.add(textErabiltzailea);
		textErabiltzailea.setColumns(10);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(141, 106, 105, 12);
		panelLogin.add(lblPasahitza);
		
		textPasahitza = new JTextField();
		textPasahitza.setColumns(10);
		textPasahitza.setBounds(140, 128, 106, 18);
		panelLogin.add(textPasahitza);
		
		JButton btnSarrera = new JButton("SARTU");
		btnSarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String era=textErabiltzailea.getText();
				String pas=textPasahitza.getText();
				
				try {
					String sql = "SELECT * FROM langileak WHERE email = ? AND pasahitza = ?";
			        PreparedStatement ps = conn.prepareStatement(sql);
			        ps.setString(1, era);
			        ps.setString(2, pas);

			        ResultSet rs = ps.executeQuery();
			        
			        if (rs.next()) {
		                String rol = rs.getString("kargua");
		                switch(rol.toLowerCase()) {
		                case "informatikoa":
		                	p=new Informatikoa(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
		                	panelMenuInfor.setVisible(true);
		                case "admin":
		                	p=new Admin(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
		                case "langileBurua":
		                	p=new LangileBurua(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
		                }
		            } else {
		                System.out.println("Posta edo pasahitza okerra da.");
		            }
			        panelLogin.setVisible(false);
			        
		            rs.close();
		            ps.close();
		            conn.close();
			        
				} catch (Exception e2) {
					System.out.println("Errorea kontsultan: " + e2.getMessage());
				}
				
			}
		});
		btnSarrera.setBounds(150, 160, 84, 20);
		panelLogin.add(btnSarrera);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(128, 45, 3, 164);
		panelLogin.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(256, 45, 3, 164);
		panelLogin.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(128, 45, 129, 6);
		panelLogin.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(128, 210, 129, 6);
		panelLogin.add(separator_3);
	}
}
