package Taskwithstar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Atm atm = new Atm(0, 0, 0);
        atm.AddCash();
        System.out.println("Первый способ. Введите сумму, которую хотите снять: ");
        boolean success = atm.withdrawn(scanner.nextInt()); // Находит вариант выдачи купюр наименьшим количеством
        if (!success) {
            System.out.println("Выдать сумму имеющимеся купюрами невозможно!");
        }
        System.out.println("\nВторой способ. Введите сумму, которую хотите снять: ");
        success = atm.withdrawnAll(scanner.nextInt());
        if (!success) {
            System.out.println("Выдать сумму имеющимеся купюрами невозможно!");
        }
    }
}



