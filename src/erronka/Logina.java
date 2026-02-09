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
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;

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
		//
		
		JPanel panelLangileBurua = new JPanel();
		panelLangileBurua.setVisible(false);
		
		JPanel adminp = new JPanel();
		adminp.setLayout(null);
		adminp.setBounds(0, 0, 585, 262);
		contentPane.add(adminp);
		
		JButton btnNewButton = new JButton("Iritzia ezabatu");
		btnNewButton.setBounds(356, 100, 106, 20);
		adminp.add(btnNewButton);
		
		JButton btnIritziaAldatu = new JButton("Iritziak ikusi");
		btnIritziaAldatu.setBounds(20, 242, 106, 20);
		adminp.add(btnIritziaAldatu);
		
		JLabel lblNewLabel = new JLabel("Langile id: ");
		lblNewLabel.setBounds(221, 104, 49, 12);
		adminp.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(366, 39, 96, 17);
		adminp.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitz berria: ");
		lblNewLabel_1.setBounds(251, 79, 74, 12);
		adminp.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 145, 96, 17);
		adminp.add(textField_1);
		
		JButton btnPasahitzaAldatu = new JButton("Pasahitza aldatu");
		btnPasahitzaAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPasahitzaAldatu.setBounds(241, 37, 120, 20);
		adminp.add(btnPasahitzaAldatu);
		
		JButton btnLangileenInfIkusi = new JButton("langileen info ikusi");
		btnLangileenInfIkusi.setBounds(236, 185, 184, 20);
		adminp.add(btnLangileenInfIkusi);
		
		JButton btnErosketakIkusi = new JButton("Erosketak ikusi");
		btnErosketakIkusi.setBounds(10, 220, 216, 20);
		adminp.add(btnErosketakIkusi);
		
		JButton btnKonponketaErregistroa = new JButton("Konponketa erregistroa ikusi");
		btnKonponketaErregistroa.setBounds(251, 232, 205, 20);
		adminp.add(btnKonponketaErregistroa);
		
		JButton btnErabiltzaileakIkusi = new JButton("Erabiltzaileak ikusi");
		btnErabiltzaileakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnErabiltzaileakIkusi.setBounds(132, 242, 120, 20);
		adminp.add(btnErabiltzaileakIkusi);
		
		JButton btnErabiltzaileakEzabatu = new JButton("Erabiltzaileak ezabatu");
		btnErabiltzaileakEzabatu.setBounds(314, 66, 205, 20);
		adminp.add(btnErabiltzaileakEzabatu);
		
		JButton btnNewButton_1 = new JButton("Fitxatu Irteera");
		btnNewButton_1.setBounds(413, 185, 106, 20);
		adminp.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Fitxatu sarrera");
		btnNewButton_1_1.setBounds(362, 161, 105, 20);
		adminp.add(btnNewButton_1_1);
		
		table = new JTable();
		table.setBounds(10, 17, 230, 205);
		adminp.add(table);
		
		JLabel lblIritziId = new JLabel("Iritzi id: ");
		lblIritziId.setBounds(276, 0, 49, 12);
		adminp.add(lblIritziId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(337, 16, 96, 17);
		adminp.add(textField_2);
		
		JLabel lblErabiltzaileId = new JLabel("Erabiltzaile id: ");
		lblErabiltzaileId.setBounds(428, 0, 74, 12);
		adminp.add(lblErabiltzaileId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(423, 16, 96, 17);
		adminp.add(textField_3);
		panelLangileBurua.setBounds(0, 0, 586, 263);
		contentPane.add(panelLangileBurua);
		panelLangileBurua.setLayout(null);

		tableLangileBurua = new JTable();
		tableLangileBurua.setBounds(187, 10, 389, 108);
		panelLangileBurua.add(tableLangileBurua);

		JToggleButton tglbtnErosketaProduktuaIkusiLB = new JToggleButton("Aldatu tabla");
		tglbtnErosketaProduktuaIkusiLB.setBounds(487, 128, 89, 20);
		panelLangileBurua.add(tglbtnErosketaProduktuaIkusiLB);

		lb.KonpondutakoProduktuakIkusi(tableLangileBurua,conn);
		tglbtnErosketaProduktuaIkusiLB.addActionListener(e -> {
		if(tglbtnErosketaProduktuaIkusiLB.isSelected()) {
		lb.ErosketaIkusi(tableLangileBurua,conn);
		}else {
		lb.KonpondutakoProduktuakIkusi(tableLangileBurua,conn);
		}
		});

		JButton btnFitxatuIrteera = new JButton("Fitxatu irteera");
		btnFitxatuIrteera.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		lb.Fitxatu("irteera");
		}
		});
		btnFitxatuIrteera.setBounds(99, 239, 96, 20);
		panelLangileBurua.add(btnFitxatuIrteera);

		JButton btnFitxatuSarrera = new JButton("Fitxatu Sarrera");
		btnFitxatuSarrera.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		lb.Fitxatu("sarrera");
		}
		});
		btnFitxatuSarrera.setBounds(0, 239, 101, 20);
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
		textIzenaLB.setBounds(99, 8, 78, 18);
		panelLangileBurua.add(textIzenaLB);
		textIzenaLB.setColumns(10);

		textMotaLB = new JTextField();
		textMotaLB.setColumns(10);
		textMotaLB.setBounds(99, 30, 78, 18);
		panelLangileBurua.add(textMotaLB);

		textPrezioaLB = new JTextField();
		textPrezioaLB.setColumns(10);
		textPrezioaLB.setBounds(99, 52, 78, 18);
		panelLangileBurua.add(textPrezioaLB);

		textKategoriaLB = new JTextField();
		textKategoriaLB.setColumns(10);
		textKategoriaLB.setBounds(99, 74, 78, 18);
		panelLangileBurua.add(textKategoriaLB);

		JComboBox comboBoxEgoeraLB = new JComboBox();
		comboBoxEgoeraLB.setModel(new DefaultComboBoxModel(new String[] {"Ez ikusgai", "Ikusgai"}));
		comboBoxEgoeraLB.setBounds(99, 96, 78, 18);
		panelLangileBurua.add(comboBoxEgoeraLB);

		textModeloaLB = new JTextField();
		textModeloaLB.setColumns(10);
		textModeloaLB.setBounds(99, 118, 78, 18);
		panelLangileBurua.add(textModeloaLB);

		textKonektibitateaLB = new JTextField();
		textKonektibitateaLB.setColumns(10);
		textKonektibitateaLB.setBounds(99, 140, 78, 18);
		panelLangileBurua.add(textKonektibitateaLB);

		textStockLB = new JTextField();
		textStockLB.setColumns(10);
		textStockLB.setBounds(99, 162, 78, 18);
		panelLangileBurua.add(textStockLB);

		textArgazkiaLB = new JTextField();
		textArgazkiaLB.setColumns(10);
		textArgazkiaLB.setBounds(99, 184, 78, 18);
		panelLangileBurua.add(textArgazkiaLB);

		JButton btnGehituProduktuaLB = new JButton("Gehitu produktua");
		btnGehituProduktuaLB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Produktua p=new Produktua(textIzenaLB.getText(),textKategoriaLB.getText(),textMotaLB.getText(),textModeloaLB.getText(),Double.parseDouble(textPrezioaLB.getText()),textKonektibitateaLB.getText(),textArgazkiaLB.getText(),(comboBoxEgoeraLB.getSelectedItem()).toString(),Integer.parseInt(textStockLB.getText()));
		lb.gehitu(p);
		}
		});
		btnGehituProduktuaLB.setBounds(0, 209, 176, 20);
		panelLangileBurua.add(btnGehituProduktuaLB);

		JLabel lblKopLB = new JLabel("Kopurua");
		lblKopLB.setBounds(280, 121, 57, 12);
		panelLangileBurua.add(lblKopLB);

		JComboBox comboBoxStockLB = new JComboBox();
		comboBoxStockLB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxStockLB.setBounds(280, 135, 57, 20);
		panelLangileBurua.add(comboBoxStockLB);

		JLabel lblProduktuIdLB = new JLabel("Produktu id");
		lblProduktuIdLB.setBounds(205, 144, 68, 12);
		panelLangileBurua.add(lblProduktuIdLB);

		textProduktuIdLB = new JTextField();
		textProduktuIdLB.setBounds(205, 159, 68, 18);
		panelLangileBurua.add(textProduktuIdLB);
		textProduktuIdLB.setColumns(10);

		JButton btnKantitateaGehituLB = new JButton("Kantitatea gehitu");
		btnKantitateaGehituLB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		int kop=comboBoxStockLB.getSelectedIndex();
		int id=Integer.parseInt(textProduktuIdLB.getText());
		lb.ProduktuKantitateaGehitu(id, (kop+1));
		}
		});
		btnKantitateaGehituLB.setBounds(347, 139, 112, 20);
		panelLangileBurua.add(btnKantitateaGehituLB);

		JLabel lblIzenaLangile = new JLabel("Izena:");
		lblIzenaLangile.setBounds(205, 221, 44, 12);
		panelLangileBurua.add(lblIzenaLangile);

		JLabel lblAbizenaLangile = new JLabel("Abizena:");
		lblAbizenaLangile.setBounds(205, 243, 54, 12);
		panelLangileBurua.add(lblAbizenaLangile);

		JLabel lblTelefonoaLangile = new JLabel("Telefonoa:");
		lblTelefonoaLangile.setBounds(304, 221, 67, 12);
		panelLangileBurua.add(lblTelefonoaLangile);

		JLabel lblEmailLangile = new JLabel("Email:");
		lblEmailLangile.setBounds(304, 243, 44, 12);
		panelLangileBurua.add(lblEmailLangile);

		JLabel lblKarguaLangile = new JLabel("Kargua:");
		lblKarguaLangile.setBounds(414, 243, 44, 12);
		panelLangileBurua.add(lblKarguaLangile);

		textIzenaLangile = new JTextField();
		textIzenaLangile.setBounds(250, 220, 44, 18);
		panelLangileBurua.add(textIzenaLangile);
		textIzenaLangile.setColumns(10);

		textAbizenaLangile = new JTextField();
		textAbizenaLangile.setColumns(10);
		textAbizenaLangile.setBounds(250, 240, 44, 18);
		panelLangileBurua.add(textAbizenaLangile);

		textTelefonoaLangile = new JTextField();
		textTelefonoaLangile.setColumns(10);
		textTelefonoaLangile.setBounds(357, 218, 68, 18);
		panelLangileBurua.add(textTelefonoaLangile);

		textEmailLangile = new JTextField();
		textEmailLangile.setColumns(10);
		textEmailLangile.setBounds(347, 240, 57, 18);
		panelLangileBurua.add(textEmailLangile);

		JComboBox comboBoxLangile = new JComboBox();
		comboBoxLangile.setModel(new DefaultComboBoxModel(new String[] {"Informatikoa", "Langile burua"}));
		comboBoxLangile.setBounds(464, 239, 112, 20);
		panelLangileBurua.add(comboBoxLangile);

		JLabel lblPasahitzaLangile = new JLabel("Pasahitza:");
		lblPasahitzaLangile.setBounds(435, 221, 57, 12);
		panelLangileBurua.add(lblPasahitzaLangile);

		textPasahitzaLangile = new JTextField();
		textPasahitzaLangile.setBounds(487, 218, 68, 18);
		panelLangileBurua.add(textPasahitzaLangile);
		textPasahitzaLangile.setColumns(10);

		JButton btnGehituLangilea = new JButton("Gehitu langilea");
		btnGehituLangilea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String aukera=(comboBoxLangile.getSelectedItem()).toString();
		Pertsona p;
		if(aukera.equals("Informatikoa")) {
		p=new Informatikoa(textIzenaLangile.getText(),textAbizenaLangile.getText(),aukera,textEmailLangile.getText(),Integer.parseInt(textTelefonoaLangile.getText()),textPasahitzaLangile.getText());
		}else {
		p=new LangileBurua(textIzenaLangile.getText(),textAbizenaLangile.getText(),aukera,textEmailLangile.getText(),Integer.parseInt(textTelefonoaLangile.getText()),textPasahitzaLangile.getText());
		}
		lb.LangileakGehitu(p);
		}
		});
		btnGehituLangilea.setBounds(487, 187, 106, 20);
		panelLangileBurua.add(btnGehituLangilea);

		JLabel lblPrezioaAldatu = new JLabel("Prezioa");
		lblPrezioaAldatu.setBounds(280, 165, 44, 12);
		panelLangileBurua.add(lblPrezioaAldatu);

		textPrezioaAldatu = new JTextField();
		textPrezioaAldatu.setBounds(280, 184, 57, 18);
		panelLangileBurua.add(textPrezioaAldatu);
		textPrezioaAldatu.setColumns(10);

		JButton btnPrezioaAldatu = new JButton("Prezioa aldatu");
		btnPrezioaAldatu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		double prezioa=Double.parseDouble(textPrezioaAldatu.getText());
		int id=Integer.parseInt(textProduktuIdLB.getText());
		lb.ProduktuPrezioaAldatu(id,prezioa);
		}
		});
		btnPrezioaAldatu.setBounds(347, 183, 112, 20);
		panelLangileBurua.add(btnPrezioaAldatu);
		
		
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
