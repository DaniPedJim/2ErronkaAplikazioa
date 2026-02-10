package erronka;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Erosketak {
	private int id;
	private String izena;
	private Date data;
	private String bidalketa_egoera;
	private String pdf;

//Konstruktorea
	public Erosketak(int id, String izena, Date data, String egoera) {
		this.id = id;
		this.izena = izena;
		this.data = data;
		this.bidalketa_egoera = egoera;
	}

	public Erosketak(int id, String izena, Date data, String egoera, String pdf) {
		this.id = id;
		this.izena = izena;
		this.data = data;
		this.bidalketa_egoera = egoera;
		this.pdf = pdf;
	}

	// Metodoak
	public String fakturaSortu(int id) {
		Connection conn = DatabaseConnection.getConnection();
		String ruta = "faktura_" + id + ".pdf";
		// PDF sortu
		try (PDDocument document = new PDDocument()) {
			// Lehenengo orria sortu
			PDPage page = new PDPage();
			document.addPage(page);

			PDPageContentStream content = new PDPageContentStream(document, page);
			content.beginText();
			// Orriaren tamaina
			int pageHeight = (int) page.getTrimBox().getHeight();
			int pageWidth = (int) page.getTrimBox().getWidth();
			// Textu mota, tamaina eta beraien arteko banaketa
			content.setFont(PDType1Font.HELVETICA_BOLD, 20);
			content.setLeading(40f);
			// PDF-ren non agertuko da
			content.newLineAtOffset(50, pageHeight - 50);
			// Textua erakutsi eta "salto de linea" egiten du
			content.showText("FAKTURA #" + id);
			content.newLine();
			content.setFont(PDType1Font.HELVETICA, 12);
			content.showText("BERRITECH");
			content.newLine();
			content.setLeading(20f);
			content.showText("Arranomendia 2");
			content.newLine();
			content.showText("20240 Ordizia, Gipuzkoa");
			content.endText();
			// Logoa sortu eta jarri
			PDImageXObject logoa = PDImageXObject.createFromFile("logoa/LogoErronka.png", document);
			content.drawImage(logoa, pageWidth - 200, pageHeight - 125, 200, 118);
			// Erosketaren taula sortu
			int ardatzaX = 40;
			int ardatzaY = pageHeight - 225;
			int laukiHeight = 30;
			int zutabeKop = 4;
			double totala = 0;
			String sql = "select ex.kantitatea,p.izena,ex.prezioa_momentuan from erosketa_xehetasunak ex inner join produktuak p on ex.produktua_id=p.id where erosketa_id=?";
			ArrayList<ErosketaXehetasunak> lista = new ArrayList<ErosketaXehetasunak>();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ErosketaXehetasunak ex = new ErosketaXehetasunak(rs.getInt(1), rs.getString(2), rs.getDouble(3));
					lista.add(ex);
				}
				for (int i = -1; i < lista.size(); i++) {
					for (int j = 0; j < zutabeKop; j++) {
						String informazioa = "";
						int width = 0;
						switch (j) {
						case 0:
							if (i == -1) {
								informazioa = "KOP";
							} else {
								informazioa = Integer.toString(lista.get(i).getKantitatea());
							}
							width = 40;
							break;
						case 1:
							if (i == -1) {
								informazioa = "PRODUKTUA";
							} else {
								informazioa = lista.get(i).getIzena();
							}
							width = 330;
							break;
						case 2:
							if (i == -1) {
								informazioa = "€/UNIT";
							} else {
								informazioa = String.valueOf(lista.get(i).getPrezioa()) + "€";
							}
							width = 60;
							break;
						case 3:
							if (i == -1) {
								informazioa = "GUZTIRA";
							} else {
								informazioa = String.valueOf(lista.get(i).getKantitatea() * lista.get(i).getPrezioa())
										+ "€";
								totala += lista.get(i).getKantitatea() * lista.get(i).getPrezioa();
							}
							width = 70;
							break;
						}
						content.addRect(ardatzaX, ardatzaY, width, -laukiHeight);
						content.stroke();
						content.beginText();
						content.newLineAtOffset(ardatzaX + 8, ardatzaY - 20);
						content.setFont(PDType1Font.HELVETICA, 12);
						content.showText(informazioa);
						content.endText();
						ardatzaX += width;
					}
					ardatzaX = 40;
					ardatzaY -= laukiHeight;
				}
				content.beginText();
				content.setFont(PDType1Font.HELVETICA_BOLD, 18);
				content.newLineAtOffset(380, ardatzaY - 60);
				content.showText("TOTALA:");
				content.newLineAtOffset(90, 0);
				content.showText(String.valueOf(totala + "€"));
				content.endText();
				// Textuak eta tabla bukatzen ditu eta pdf itxi
				content.close();
				document.save(ruta);
				return ruta;
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void fakturaIgo(String rutaLocala, String pdfIzena) {
		String zerbitzaria = "192.168.115.154";
		int puerto = 21;
		String erabiltzailea = "daniel";
		String pasahitza = "1MG3";
		String rutaRemota = "";

		FTPClient ftp = new FTPClient();

		try (FileInputStream fis = new FileInputStream(rutaLocala)) {
			ftp.connect(zerbitzaria, puerto);
			ftp.login(erabiltzailea, pasahitza);
			ftp.enterLocalPassiveMode();
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.storeFile(rutaRemota + pdfIzena, fis);
			ftp.logout();
			ftp.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Getter eta setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getBidalketa_egoera() {
		return bidalketa_egoera;
	}

	public void setBidalketa_egoera(String bidalketa_egoera) {
		this.bidalketa_egoera = bidalketa_egoera;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
}