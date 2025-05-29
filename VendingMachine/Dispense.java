package VendingMachine;

public class Dispense {
    private int balance;
    private boolean isDispensed;

    public Dispense(int balance, boolean isDispensed){
        this.balance = balance;
        this.isDispensed = isDispensed;
    }

    public int getBalance(){
        return balance;
    }

    public boolean isDispensed(){
        return isDispensed;
    }
}
