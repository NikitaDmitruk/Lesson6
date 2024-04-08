package Taskwithstar;

import java.util.Scanner;

public class Atm {
    int[] twentyBanknote = {20, 0};
    int[] fiftyBanknote = {50, 0};
    int[] hundredBanknote = {100, 0};


    public Atm(int numbersOfTwenty, int numbersOfFifty, int numbersOfHundred) {
        twentyBanknote[1] = numbersOfTwenty;
        fiftyBanknote[1] = numbersOfFifty;
        hundredBanknote[1] = numbersOfHundred;
    }

    public void AddCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Поочередно введите количество купюр номиналом 20, 50, 100 которые хотите добавить в банкомат: ");
        twentyBanknote[1] = twentyBanknote[1] + scanner.nextInt();
        fiftyBanknote[1] = fiftyBanknote[1] + scanner.nextInt();
        hundredBanknote[1] = hundredBanknote[1] + scanner.nextInt();
        System.out.println("Количество купюр номиналом 20 = " + twentyBanknote[1] + " ; номиналом 50 = " + fiftyBanknote[1] + " ; номиналом 100 = " + hundredBanknote[1]);
    }

    public boolean withdrawn(int amount) { //В общем тут написана попытка реализовать алгоритм динамического программирования, но не совсем получилось
        int n = fiftyBanknote[1] + twentyBanknote[1] + hundredBanknote[1];
        int[] arrForBanknotes = new int[n]; // Массив для банкнот
        int[][] sums = new int[999999][2]; //Массив для возможных вариантов сумм и последних купюр, с помощью которой эта сумма получилась. Тут косяк, т.к. размера может не хватить
        int sizeSums = 1; //Переменная для определения количества заполненных элементов в массиве сумм
        int writesCounter = 1; //Переменная для подсчета записей внутри цикла, чтобы определить насколько нужно увеличить переменную sizeSums
        int addArrElement = 0; //Переменная для определения места записи новой суммы в массиве sums
        boolean sumsDuplicate = false; //Переменная для определения уже и имеющейся суммы в массиве sums
        int sum; //Переменная для хранения новой суммы
        //Эти циклы создают массив банкнот с убыванием по номиналу
        for (int i = 0; i < hundredBanknote[1]; i++) {
            arrForBanknotes[i] = hundredBanknote[0];
        }
        for (int i = 0; i < fiftyBanknote[1]; i++) {
            arrForBanknotes[i + hundredBanknote[1]] = fiftyBanknote[0];
        }
        for (int i = 0; i < twentyBanknote[1]; i++) {
            arrForBanknotes[i + hundredBanknote[1] + fiftyBanknote[1]] = twentyBanknote[0];
        }
        //Тут определяются варианты сумм и возможность выдать необходимую сумму определенными купюрами
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sizeSums; j++) {
                sum = sums[j][0] + arrForBanknotes[i];
                //Здесь определяем повторы сумм
                for (int l = 0; l < sizeSums; l++) {
                    if (sum == sums[l][0]) {
                        sumsDuplicate = true;
                        break;
                    }
                }
                // Здесь определяем куда записать новую сумму (сли она не повторялась и если она меньше необходимо и номинал банкноты, с помощью которой эта сумма получилась.
                if (!sumsDuplicate && sum <= amount) {
                    sums[sizeSums + addArrElement][0] = sum;
                    sums[sizeSums + addArrElement][1] = arrForBanknotes[i];
                    writesCounter = writesCounter + 1;
                    addArrElement++;
                }
                sumsDuplicate = false; //Обнуляем для новой проверки одинаковой суммы
                //Здесь проверяем совпадение имеющейся суммы с необходимой, если оно есть, то выводим результат и возвращаем булевое значение true
                if (sum == amount) {
                    System.out.println("Заберите деньги такими купюрами: ");
                    System.out.print(arrForBanknotes[i] + " ");
                    amount = amount - arrForBanknotes[i];
                    for (int l = 0; amount != 0; l++) {
                        if (amount == sums[l][0]) {
                            System.out.print(sums[l][1] + " ");
                            amount = amount - sums[l][1];
                            l = 0;
                        }
                    }
                    return true;
                }
            }
            sizeSums = writesCounter;// Здесь определяем сколько элементов записано в массив sums, чтобы определить количество циклов
            addArrElement = 0; //Обнуляем для нового подсчета добавленных элементов
        }
        return false; //Возвращаем если мы не нашли необходимого варианты суммы
    }
}
