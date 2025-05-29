package VendingMachine;

public class Snacks {
    private int price;
    private String name;
    private int stock;

    public Snacks(int price, String name, int stock){
        this.price = price;
        this.name = name;
        this.stock = stock;
    }

    public int getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public boolean isAvailable(){
        return stock > 0;
    }

    public int getStock(){
        return stock;
    }

    public void decreaseStock(){
        if(stock > 0){
            stock-=1;
        }else{
            System.out.println("Item out of stock");
        }
    }

    public void restock(int amount){
        stock += amount;
        System.out.println(name + " restocked, current inventory is, " + stock);
    }
}

