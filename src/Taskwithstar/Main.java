package Taskwithstar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Atm Atm = new Atm(0, 0, 0);
        Atm.AddCash();
        System.out.println("Введите сумму, которую хотите снять: ");
        boolean success = Atm.Withdrawn(scanner.nextInt());
        if (!success) {
            System.out.println("Выдать сумму имеющимеся купюрами невозможно!");
        }
    }
}



