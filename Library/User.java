package Library;
import Library.Books;

public class User {
    private int balance;

    public User(int balance, String name) {
        this.balance = balance;
    }

    public int returnBalance(){
        return balance;
    } 

    public void borrowBook(Books book){
        book.borrowBook();
    }

    public void returnBook(Books book){
        book.returnBook();
    }
}
