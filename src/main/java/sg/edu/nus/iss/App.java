package sg.edu.nus.iss;

import java.util.Scanner;
import java.util.ArrayList;

public class App 
{
    //list method
    public static void list(ArrayList<String> shoppingCart){
        if(shoppingCart.size() == 0){
            System.out.println("Your cart is empty");
        }
        for (int i = 0; i< shoppingCart.size(); i++) {
            System.out.println((i+1) + ". " + shoppingCart.get(i));
        }
    }
    //add method
    public static void add(String[] args, ArrayList<String> shoppingCart) {
        for (String item:args) {
            if(shoppingCart.contains(item.trim().toLowerCase())){
                System.out.println("You have " + item.trim().toLowerCase() + " in your cart");
                break;
            }
            shoppingCart.add(item.trim().toLowerCase());
            System.out.println(item.trim().toLowerCase() + " added to cart");
        }
    }
    //delete method
    public static void delete(Integer index, ArrayList<String> shoppingCart) {
        if(index >=0 && index < shoppingCart.size()){
            System.out.println(shoppingCart.get(index) + " removed from cart");
            shoppingCart.remove(shoppingCart.get(index));
        } else {
            System.out.println("Incorrect item index");
        }
    }

    public static Boolean isNumeric(String string){
        if(string == null){
            return false;
        }

        try {
            int i = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main( String[] args )
    {
        ArrayList<String> shoppingCart = new ArrayList<String>();
        System.out.println("Welcome to your shopping cart");
        System.out.println("Type 'help to show a list of commands");
        String command = "";
        String input = "";
        
        //loop until user quits app
        while (!command.equals("quit")) {
            Scanner scan = new Scanner(System.in);
            command = scan.next();
            input = scan.nextLine();
            switch(command) {
                case "help":
                    System.out.println("'list' to show a list of items in the shopping cart");
                    System.out.println("'add' <item name>, <item name>...");
                    System.out.println("'delete' <item number>");
                    System.out.println("'quit' to exit the program");
                case "list":
                    list(shoppingCart);
                    break;
                case "add":
                    //replace commas with whitespace
                    input = input.replace(",", " ");
                    String[] addItems = input.split(" ");
                    add(addItems, shoppingCart);
                    break;
                case "delete":
                    if(isNumeric(input)){
                        Integer delItemIndex = Integer.parseInt(input.trim())-1;
                        delete(delItemIndex, shoppingCart);
                    }
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Please enter list, add, delete, quit or help");
                    break;
            }
        }

        /*Alternative method using console
         * Console con = System.console();
         * String input = "";
         * 
         * while(!input.equals("quit")){
         *  input = con.readLine("Type 'help to show list of commands >>");
         * 
         *  if(input.equals("help")){
         *      do something
         *  }
         *  
         *  if(input.startsWith("add")){
         *      input = input.replace(","," ");
         *      Scanner scan = new Scanner(input.substring(beginIndex:4));
         *      
         *      
         *      String content = "";
         *      while(scan.hasNext()){
         *          content = scan.next();
         *  
         *          cartItems.add(content);
         *      }
         *  }
         * 
         *  if(input.equals("list")){
         *      int i = 0;
         *      for(String item: cartItems) {
         *          i++;
         *          System.out.println(i + ". " + item);
         *      }
         *  }
         *  
         *  if(input.startsWith("delete")){
         *      Scanner scan = new Scanner(input.substring(6));
         * 
         *      String content = "";
         *      while(scan.hasNext()){
         *          content = scan.next();
         *          int listIndex = Integer.parseInt(content);
         * 
         *          if(listIndex < cartItems.size()){
         *              cartItems.remove(listIndex);
         *          } else {
         *              System.err.println("Incorrect item index");
         *          }
         *      }
         *  }
         * }
         */


    }
}
