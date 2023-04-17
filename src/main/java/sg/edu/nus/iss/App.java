package sg.edu.nus.iss;

import java.io.console;
import java.util.ArrayList;

public class App 
{
    //list method
    public static void list(ArrayList<String> shoppingCart){
        for (int i = 0; i< shoppingCart.length(); i++) {
            System.out.println((i+1) + ". " + shoppingCart.get(i));
        }
    }
    //add method
    public static void add(String[] args) {
        for (String item:args) {
            if(shoppingCart.contains(item.trim().toLowerCase())){
                System.out.println("You have " + item.trim().toLowerCase() " in your cart");
                break;
            }
            shoppingCart.add(item.trim().toLowerCase());
            System.out.println(item.trim().toLowerCase() + " added to cart");
        }
    }
    //delete method
    public static void delete(Integer[] args) {
        if(shoppingCart.contains(args[0])){
            System.out.println(shoppingCart.get(args[0]) " removed from cart");
        }
        if(shoppingCart.remove(args[0])){
            shoppingCart.remove(args[0]);
        } else {
            System.out.println("Incorrect item index");
        }
    }

    public static void main( String[] args )
    {
        Boolean runCart = true;
        ArrayList<String> shoppingCart = new ArrayList<String>();
        Console cons = System.console();
        System.out.println("Welcome to your shopping cart");
        String command = ""
        String input = ""

        while (runCart) {
            input = cons.readLine();
            command = input.split("\\s+")[0];
            switch
        }


    }
}
