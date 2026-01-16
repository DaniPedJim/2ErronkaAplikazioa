package erronka;

import java.util.Scanner;

public class MenuLangileBurua {

    public static void mostrarMenu(String email) {
        Scanner sc = new Scanner(System.in);
        int aukera;

        do {
            System.out.println("=== LangileBurua Menua ===");
            System.out.println("1. Erosketak ikusi edo sartu");
            System.out.println("2. Konponketa erregistroa ikusi");
            System.out.println("3. Ekipoak Erregistratu");
            System.out.println("4. Hornitzaileak kudeatu");
            System.out.println("5. Langileak kudeatu");
            System.out.println("6. Prezioa edo Kantitatea aldatu");
            System.out.println("7. Fitxatu");
            System.out.println("8. Irten");
            System.out.print("Aukeratu: ");

            aukera = sc.nextInt();
            sc.nextLine(); // Buffer garbitu

            switch (aukera) {
                case 1:
                	break;
                case 2:
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
                    break;
                case 8:
                    System.out.println("Agur!");
                    break;
                default:
                    System.out.println("Aukera ez da zuzena.");
            }

        } while (aukera != 8);
    }
}
