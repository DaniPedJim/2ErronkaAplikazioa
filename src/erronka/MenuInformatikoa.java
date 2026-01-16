package erronka;

import java.util.Scanner;

public class MenuInformatikoa {

    public static void erakutsiMenua(String email) {
        Scanner sc = new Scanner(System.in);
        int aukera;

        do {
            System.out.println("=== LANGILEAREN MENUA ===");
            System.out.println("1. Produktuak ikusi");
            System.out.println("2. Konponketa erregistroa");
            System.out.println("3. Ekipo berriak erregistratu");
            System.out.println("4. Fitxatu");
            System.out.println("5. Irten");
            System.out.print("Aukeratu zenbakia: ");

            while (!sc.hasNextInt()) {
                System.out.println("Mesedez, zenbaki bat sartu (1-6).");
                sc.nextLine();
            }

            aukera = sc.nextInt();
            sc.nextLine(); // buffer garbitu

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
                    System.out.println("Agur! Programa ixten...");
                    break;

                default:
                    System.out.println("Aukera ez da zuzena. Saiatu berriro (1-6).");
            }

            System.out.println(); 

        } while (aukera != 6);
    }
}
