package erronka;

import java.util.Scanner;

public abstract class LangileOrokorra extends Pertsona {
	//Konstruktorea
	public LangileOrokorra(int id,String ize,String abi,String kar,String ema,int tel,String pas) {
		super(id,ize,abi,kar,ema,tel,pas);
	}
	//Metodoak	
	public void EkipoakErregistratu() {
		Scanner sc = new Scanner(System.in);

        System.out.println("=== PRODUKTU BERRIA GEHITU ===");

        System.out.print("Produktuaren izena: ");
        String izena = sc.nextLine();

        System.out.print("Produktuaren mota (Ordenagailua, Mugikorra, Konponenta...): ");
        String mota = sc.nextLine();

        System.out.print("Prezioa (€): ");
        double prezioa = sc.nextDouble();
        sc.nextLine();

        System.out.print("Kantitatea: ");
        int kantitatea = sc.nextInt();
        sc.nextLine();

        System.out.print("Egoera (Lehen eskua / Bigarren eskua): ");
        String egoera = sc.nextLine();

        System.out.print("Deskribapena: ");
        String deskribapena = sc.nextLine();

        System.out.print("Saltzeko egoera (True = Salgai - False = Ez salgai): ");
        boolean saltzekoEgoera = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Konponketa egoera (adib. 'Konponduta', 'Konpontzen', 'Zain' edo hutsik): ");
        String konponketa = sc.nextLine();

        Produktua p = new Produktua(izena, mota, prezioa, kantitatea, egoera, deskribapena, saltzekoEgoera, konponketa);

        if (Produktua.gehitu(p) == true) {
            System.out.println("✅ Produktua ondo gehitu da datu-basera!");
        } else {
            System.out.println("❌ Errorea gertatu da produktua gehitzean.");
        }
    }
}
