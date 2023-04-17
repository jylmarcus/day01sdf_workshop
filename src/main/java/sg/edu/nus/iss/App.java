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

    public static void main( String[] args )
    {
        ArrayList<String> shoppingCart = new ArrayList<String>();
        System.out.println("Welcome to your shopping cart");
        String command = "";
        String input = "";
        
        //loop until user quits app
        while (!command.equals("quit")) {
            Scanner scan = new Scanner(System.in);
            command = scan.next();
            input = scan.nextLine();
            switch(command) {
                case "list":
                    list(shoppingCart);
                    break;
                case "add":
                    String[] addItems = input.split(",");
                    add(addItems, shoppingCart);
                    break;
                case "delete":
                    Integer delItemIndex = Integer.parseInt(input.trim())-1;
                    delete(delItemIndex, shoppingCart);
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Please enter list, add, delete or quit");
                    break;
            }
        }


    }
}
