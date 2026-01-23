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
	
	private Admin a;
	private Informatikoa i=new Informatikoa();
	private LangileBurua lb;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenuInfor = new JPanel();
		panelMenuInfor.setLayout(null);
		panelMenuInfor.setVisible(false);
		panelMenuInfor.setBounds(0, 0, 576, 252);
		contentPane.add(panelMenuInfor);
		
		table = new JTable();
		table.setBounds(0, 0, 366, 184);
		panelMenuInfor.add(table);
		
		i.IkusiKonpontzekoProduktuak(table, conn);
		
		JButton btnFitxatuS = new JButton("Fitxatu sarrera");
		btnFitxatuS.setBounds(10, 194, 120, 20);
		panelMenuInfor.add(btnFitxatuS);
		
		JButton btnFitxatuI = new JButton("Fitxatu irteera");
		btnFitxatuI.setBounds(10, 224, 120, 20);
		panelMenuInfor.add(btnFitxatuI);
		
		JLabel lblGehituProd = new JLabel("PRODUKTUAK GEHITU");
		lblGehituProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblGehituProd.setBounds(397, 0, 140, 12);
		panelMenuInfor.add(lblGehituProd);
		
		JLabel lblMota = new JLabel("Mota:");
		lblMota.setBounds(476, 22, 90, 12);
		panelMenuInfor.add(lblMota);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(476, 45, 90, 18);
		panelMenuInfor.add(textField);
		
		JLabel lblKantitatea = new JLabel("Kantitatea:");
		lblKantitatea.setBounds(476, 72, 90, 12);
		panelMenuInfor.add(lblKantitatea);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(476, 94, 90, 18);
		panelMenuInfor.add(textField_1);
		
		JLabel lblDeskribapena = new JLabel("Deskribapena:");
		lblDeskribapena.setBounds(476, 122, 90, 12);
		panelMenuInfor.add(lblDeskribapena);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(476, 144, 90, 18);
		panelMenuInfor.add(textField_2);
		
		JLabel lblKonponketa = new JLabel("Konponketa:");
		lblKonponketa.setBounds(476, 173, 90, 12);
		panelMenuInfor.add(lblKonponketa);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(476, 195, 90, 18);
		panelMenuInfor.add(textField_3);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(376, 22, 90, 12);
		panelMenuInfor.add(lblIzena);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(376, 45, 90, 18);
		panelMenuInfor.add(textField_4);
		
		JLabel lblPrezioa = new JLabel("Prezioa:");
		lblPrezioa.setBounds(376, 72, 90, 12);
		panelMenuInfor.add(lblPrezioa);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(376, 94, 90, 18);
		panelMenuInfor.add(textField_5);
		
		JLabel lblEgoera = new JLabel("Egoera:");
		lblEgoera.setBounds(376, 122, 90, 12);
		panelMenuInfor.add(lblEgoera);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(376, 144, 90, 18);
		panelMenuInfor.add(textField_6);
		
		JLabel lblSaltzeko_egoera = new JLabel("Saltzeko egoera:");
		lblSaltzeko_egoera.setBounds(376, 173, 90, 12);
		panelMenuInfor.add(lblSaltzeko_egoera);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(376, 195, 90, 18);
		panelMenuInfor.add(textField_7);
		
		JLabel lblArgazkia = new JLabel("Argazkia:");
		lblArgazkia.setBounds(376, 213, 90, 12);
		panelMenuInfor.add(lblArgazkia);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(376, 235, 90, 18);
		panelMenuInfor.add(textField_8);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.setBounds(476, 224, 90, 20);
		panelMenuInfor.add(btnGehitu);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(156, 210, 29, 18);
		panelMenuInfor.add(textField_9);
		
		JButton btnSaltzekoEgoeraAldatu = new JButton("Saltzeko egoera aldatu");
		btnSaltzekoEgoeraAldatu.setBounds(206, 209, 148, 20);
		panelMenuInfor.add(btnSaltzekoEgoeraAldatu);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(140, 178, 6, 75);
		panelMenuInfor.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(364, 178, 12, 75);
		panelMenuInfor.add(separator_5);
		
		
		
		
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(103, 10, 426, 253);
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
		                	i=new Informatikoa(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
		                	panelMenuInfor.setVisible(true);
		                case "admin":
		                	a=new Admin(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
		                case "langileBurua":
		                	lb=new LangileBurua(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
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
