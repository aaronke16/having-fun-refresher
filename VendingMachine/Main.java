package VendingMachine;

public class Main {
    public static void main(String[] args) {
        Snacks snack = new Snacks(5, "Chips", 5);
        Vending vend = new Vending(15);

        vend.vendSnack(snack);
        vend.vendSnack(snack);
        vend.vendSnack(snack);
        vend.vendSnack(snack);
        vend.displayBalance();
        vend.restockSnack(snack, 2);
        vend.vendSnack(snack);
        vend.increaseBalance(5);
        vend.vendSnack(snack);
    }
}
