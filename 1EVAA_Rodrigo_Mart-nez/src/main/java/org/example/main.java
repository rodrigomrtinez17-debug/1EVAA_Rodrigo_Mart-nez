package org.example;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        birthday_repository REPO = new birthday_repository();
        Scanner SC = new Scanner(System.in);
        boolean LEAVE = false;

        while (!LEAVE) {

            System.out.println("\n=== AGENDA ===");
            System.out.println("1. Listar");
            System.out.println("2. Buscar por día");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Añadir");
            System.out.println("5. Eliminar");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            String option = SC.nextLine();

            switch (option) {

                case "1":
                    List<birthday_agenda> list = REPO.GetList();
                    if (list.isEmpty()) {
                        System.out.println("Vacío.");
                    } else {
                        for (birthday_agenda c : list) {
                            System.out.println(c.GetName() + ": " + c.GetDay() + "/" + c.GetMonth());
                        }
                    }
                    break;

                case "2":
                    System.out.print("Día: ");
                    int DAY = Integer.parseInt(SC.nextLine());
                    List<birthday_agenda> byDay = REPO.FindByDay(DAY);

                    if (byDay.isEmpty()) {
                        System.out.println("Sin resultados.");
                    } else {
                        for (birthday_agenda c : byDay) {
                            System.out.println(c.GetName() + ": " + c.GetDay() + "/" + c.GetMonth());
                        }
                    }
                    break;

                case "3":
                    System.out.print("Nombre: ");
                    String NAME_FIND = SC.nextLine();
                    birthday_agenda found = REPO.FindByNmae(NAME_FIND);

                    if (found == null) {
                        System.out.println("No found.");
                    } else {
                        System.out.println(found.GetName() + ": " +
                                found.GetDay() + "/" + found.GetMonth());
                    }
                    break;

                case "4":
                    System.out.print("Nombre: ");
                    String NAME = SC.nextLine();
                    System.out.print("Día: ");
                    int D = Integer.parseInt(SC.nextLine());
                    System.out.print("Mes: ");
                    int M = Integer.parseInt(SC.nextLine());

                    REPO.AddCumple(new birthday_agenda(NAME, D, M));
                    break;

                case "5":
                    System.out.print("Nombre a eliminar: ");
                    String NAME_DELETE = SC.nextLine();
                    REPO.DeleteByName(NAME_DELETE);
                    break;

                case "6":
                    LEAVE = true;
                    break;
            }
        }
    }
}
