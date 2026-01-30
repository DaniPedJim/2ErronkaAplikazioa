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
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Logina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textErabiltzailea;
	private JTextField textPasahitza;
	
	private Admin a=new Admin();
	private Informatikoa i=new Informatikoa();
	private LangileBurua lb=new LangileBurua();
	private JTable tableInformatikoa;
	private JTextField textMotaInf;
	private JTextField textStockInf;
	private JTextField textKategoriaInf;
	private JTextField textKonektibitateaInf;
	private JTextField textIzenaInf;
	private JTextField textPrezioaInf;
	private JTextField textModeloaInf;
	private JTextField textArgazkiaInf;
	private JTextField textAldatuSaltzekoEgoera;
	private JTable tableLangileBurua;
	private JTextField textIzenaLB;
	private JTextField textMotaLB;
	private JTextField textPrezioaLB;
	private JTextField textKategoriaLB;
	private JTextField textModeloaLB;
	private JTextField textKonektibitateaLB;
	private JTextField textStockLB;
	private JTextField textArgazkiaLB;
	private JTextField textProduktuIdLB;
	private JTextField textIzenaLangile;
	private JTextField textAbizenaLangile;
	private JTextField textTelefonoaLangile;
	private JTextField textEmailLangile;
	private JTextField textPrezioaAldatu;
	private JTextField textPasahitzaLangile;

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
		
		
		/*
							MENU INFORMATIKOA
		*/
		
		
		JPanel panelMenuInfor = new JPanel();
		panelMenuInfor.setVisible(false);
		panelMenuInfor.setLayout(null);
		panelMenuInfor.setBounds(0, 0, 576, 252);
		contentPane.add(panelMenuInfor);
		
		tableInformatikoa = new JTable();
		tableInformatikoa.setBounds(0, 0, 366, 184);
		panelMenuInfor.add(tableInformatikoa);
		
		i.IkusiKonpontzekoProduktuak(tableInformatikoa, conn);
		
		JButton btnFitxatuS = new JButton("Fitxatu sarrera");
		btnFitxatuS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.Fitxatu("sarrera");
			}
		});
		btnFitxatuS.setBounds(10, 194, 120, 20);
		panelMenuInfor.add(btnFitxatuS);
		
		JButton btnFitxatuI = new JButton("Fitxatu irteera");
		btnFitxatuI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.Fitxatu("irteera");
			}
		});
		btnFitxatuI.setBounds(10, 224, 120, 20);
		panelMenuInfor.add(btnFitxatuI);
		
		JLabel lblGehituProd = new JLabel("PRODUKTUAK GEHITU");
		lblGehituProd.setHorizontalAlignment(SwingConstants.CENTER);
		lblGehituProd.setBounds(397, 0, 140, 12);
		panelMenuInfor.add(lblGehituProd);
		
		JLabel lblMotaInf = new JLabel("Mota:");
		lblMotaInf.setBounds(476, 22, 90, 12);
		panelMenuInfor.add(lblMotaInf);
		
		textMotaInf = new JTextField();
		textMotaInf.setColumns(10);
		textMotaInf.setBounds(476, 45, 90, 18);
		panelMenuInfor.add(textMotaInf);
		
		JLabel lblStockInf = new JLabel("Stock:");
		lblStockInf.setBounds(476, 72, 90, 12);
		panelMenuInfor.add(lblStockInf);
		
		textStockInf = new JTextField();
		textStockInf.setColumns(10);
		textStockInf.setBounds(476, 94, 90, 18);
		panelMenuInfor.add(textStockInf);
		
		JLabel lblKategoriaInf = new JLabel("Kategoria:");
		lblKategoriaInf.setBounds(476, 122, 90, 12);
		panelMenuInfor.add(lblKategoriaInf);
		
		textKategoriaInf = new JTextField();
		textKategoriaInf.setColumns(10);
		textKategoriaInf.setBounds(476, 144, 90, 18);
		panelMenuInfor.add(textKategoriaInf);
		
		JLabel lblKonektibitateaInf = new JLabel("Konektibitatea:");
		lblKonektibitateaInf.setBounds(476, 173, 90, 12);
		panelMenuInfor.add(lblKonektibitateaInf);
		
		textKonektibitateaInf = new JTextField();
		textKonektibitateaInf.setColumns(10);
		textKonektibitateaInf.setBounds(476, 195, 90, 18);
		panelMenuInfor.add(textKonektibitateaInf);
		
		JLabel lblIzenaInf = new JLabel("Izena:");
		lblIzenaInf.setBounds(376, 22, 90, 12);
		panelMenuInfor.add(lblIzenaInf);
		
		textIzenaInf = new JTextField();
		textIzenaInf.setColumns(10);
		textIzenaInf.setBounds(376, 45, 90, 18);
		panelMenuInfor.add(textIzenaInf);
		
		JLabel lblPrezioaInf = new JLabel("Prezioa:");
		lblPrezioaInf.setBounds(376, 72, 90, 12);
		panelMenuInfor.add(lblPrezioaInf);
		
		textPrezioaInf = new JTextField();
		textPrezioaInf.setColumns(10);
		textPrezioaInf.setBounds(376, 94, 90, 18);
		panelMenuInfor.add(textPrezioaInf);
		
		JLabel lblEgoeraInf = new JLabel("Egoera:");
		lblEgoeraInf.setBounds(376, 122, 90, 12);
		panelMenuInfor.add(lblEgoeraInf);
		
		JComboBox comboBoxEgoeraInf = new JComboBox();
		comboBoxEgoeraInf.setModel(new DefaultComboBoxModel(new String[] {"Ez ikusgai", "Ikusgai"}));
		comboBoxEgoeraInf.setBounds(376, 144, 90, 18);
		panelMenuInfor.add(comboBoxEgoeraInf);
		
		JLabel lblModeloaInf = new JLabel("Modeloa:");
		lblModeloaInf.setBounds(376, 173, 90, 12);
		panelMenuInfor.add(lblModeloaInf);
		
		textModeloaInf = new JTextField();
		textModeloaInf.setColumns(10);
		textModeloaInf.setBounds(376, 195, 90, 18);
		panelMenuInfor.add(textModeloaInf);
		
		JLabel lblArgazkiaInf = new JLabel("Argazkia:");
		lblArgazkiaInf.setBounds(376, 213, 90, 12);
		panelMenuInfor.add(lblArgazkiaInf);
		
		textArgazkiaInf = new JTextField();
		textArgazkiaInf.setColumns(10);
		textArgazkiaInf.setBounds(376, 235, 90, 18);
		panelMenuInfor.add(textArgazkiaInf);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produktua p=new Produktua(textIzenaInf.getText(),textKategoriaInf.getText(),textMotaInf.getText(),textModeloaInf.getText(),Double.parseDouble(textPrezioaInf.getText()),textKonektibitateaInf.getText(),textArgazkiaInf.getText(),(comboBoxEgoeraInf.getSelectedItem()).toString(),Integer.parseInt(textStockInf.getText()));
				i.gehitu(p);
			}
		});
		btnGehitu.setBounds(476, 224, 90, 20);
		panelMenuInfor.add(btnGehitu);
		
		JLabel lblAldatuSaltzekoEgoera = new JLabel("Saltzeko egoera");
		lblAldatuSaltzekoEgoera.setBounds(140, 190, 99, 18);
		panelMenuInfor.add(lblAldatuSaltzekoEgoera);
		
		textAldatuSaltzekoEgoera = new JTextField();
		textAldatuSaltzekoEgoera.setColumns(10);
		textAldatuSaltzekoEgoera.setBounds(156, 210, 29, 18);
		panelMenuInfor.add(textAldatuSaltzekoEgoera);
		
		JButton btnSaltzekoEgoeraAldatu = new JButton("Egoera aldatu");
		btnSaltzekoEgoeraAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.KonponketaAldatu(Integer.parseInt(textAldatuSaltzekoEgoera.getText()), conn);
			}
		});
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
		
		
		/*
					MENU LOGIN
		*/
		
		
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
		                	break;
		                case "admin":
		                	a=new Admin(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
		                	break;
		                case "langile burua":
		                	lb=new LangileBurua(rs.getInt("id"),rs.getString("izena"),rs.getString("abizena"),rs.getString("kargua"),rs.getString("email"),rs.getInt("telefonoa"),rs.getString("pasahitza"));
		                	break;
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
