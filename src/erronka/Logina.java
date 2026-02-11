package erronka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	private Admin a = new Admin();
	private Informatikoa i = new Informatikoa();
	private LangileBurua lb = new LangileBurua();
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
	private JTextField textLangileId;
	private JTextField textPasahitzBerria;
	private JTextField textIritziId;
	private JTextField textErabiltzaileId;
	private JTextField textFakturaId;
	private JTable tableAdmin;

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
		setBounds(100, 100, 668, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * MENU ADMIN
		 */

		JPanel adminp = new JPanel();
		adminp.setVisible(false);
		adminp.setLayout(null);
		adminp.setBounds(0, 0, 644, 289);
		contentPane.add(adminp);

		tableAdmin = new JTable();
		tableAdmin.setBounds(0, 0, 248, 238);

		JScrollPane scrollPanelAdmin = new JScrollPane();
		scrollPanelAdmin.setBounds(0, 0, 266, 238);
		adminp.add(scrollPanelAdmin);
		scrollPanelAdmin.setViewportView(tableAdmin);

		a.KonpondutakoProduktuakIkusi(tableAdmin);

		JButton btnIritziaIkusi = new JButton("Iritziak ikusi");
		btnIritziaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.IritziakIrakurri(tableAdmin);
			}
		});
		btnIritziaIkusi.setBounds(209, 260, 116, 20);
		adminp.add(btnIritziaIkusi);

		JButton btnLangileenInfIkusi = new JButton("Langileen info ikusi");
		btnLangileenInfIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.LangileenInformazioaIkusi(tableAdmin);
			}
		});
		btnLangileenInfIkusi.setBounds(473, 260, 171, 20);
		adminp.add(btnLangileenInfIkusi);

		JButton btnErosketakIkusi = new JButton("Erosketak ikusi");
		btnErosketakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.ErosketaIkusi(tableAdmin);
			}
		});
		btnErosketakIkusi.setBounds(333, 260, 130, 20);
		adminp.add(btnErosketakIkusi);

		JButton btnKonponketaErregistroa = new JButton("Konponketa erregistroa ikusi");
		btnKonponketaErregistroa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.KonpondutakoProduktuakIkusi(tableAdmin);
			}
		});
		btnKonponketaErregistroa.setBounds(439, 230, 205, 20);
		adminp.add(btnKonponketaErregistroa);

		JButton btnErabiltzaileakIkusi = new JButton("Erabiltzaileak ikusi");
		btnErabiltzaileakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.ErabiltzaileakIkusi(tableAdmin);
			}
		});
		btnErabiltzaileakIkusi.setBounds(276, 230, 153, 20);
		adminp.add(btnErabiltzaileakIkusi);

		JLabel lblLangileId = new JLabel("Langile id: ");
		lblLangileId.setBounds(355, 28, 74, 12);
		adminp.add(lblLangileId);

		textLangileId = new JTextField();
		textLangileId.setColumns(10);
		textLangileId.setBounds(430, 26, 96, 17);
		adminp.add(textLangileId);

		JLabel lblPasahitzBerria = new JLabel("Pasahitz berria: ");
		lblPasahitzBerria.setBounds(537, 10, 107, 12);
		adminp.add(lblPasahitzBerria);

		textPasahitzBerria = new JTextField();
		textPasahitzBerria.setColumns(10);
		textPasahitzBerria.setBounds(548, 28, 96, 17);
		adminp.add(textPasahitzBerria);

		JButton btnPasahitzaAldatu = new JButton("Pasahitza aldatu");
		btnPasahitzaAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.PasahitzaAldatu(textPasahitzBerria.getText(), Integer.parseInt(textLangileId.getText()));
				textLangileId.setText("");
				textPasahitzBerria.setText("");
			}
		});
		btnPasahitzaAldatu.setBounds(460, 55, 146, 20);
		adminp.add(btnPasahitzaAldatu);

		JLabel lblErabiltzaileId = new JLabel("Erabiltzaile id: ");
		lblErabiltzaileId.setBounds(280, 100, 86, 12);
		adminp.add(lblErabiltzaileId);

		textErabiltzaileId = new JTextField();
		textErabiltzaileId.setColumns(10);
		textErabiltzaileId.setBounds(370, 100, 96, 17);
		adminp.add(textErabiltzaileId);

		JButton btnErabiltzaileakEzabatu = new JButton("Erabiltzaileak ezabatu");
		btnErabiltzaileakEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.ErabiltzaileakEzabatu(Integer.parseInt(textErabiltzaileId.getText()));
				textErabiltzaileId.setText("");
			}
		});
		btnErabiltzaileakEzabatu.setBounds(480, 100, 162, 20);
		adminp.add(btnErabiltzaileakEzabatu);

		JButton btnFitxatuIrteeraA = new JButton("Fitxatu Irteera");
		btnFitxatuIrteeraA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.Fitxatu("irteera");
			}
		});
		btnFitxatuIrteeraA.setBounds(480, 187, 116, 20);
		adminp.add(btnFitxatuIrteeraA);

		JButton btnFitxatuSarreraA = new JButton("Fitxatu sarrera");
		btnFitxatuSarreraA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.Fitxatu("sarrera");
			}
		});
		btnFitxatuSarreraA.setBounds(350, 187, 116, 20);
		adminp.add(btnFitxatuSarreraA);

		JLabel lblIritziId = new JLabel("Iritzi id: ");
		lblIritziId.setBounds(340, 147, 49, 12);
		adminp.add(lblIritziId);

		textIritziId = new JTextField();
		textIritziId.setColumns(10);
		textIritziId.setBounds(400, 145, 96, 17);
		adminp.add(textIritziId);

		JButton btnIritziaEzabatu = new JButton("Iritzia ezabatu");
		btnIritziaEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.IritziakEzabatu(Integer.parseInt(textIritziId.getText()));
				textIritziId.setText("");
			}
		});
		btnIritziaEzabatu.setBounds(500, 143, 138, 20);
		adminp.add(btnIritziaEzabatu);

		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(264, 83, 380, 6);
		adminp.add(separator_12);

		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(264, 130, 380, 6);
		adminp.add(separator_13);

		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(264, 176, 380, 6);
		adminp.add(separator_14);

		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(264, 220, 380, 6);
		adminp.add(separator_15);

		JSeparator separator_16 = new JSeparator();
		separator_16.setOrientation(SwingConstants.VERTICAL);
		separator_16.setBounds(188, 250, 6, 39);
		adminp.add(separator_16);

		/*
		 * 
		 * MENU LANGILE BURUA
		 * 
		 */

		JPanel panelLangileBurua = new JPanel();
		panelLangileBurua.setVisible(false);
		panelLangileBurua.setBounds(0, 0, 586, 263);
		panelLangileBurua.setBounds(0, 0, 644, 289);
		contentPane.add(panelLangileBurua);
		panelLangileBurua.setLayout(null);

		tableLangileBurua = new JTable();
		tableLangileBurua.setBounds(196, 0, 381, 108);

		JScrollPane scrollPaneLangileBurua = new JScrollPane();
		scrollPaneLangileBurua.setBounds(195, 9, 342, 102);
		panelLangileBurua.add(scrollPaneLangileBurua);
		scrollPaneLangileBurua.setViewportView(tableLangileBurua);

		lb.KonpondutakoProduktuakIkusi(tableLangileBurua);

		JButton btnIkusiErosketak = new JButton("Ikusi erosketak");
		btnIkusiErosketak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.ErosketaIkusi(tableLangileBurua);
			}
		});
		btnIkusiErosketak.setBounds(510, 160, 120, 20);
		panelLangileBurua.add(btnIkusiErosketak);

		JButton btnFormularioakIkusi = new JButton("Formularioak ikusi");
		btnFormularioakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.formularioakIkusi(tableLangileBurua);
			}
		});
		btnFormularioakIkusi.setBounds(500, 140, 140, 20);
		panelLangileBurua.add(btnFormularioakIkusi);

		JButton btnIkusiProduktuak = new JButton("Ikusi produktu");
		btnIkusiProduktuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.KonpondutakoProduktuakIkusi(tableLangileBurua);
			}
		});
		btnIkusiProduktuak.setBounds(510, 120, 122, 20);
		panelLangileBurua.add(btnIkusiProduktuak);

		JButton btnFitxatuIrteera = new JButton("Fitxatu irteera");
		btnFitxatuIrteera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.Fitxatu("irteera");
			}
		});
		btnFitxatuIrteera.setBounds(35, 259, 121, 20);
		panelLangileBurua.add(btnFitxatuIrteera);

		JButton btnFitxatuSarrera = new JButton("Fitxatu Sarrera");
		btnFitxatuSarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.Fitxatu("sarrera");
			}
		});
		btnFitxatuSarrera.setBounds(35, 239, 121, 20);
		panelLangileBurua.add(btnFitxatuSarrera);

		JLabel lblIzenaLB = new JLabel("Izena:");
		lblIzenaLB.setBounds(0, 11, 89, 12);
		panelLangileBurua.add(lblIzenaLB);

		JLabel lblMotaLB = new JLabel("Mota:");
		lblMotaLB.setBounds(0, 33, 89, 12);
		panelLangileBurua.add(lblMotaLB);

		JLabel lblPrezioaLB = new JLabel("Prezioa:");
		lblPrezioaLB.setBounds(0, 55, 89, 12);
		panelLangileBurua.add(lblPrezioaLB);

		JLabel lblKategoriaLB = new JLabel("Kategoria:");
		lblKategoriaLB.setBounds(0, 77, 89, 12);
		panelLangileBurua.add(lblKategoriaLB);

		JLabel lblEgoeraLB = new JLabel("Egoera:");
		lblEgoeraLB.setBounds(0, 99, 89, 12);
		panelLangileBurua.add(lblEgoeraLB);

		JLabel lblModeloaLB = new JLabel("Modeloa:");
		lblModeloaLB.setBounds(0, 121, 89, 12);
		panelLangileBurua.add(lblModeloaLB);

		JLabel lblKonektibitateaLB = new JLabel("Konektibitatea:");
		lblKonektibitateaLB.setBounds(0, 143, 89, 12);
		panelLangileBurua.add(lblKonektibitateaLB);

		JLabel lblStockLB = new JLabel("Stock:");
		lblStockLB.setBounds(0, 165, 89, 12);
		panelLangileBurua.add(lblStockLB);

		JLabel lblArgazkiaLB = new JLabel("Argazkia:");
		lblArgazkiaLB.setBounds(0, 187, 89, 12);
		panelLangileBurua.add(lblArgazkiaLB);

		textIzenaLB = new JTextField();
		textIzenaLB.setBounds(88, 8, 90, 18);
		panelLangileBurua.add(textIzenaLB);
		textIzenaLB.setColumns(10);

		textMotaLB = new JTextField();
		textMotaLB.setColumns(10);
		textMotaLB.setBounds(88, 30, 90, 18);
		panelLangileBurua.add(textMotaLB);

		textPrezioaLB = new JTextField();
		textPrezioaLB.setColumns(10);
		textPrezioaLB.setBounds(88, 52, 90, 18);
		panelLangileBurua.add(textPrezioaLB);

		textKategoriaLB = new JTextField();
		textKategoriaLB.setColumns(10);
		textKategoriaLB.setBounds(88, 74, 90, 18);
		panelLangileBurua.add(textKategoriaLB);

		JComboBox comboBoxEgoeraLB = new JComboBox();
		comboBoxEgoeraLB.setModel(new DefaultComboBoxModel(new String[] { "Ez ikusgai", "Ikusgai" }));
		comboBoxEgoeraLB.setBounds(88, 96, 90, 18);
		panelLangileBurua.add(comboBoxEgoeraLB);

		textModeloaLB = new JTextField();
		textModeloaLB.setColumns(10);
		textModeloaLB.setBounds(88, 118, 90, 18);
		panelLangileBurua.add(textModeloaLB);

		textKonektibitateaLB = new JTextField();
		textKonektibitateaLB.setColumns(10);
		textKonektibitateaLB.setBounds(88, 140, 90, 18);
		panelLangileBurua.add(textKonektibitateaLB);

		textStockLB = new JTextField();
		textStockLB.setColumns(10);
		textStockLB.setBounds(88, 162, 90, 18);
		panelLangileBurua.add(textStockLB);

		textArgazkiaLB = new JTextField();
		textArgazkiaLB.setColumns(10);
		textArgazkiaLB.setBounds(88, 184, 90, 18);
		panelLangileBurua.add(textArgazkiaLB);

		JButton btnGehituProduktuaLB = new JButton("Gehitu produktua");
		btnGehituProduktuaLB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produktua p = new Produktua(textIzenaLB.getText(), textKategoriaLB.getText(), textMotaLB.getText(),
						textModeloaLB.getText(), Double.parseDouble(textPrezioaLB.getText()),
						textKonektibitateaLB.getText(), textArgazkiaLB.getText(),
						(comboBoxEgoeraLB.getSelectedItem()).toString(), Integer.parseInt(textStockLB.getText()));
				lb.gehitu(p);
				textIzenaLB.setText("");
				textMotaLB.setText("");
				textPrezioaLB.setText("");
				textKategoriaLB.setText("");
				textModeloaLB.setText("");
				textKonektibitateaLB.setText("");
				textStockLB.setText("");
				textArgazkiaLB.setText("");
			}
		});
		btnGehituProduktuaLB.setBounds(10, 209, 176, 20);
		panelLangileBurua.add(btnGehituProduktuaLB);

		JLabel lblKopLB = new JLabel("Kopurua");
		lblKopLB.setBounds(280, 110, 57, 12);
		panelLangileBurua.add(lblKopLB);

		JComboBox comboBoxStockLB = new JComboBox();
		comboBoxStockLB.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxStockLB.setBounds(280, 125, 57, 20);
		panelLangileBurua.add(comboBoxStockLB);

		JLabel lblProduktuIdLB = new JLabel("Produktu id");
		lblProduktuIdLB.setBounds(205, 130, 68, 12);
		panelLangileBurua.add(lblProduktuIdLB);

		textProduktuIdLB = new JTextField();
		textProduktuIdLB.setBounds(205, 145, 68, 18);
		panelLangileBurua.add(textProduktuIdLB);
		textProduktuIdLB.setColumns(10);

		JButton btnKantitateaGehituLB = new JButton("Kantitatea gehitu");
		btnKantitateaGehituLB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kop = comboBoxStockLB.getSelectedIndex();
				int id = Integer.parseInt(textProduktuIdLB.getText());
				lb.ProduktuKantitateaGehitu(id, (kop + 1));
				textProduktuIdLB.setText("");
			}
		});
		btnKantitateaGehituLB.setBounds(347, 125, 134, 20);
		panelLangileBurua.add(btnKantitateaGehituLB);

		JLabel lblIzenaLangile = new JLabel("Izena:");
		lblIzenaLangile.setBounds(200, 190, 44, 12);
		panelLangileBurua.add(lblIzenaLangile);

		JLabel lblAbizenaLangile = new JLabel("Abizena:");
		lblAbizenaLangile.setBounds(340, 190, 54, 12);
		panelLangileBurua.add(lblAbizenaLangile);

		JLabel lblTelefonoaLangile = new JLabel("Telefonoa:");
		lblTelefonoaLangile.setBounds(195, 250, 67, 12);
		panelLangileBurua.add(lblTelefonoaLangile);

		JLabel lblEmailLangile = new JLabel("Email:");
		lblEmailLangile.setBounds(200, 220, 44, 12);
		panelLangileBurua.add(lblEmailLangile);

		JLabel lblKarguaLangile = new JLabel("Kargua:");
		lblKarguaLangile.setBounds(340, 250, 44, 12);
		panelLangileBurua.add(lblKarguaLangile);

		textIzenaLangile = new JTextField();
		textIzenaLangile.setBounds(240, 187, 44, 18);
		panelLangileBurua.add(textIzenaLangile);
		textIzenaLangile.setColumns(10);

		textAbizenaLangile = new JTextField();
		textAbizenaLangile.setColumns(10);
		textAbizenaLangile.setBounds(392, 187, 44, 18);
		panelLangileBurua.add(textAbizenaLangile);

		textTelefonoaLangile = new JTextField();
		textTelefonoaLangile.setColumns(10);
		textTelefonoaLangile.setBounds(260, 247, 68, 18);
		panelLangileBurua.add(textTelefonoaLangile);

		textEmailLangile = new JTextField();
		textEmailLangile.setColumns(10);
		textEmailLangile.setBounds(240, 217, 57, 18);
		panelLangileBurua.add(textEmailLangile);

		JComboBox comboBoxLangile = new JComboBox();
		comboBoxLangile.setModel(new DefaultComboBoxModel(new String[] { "Informatikoa", "Langile burua" }));
		comboBoxLangile.setBounds(394, 247, 112, 20);
		panelLangileBurua.add(comboBoxLangile);

		JLabel lblPasahitzaLangile = new JLabel("Pasahitza:");
		lblPasahitzaLangile.setBounds(340, 220, 70, 12);
		panelLangileBurua.add(lblPasahitzaLangile);

		textPasahitzaLangile = new JTextField();
		textPasahitzaLangile.setBounds(400, 217, 68, 18);
		panelLangileBurua.add(textPasahitzaLangile);
		textPasahitzaLangile.setColumns(10);

		JButton btnGehituLangilea = new JButton("Gehitu langilea");
		btnGehituLangilea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aukera = (comboBoxLangile.getSelectedItem()).toString();
				Pertsona p;
				if (aukera.equals("Informatikoa")) {
					p = new Informatikoa(textIzenaLangile.getText(), textAbizenaLangile.getText(),
							textEmailLangile.getText(), Integer.parseInt(textTelefonoaLangile.getText()),
							textPasahitzaLangile.getText(), aukera);
				} else {
					p = new LangileBurua(textIzenaLangile.getText(), textAbizenaLangile.getText(),
							textEmailLangile.getText(), Integer.parseInt(textTelefonoaLangile.getText()),
							textPasahitzaLangile.getText(), aukera);
				}
				lb.LangileakGehitu(p);
				textIzenaLangile.setText("");
				textAbizenaLangile.setText("");
				textTelefonoaLangile.setText("");
				textEmailLangile.setText("");
				textPasahitzaLangile.setText("");
			}
		});
		btnGehituLangilea.setBounds(280, 269, 125, 20);
		panelLangileBurua.add(btnGehituLangilea);

		JLabel lblPrezioaAldatu = new JLabel("Prezioa");
		lblPrezioaAldatu.setBounds(280, 145, 44, 12);
		panelLangileBurua.add(lblPrezioaAldatu);

		textPrezioaAldatu = new JTextField();
		textPrezioaAldatu.setBounds(280, 160, 57, 18);
		panelLangileBurua.add(textPrezioaAldatu);
		textPrezioaAldatu.setColumns(10);

		JButton btnPrezioaAldatu = new JButton("Prezioa aldatu");
		btnPrezioaAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double prezioa = Double.parseDouble(textPrezioaAldatu.getText());
				int id = Integer.parseInt(textProduktuIdLB.getText());
				lb.ProduktuPrezioaAldatu(id, prezioa);
				textProduktuIdLB.setText("");
				textPrezioaAldatu.setText("");
			}
		});
		btnPrezioaAldatu.setBounds(347, 160, 134, 20);
		panelLangileBurua.add(btnPrezioaAldatu);

		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(195, 105, 6, 185);
		panelLangileBurua.add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(0, 233, 193, 2);
		panelLangileBurua.add(separator_8);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(195, 183, 450, 4);
		panelLangileBurua.add(separator_9);

		JSeparator separator_10 = new JSeparator();
		separator_10.setOrientation(SwingConstants.VERTICAL);
		separator_10.setBounds(500, 105, 6, 77);
		panelLangileBurua.add(separator_10);

		JSeparator separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setBounds(516, 181, 6, 108);
		panelLangileBurua.add(separator_11);

		JLabel lblErosketaId = new JLabel("Erosketaren id");
		lblErosketaId.setBounds(540, 210, 89, 12);
		panelLangileBurua.add(lblErosketaId);

		textFakturaId = new JTextField();
		textFakturaId.setBounds(532, 230, 96, 18);
		panelLangileBurua.add(textFakturaId);
		textFakturaId.setColumns(10);

		JButton btnFaktura = new JButton("Faktura egin");
		btnFaktura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = DatabaseConnection.getConnection();
				String sql = "select eros.id,era.izena,eros.data,eros.bidalketa_egoera from erosketak eros inner join erabiltzaileak era on eros.erabiltzailea_id=era.id where eros.id=?";
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(textFakturaId.getText()));
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						Erosketak eros = new Erosketak(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4));
						String rutaLocala = eros.fakturaSortu(eros.getId());
						String pdfIzena = "faktura_" + eros.getId() + ".pdf";
						eros.fakturaIgo(rutaLocala, pdfIzena);
						try {
							Files.deleteIfExists(Paths.get(rutaLocala));
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						eros.setPdf("http://192.168.115.154/ERRONKA2/pdf/" + pdfIzena);
						eros.setBidalketa_egoera("prest");
						sql = "update erosketak set bidalketa_egoera=?, factura_pdf=? where id=?";
						PreparedStatement psUpdate = conn.prepareStatement(sql);
						psUpdate.setString(1, eros.getBidalketa_egoera());
						psUpdate.setString(2, eros.getPdf());
						psUpdate.setInt(3, eros.getId());
						psUpdate.executeUpdate();
					}
					textFakturaId.setText("");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFaktura.setBounds(520, 260, 116, 20);
		panelLangileBurua.add(btnFaktura);

		JLabel lblFaktura = new JLabel("FAKTURA");
		lblFaktura.setBounds(552, 187, 57, 12);
		panelLangileBurua.add(lblFaktura);

		/*
		 * MENU INFORMATIKOA
		 */

		JPanel panelMenuInfor = new JPanel();
		panelMenuInfor.setVisible(false);
		panelMenuInfor.setLayout(null);
		panelMenuInfor.setBounds(39, 23, 578, 253);
		contentPane.add(panelMenuInfor);

		tableInformatikoa = new JTable();
		tableInformatikoa.setBounds(0, 0, 366, 184);

		JScrollPane scrollPaneInfor = new JScrollPane();
		scrollPaneInfor.setBounds(24, 5, 342, 174);
		panelMenuInfor.add(scrollPaneInfor);
		scrollPaneInfor.setViewportView(tableInformatikoa);

		i.IkusiKonpontzekoProduktuak(tableInformatikoa);

		JToggleButton tglbtnProduktuakFormularioakIkusi = new JToggleButton("Tabla aldatu");
		tglbtnProduktuakFormularioakIkusi.setBounds(420, 224, 105, 20);
		panelMenuInfor.add(tglbtnProduktuakFormularioakIkusi);

		tglbtnProduktuakFormularioakIkusi.addActionListener(e -> {
			if (tglbtnProduktuakFormularioakIkusi.isSelected() == true) {
				i.formularioakIkusi(tableInformatikoa);
			} else {
				i.IkusiKonpontzekoProduktuak(tableInformatikoa);
			}
		});

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
		lblGehituProd.setBounds(400, 5, 140, 12);
		panelMenuInfor.add(lblGehituProd);

		JLabel lblMotaInf = new JLabel("Mota:");
		lblMotaInf.setBounds(476, 22, 90, 12);
		panelMenuInfor.add(lblMotaInf);

		textMotaInf = new JTextField();
		textMotaInf.setColumns(10);
		textMotaInf.setBounds(476, 38, 90, 18);
		panelMenuInfor.add(textMotaInf);

		JLabel lblStockInf = new JLabel("Stock:");
		lblStockInf.setBounds(476, 60, 90, 12);
		panelMenuInfor.add(lblStockInf);

		textStockInf = new JTextField();
		textStockInf.setColumns(10);
		textStockInf.setBounds(476, 76, 90, 18);
		panelMenuInfor.add(textStockInf);

		JLabel lblKategoriaInf = new JLabel("Kategoria:");
		lblKategoriaInf.setBounds(476, 98, 90, 12);
		panelMenuInfor.add(lblKategoriaInf);

		textKategoriaInf = new JTextField();
		textKategoriaInf.setColumns(10);
		textKategoriaInf.setBounds(476, 114, 90, 18);
		panelMenuInfor.add(textKategoriaInf);

		JLabel lblKonektibitateaInf = new JLabel("Konektibitatea:");
		lblKonektibitateaInf.setBounds(476, 136, 90, 12);
		panelMenuInfor.add(lblKonektibitateaInf);

		textKonektibitateaInf = new JTextField();
		textKonektibitateaInf.setColumns(10);
		textKonektibitateaInf.setBounds(476, 152, 90, 18);
		panelMenuInfor.add(textKonektibitateaInf);

		JLabel lblIzenaInf = new JLabel("Izena:");
		lblIzenaInf.setBounds(376, 22, 90, 12);
		panelMenuInfor.add(lblIzenaInf);

		textIzenaInf = new JTextField();
		textIzenaInf.setColumns(10);
		textIzenaInf.setBounds(376, 38, 90, 18);
		panelMenuInfor.add(textIzenaInf);

		JLabel lblPrezioaInf = new JLabel("Prezioa:");
		lblPrezioaInf.setBounds(376, 60, 90, 12);
		panelMenuInfor.add(lblPrezioaInf);

		textPrezioaInf = new JTextField();
		textPrezioaInf.setColumns(10);
		textPrezioaInf.setBounds(376, 76, 90, 18);
		panelMenuInfor.add(textPrezioaInf);

		JLabel lblEgoeraInf = new JLabel("Egoera:");
		lblEgoeraInf.setBounds(376, 98, 90, 12);
		panelMenuInfor.add(lblEgoeraInf);

		JComboBox comboBoxEgoeraInf = new JComboBox();
		comboBoxEgoeraInf.setModel(new DefaultComboBoxModel(new String[] { "Ez ikusgai", "Ikusgai" }));
		comboBoxEgoeraInf.setBounds(376, 114, 90, 18);
		panelMenuInfor.add(comboBoxEgoeraInf);

		JLabel lblModeloaInf = new JLabel("Modeloa:");
		lblModeloaInf.setBounds(376, 136, 90, 12);
		panelMenuInfor.add(lblModeloaInf);

		textModeloaInf = new JTextField();
		textModeloaInf.setColumns(10);
		textModeloaInf.setBounds(376, 152, 90, 18);
		panelMenuInfor.add(textModeloaInf);

		JLabel lblArgazkiaInf = new JLabel("Argazkia:");
		lblArgazkiaInf.setBounds(376, 174, 90, 12);
		panelMenuInfor.add(lblArgazkiaInf);

		textArgazkiaInf = new JTextField();
		textArgazkiaInf.setColumns(10);
		textArgazkiaInf.setBounds(376, 190, 90, 18);
		panelMenuInfor.add(textArgazkiaInf);

		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produktua p = new Produktua(textIzenaInf.getText(), textKategoriaInf.getText(), textMotaInf.getText(),
						textModeloaInf.getText(), Double.parseDouble(textPrezioaInf.getText()),
						textKonektibitateaInf.getText(), textArgazkiaInf.getText(),
						(comboBoxEgoeraInf.getSelectedItem()).toString(), Integer.parseInt(textStockInf.getText()));
				i.gehitu(p);
				textIzenaInf.setText("");
				textKategoriaInf.setText("");
				textMotaInf.setText("");
				textModeloaInf.setText("");
				textPrezioaInf.setText("");
				textKonektibitateaInf.setText("");
				textArgazkiaInf.setText("");
				textStockInf.setText("");
			}
		});
		btnGehitu.setBounds(476, 180, 90, 20);
		panelMenuInfor.add(btnGehitu);

		JLabel lblAldatuSaltzekoEgoera = new JLabel("Saltzeko egoera");
		lblAldatuSaltzekoEgoera.setBounds(156, 200, 99, 18);
		panelMenuInfor.add(lblAldatuSaltzekoEgoera);

		textAldatuSaltzekoEgoera = new JTextField();
		textAldatuSaltzekoEgoera.setColumns(10);
		textAldatuSaltzekoEgoera.setBounds(170, 220, 29, 18);
		panelMenuInfor.add(textAldatuSaltzekoEgoera);

		JButton btnSaltzekoEgoeraAldatu = new JButton("Egoera aldatu");
		btnSaltzekoEgoeraAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.KonponketaAldatu(Integer.parseInt(textAldatuSaltzekoEgoera.getText()));
				textAldatuSaltzekoEgoera.setText("");
			}
		});
		btnSaltzekoEgoeraAldatu.setBounds(208, 220, 148, 20);
		panelMenuInfor.add(btnSaltzekoEgoeraAldatu);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(140, 178, 6, 75);
		panelMenuInfor.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(365, 178, 12, 75);
		panelMenuInfor.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(365, 216, 212, 6);
		panelMenuInfor.add(separator_6);

		/*
		 * MENU LOGIN
		 */

		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(103, 10, 426, 253);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(166, 55, 105, 12);
		panelLogin.add(lblErabiltzailea);

		textErabiltzailea = new JTextField();
		textErabiltzailea.setBounds(166, 77, 106, 18);
		panelLogin.add(textErabiltzailea);
		textErabiltzailea.setColumns(10);

		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(166, 106, 105, 12);
		panelLogin.add(lblPasahitza);

		textPasahitza = new JTextField();
		textPasahitza.setColumns(10);
		textPasahitza.setBounds(165, 128, 106, 18);
		panelLogin.add(textPasahitza);

		JButton btnSarrera = new JButton("SARTU");
		btnSarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String era = textErabiltzailea.getText();
				String pas = textPasahitza.getText();

				try {
					String sql = "SELECT * FROM langileak WHERE email = ? AND pasahitza = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, era);
					ps.setString(2, pas);

					ResultSet rs = ps.executeQuery();

					if (rs.next()) {
						String rol = rs.getString("kargua");
						switch (rol.toLowerCase()) {
						case "informatikoa":
							i = new Informatikoa(rs.getInt("id"), rs.getString("izena"), rs.getString("abizena"),
									rs.getString("email"), rs.getInt("telefonoa"), rs.getString("pasahitza"),
									rs.getString("kargua"));
							panelMenuInfor.setVisible(true);
							break;
						case "admin":
							a = new Admin(rs.getInt("id"), rs.getString("izena"), rs.getString("abizena"),
									rs.getString("email"), rs.getInt("telefonoa"), rs.getString("pasahitza"),
									rs.getString("kargua"));
							adminp.setVisible(true);
							break;
						case "langile burua":
							lb = new LangileBurua(rs.getInt("id"), rs.getString("izena"), rs.getString("abizena"),
									rs.getString("email"), rs.getInt("telefonoa"), rs.getString("pasahitza"),
									rs.getString("kargua"));
							panelLangileBurua.setVisible(true);
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
		btnSarrera.setBounds(175, 160, 84, 20);
		panelLogin.add(btnSarrera);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(153, 45, 3, 164);
		panelLogin.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(281, 45, 3, 164);
		panelLogin.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(153, 45, 129, 6);
		panelLogin.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(153, 210, 129, 6);
		panelLogin.add(separator_3);
	}
}
