package org.example;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        birthday_repository REPO = new birthday_repository();
        Scanner SC = new Scanner(System.in);
        boolean LEAVE = false;

        while (!LEAVE) {

            System.out.println(Agenda());
            System.out.println(List());
            System.out.println(Find_by_day());
            System.out.println(Find_by_name());
            System.out.println(Add());
            System.out.println(Delete());
            System.out.println(Leave());
            System.out.print(Option());

            String option = SC.nextLine();

            switch (option) {

                case "1":
                    Switch_case1(REPO);
                    break;

                case "2":
                    Switch_case2(SC, REPO);
                    break;

                case "3":
                    Switch_case3(SC, REPO);
                    break;

                case "4":
                    Switch_case4(SC, REPO);
                    break;

                case "5":
                    Switch_case5(SC, REPO);
                    break;

                case "6":
                    LEAVE = isLeave();
                    break;
            }
        }
    }

    private static boolean isLeave() {
        boolean LEAVE;
        LEAVE = true;
        return LEAVE;
    }

    private static void Switch_case5(Scanner SC, birthday_repository REPO) {
        System.out.print(Name_delete());
        String NAME_DELETE = SC.nextLine();
        REPO.DeleteByName(NAME_DELETE);
    }

    private static void Switch_case4(Scanner SC, birthday_repository REPO) {
        System.out.print(Name());
        String NAME = SC.nextLine();
        System.out.print(Day());
        int D = Integer.parseInt(SC.nextLine());
        System.out.print(Month());
        int M = Integer.parseInt(SC.nextLine());

        REPO.AddCumple(new birthday_agenda(NAME, D, M));
    }

    private static void Switch_case3(Scanner SC, birthday_repository REPO) {
        System.out.print(Name());
        String NAME_FIND = SC.nextLine();
        birthday_agenda found = REPO.FindByNmae(NAME_FIND);

        if (found == null) {
            System.out.println(Not_found());
        } else {
            System.out.println(found.GetName() + ": " +
                    found.GetDay() + "/" + found.GetMonth());
        }
    }

    private static void Switch_case2(Scanner SC, birthday_repository REPO) {
        System.out.print(Day());
        int DAY = Integer.parseInt(SC.nextLine());
        List<birthday_agenda> byDay = REPO.FindByDay(DAY);

        if (byDay.isEmpty()) {
            System.out.println(Without_results());
        } else {
            for (birthday_agenda c : byDay) {
                System.out.println(c.GetName() + ": " + c.GetDay() + "/" + c.GetMonth());
            }
        }
    }

    private static void Switch_case1(birthday_repository REPO) {
        List<birthday_agenda> list = REPO.GetList();
        if (list.isEmpty()) {
            System.out.println(Empty());
        } else {
            for (birthday_agenda c : list) {
                System.out.println(c.GetName() + ": " + c.GetDay() + "/" + c.GetMonth());
            }
        }
    }

    private static String Name_delete() {
        return "Nombre a eliminar: ";
    }

    private static String Month() {
        return "Mes: ";
    }

    private static String Not_found() {
        return "No found.";
    }

    private static String Name() {
        return "Nombre: ";
    }

    private static String Without_results() {
        return "Sin resultados.";
    }

    private static String Day() {
        return "Día: ";
    }

    private static String Empty() {
        return "Vacío.";
    }

    private static String Option() {
        return "Opción: ";
    }

    private static String Leave() {
        return "6. Salir";
    }

    private static String Delete() {
        return "5. Eliminar";
    }

    private static String Add() {
        return "4. Añadir";
    }

    private static String Find_by_name() {
        return "3. Buscar por nombre";
    }

    private static String Find_by_day() {
        return "2. Buscar por día";
    }

    private static String List() {
        return "1. Listar";
    }

    private static String Agenda() {
        return "\n=== AGENDA ===";
    }
}
