package erronka;

import java.util.Scanner;

public class MenuAdmin {

    public static void mostrarMenu(String email) {
        Scanner sc = new Scanner(System.in);
        int aukera;

        do {
            System.out.println("=== Admin Menua ===");
            System.out.println("1. Bezeroen erosketak ikusi");
            System.out.println("2. Langileen informazioa ikusi");
            System.out.println("3. Langileen pasahitzak aldatu");
            System.out.println("4. Konponketa erregistroa ikusi");
            System.out.println("5. Bezeroen iritziak irakurri eta kudeatu");
            System.out.println("6. Fitxatu");
            System.out.println("7. Irten");
            System.out.print("Aukeratu: ");

            aukera = sc.nextInt();
            sc.nextLine(); 

            switch (aukera) {
                case 1:
                    break;
                case 2:
                	System.out.println("Zehazki?");
                	int a;
                    do {
                    	System.out.println("1. Informazio orokorra\n2. Fitxaketa taulak\n3. Atera");
                    	a=sc.nextInt();
                    	if(a==1) {
                    	}else if(a==2) {
                    	}else if(a==3) {
                    		System.out.println("Agur");
                    		break;
                    	}else {
                    		System.out.println("Aukera hori ez du existitzen");
                    	}
                    }while(a!=3);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Agur!");
                    break;
                default:
                    System.out.println("Aukera ez da zuzena.");
            }
        } while (aukera != 7);
    }
}