public class CreditCard {
    int cardAccount;
    double currentBalance;

    public CreditCard(int cardAccount, double currentBalance) {
        this.cardAccount = cardAccount;
        this.currentBalance = currentBalance;
    }

    public void cardCharge(double amount) {
        currentBalance = currentBalance - amount;
    }

    public void cardTopUp(double amount) {

        currentBalance = currentBalance + amount;
    }

    public void cardCurrentInformation() {
        System.out.println("Номер счета кредитной карты: " + cardAccount + ". Текущий остаток на карте: " + currentBalance + " руб.");
    }
}