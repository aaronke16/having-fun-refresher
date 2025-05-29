package Library;
import java.util.ArrayList;

public class Library {
    private ArrayList<Books> books;

    public Library(ArrayList<Books> books){
        this.books = books;
    }

    public void addBooks(Books book){
        if(books.contains(book)){
            System.out.println(book.getTitle() + " is already in  cart");
        }else{
            books.add(book);
            System.out.println(book.getTitle() + " added to cart");
        }
    }

    public void removeBooks(Books book){
        if(!books.contains(book)){
            System.out.println(book.getTitle() + " is not in cart");
        }else{    
            books.remove(book);
            System.out.println(book.getTitle() + " removed from cart");
        }
    }

    public void listBooks(){
        for(Books listofBooks: books){
            
        }
    }
}
