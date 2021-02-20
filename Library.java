import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Nijel Felder
 * @version 
 *
 */
public class Library {

   
   private HashMap<String,Integer> books=new HashMap<String, Integer>();

   private static Library library;
 
   private Library()
   {
       System.out.println("Creating our Library. Time to begin reading");
   }
   /**
    * Retrieves the library
    * @return instance of the library
    */
   public static Library getInstance()
   {
       if (library == null)
           library = new Library();

       return library;
   }
   /**
    * 
    * @param Retrives the number of copies for each give book
    * @return number of copies for the given book
    */
   public boolean checkoutBook(String bookName)
   {
       
       if(books.containsKey(bookName))
       {
           int count = books.get(bookName);
           if(count>0)
           {
               books.put(bookName, count-1);
               System.out.println(bookName+" was successfully checked out");
               return true;
           }
           else
           {
               System.out.println("Sorry "+bookName+" is not in stock");
           }
       }
       return false;
   }
   /**
    * Retrieves the name of book and number of books to add
    * @param name of the book
    * @param number of books to add
    */
   public void checkInBook(String bookName,int numToAdd)
   {
       
       if(books.containsKey(bookName))
       {
           int count=books.get(bookName);
           books.put(bookName, count+numToAdd);
       }
       else
       {
           books.put(bookName, numToAdd);
       }
       System.out.println(bookName+" was added to the library");
   }
   /**
    * Retrieves the books to display
    * @param Display books
    */
   public void displayBooks()
   {
       System.out.println("Inventory:");
       for (Map.Entry<String, Integer> entry : books.entrySet()) {
           System.out.println("- "+entry.getKey() + ", copies: " + entry.getValue());
       }

   }
}