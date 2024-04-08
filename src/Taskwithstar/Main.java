package Taskwithstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        Atm Atm = new Atm(2, 0, 0);
        Atm.AddCash();
        System.out.println("Введите сумму, которую хотите снять: ");
        success = Atm.Withdrawn(scanner.nextInt());
        if (success == false) {
            System.out.println("Выдать сумму имеющимеся купюрами невозможно!");
        }
    }
}



