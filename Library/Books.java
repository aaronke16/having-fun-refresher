package Library;

// a book has an author, title, price, 
public class Books{
    private String author;
    private int price;
    private String title;
    private boolean isBorrowed = false;

    public Books(String author, String title, int price, boolean isBorrowed){
        this.author = author;
        this.title = title;
        this.price = price;
        this.isBorrowed = isBorrowed;
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }

    public int getPrice(){
        return price;
    }

    public boolean isBorrowed(){
        return isBorrowed;
    }

    public void borrowBook(int balance){
        if(!isBorrowed){
            isBorrowed = true;
            System.out.println("You've borrowed the book!");
        }else{
            System.out.println("Book is currently being borrowed");
        }
    }

    public void returnBook(){
        if(isBorrowed){
            isBorrowed = false;
            System.out.println("Thank you for returning the book!");
        }else{
            System.out.println("No book available to return");
        }
    }
    
}