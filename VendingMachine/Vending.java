package VendingMachine;

public class Vending {
    private int balance;

    public Vending(int balance){
        this.balance = balance;
    }

    public void displayBalance(){
        System.out.println("Balance $" + balance);
    }

    public void increaseBalance(int amount){
        balance += amount;
        System.out.println("Balance increased to " + amount);
    }

    public void vendSnack(Snacks snack){
        if(!snack.isAvailable()){
            System.out.println("Snack is out of stock!");
            return;
        }

        if(balance < snack.getPrice()){
            System.out.println("Balance is too low!");
            return;
        }

        balance -= snack.getPrice();
        snack.decreaseStock();

        System.out.println("Dispensing " + snack);
        System.out.println("Remaining balance $" + balance);
    }

    public void restockSnack(Snacks snack, int amount){
        snack.restock(amount);

        System.out.println(snack + " restocked to " + snack.getStock());
    }
}
