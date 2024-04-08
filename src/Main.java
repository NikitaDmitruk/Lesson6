import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreditCard firstCard = new CreditCard(1234, 150.25);
        CreditCard secondCard = new CreditCard(5678, 100.11);
        CreditCard thirdCard = new CreditCard(9012, 201.15);
        firstCard.cardCurrentInformation();
        secondCard.cardCurrentInformation();
        thirdCard.cardCurrentInformation();
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите 1 для пополнения денег, 2 для снятия денег: ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите номер карты: ");
                    int number = scanner.nextInt();
                    if (firstCard.cardAccount == number) {
                        System.out.println("Введите сумму:");
                        firstCard.cardTopUp(scanner.nextDouble());
                    } else if (secondCard.cardAccount == number) {
                        System.out.println("Введите сумму:");
                        secondCard.cardTopUp(scanner.nextDouble());
                    } else if (thirdCard.cardAccount == number) {
                        System.out.println("Введите сумму:");
                        thirdCard.cardTopUp(scanner.nextDouble());
                    } else {
                        System.out.println("Такой карты не существует!");
                        return;
                    }
                }
                case 2 -> {
                    System.out.println("Введите номер карты: ");
                    int number = scanner.nextInt();
                    if (firstCard.cardAccount == number) {
                        System.out.println("Введите сумму:");
                        firstCard.cardCharge(scanner.nextDouble());
                    } else if (secondCard.cardAccount == number) {
                        System.out.println("Введите сумму:");
                        secondCard.cardCharge(scanner.nextDouble());
                    } else if (thirdCard.cardAccount == number) {
                        System.out.println("Введите сумму:");
                        thirdCard.cardCharge(scanner.nextDouble());
                    } else {
                        System.out.println("Такой карты не существует!");
                        return;
                    }
                }
                default -> {
                    System.out.println("Вы ввели не то число!");
                    return;
                }
            }
        }
        firstCard.cardCurrentInformation();
        secondCard.cardCurrentInformation();
        thirdCard.cardCurrentInformation();
    }
}




