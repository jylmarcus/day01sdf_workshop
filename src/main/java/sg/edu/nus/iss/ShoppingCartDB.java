package sg.edu.nus.iss;

import java.io.*;
import java.util.ArrayList;

public class ShoppingCartDB {
    private String dirPath;
    private File directory;

    public ShoppingCartDB() {

    }

    public ShoppingCartDB(String dirPath) {
        this.dirPath = dirPath;
        this.directory = new File(dirPath);
        //create directory if it does not exist upon initialization
        if (!directory.exists()) {
            directory.mkdir();
        } else {
            System.out.println("Directory already exists");
        }
    }

    private String mkFilePath(String fileName) {
        return new String(dirPath + File.separator + fileName);
    }

    public void writeFile(String fileName, ArrayList<String> shoppingCart) throws IOException {
        FileWriter fw = new FileWriter(new File(mkFilePath(fileName)));
        for(String cartItem: shoppingCart) {
            fw.append(cartItem);
            fw.append("\n");
        }
        fw.flush();
        fw.close();
    }

    public ArrayList<String> login(String fileName) throws IOException {
        String user = mkFilePath(fileName);
        File userfile = new File(user);
        // if filename exist

        if (userfile.exists()) {
            // read file
            // output to and return shopping cart array list

            BufferedReader br = new BufferedReader(new FileReader(user));
            String line;
            ArrayList<String> loadCart = new ArrayList<>();

            while((line = br.readLine()) != null) {
                loadCart.add(line);
            }

            br.close();
            return loadCart;
        } else {
            userfile.createNewFile();
            return new ArrayList<String>();
            // create file with filename
            // return empty shoppingcart but do not assign it using if else statement
        }
        // also need a variable to store current fileName somewhere for later use
    }

    public void save(String fileName, ArrayList<String> shoppingCart) throws IOException {

        if(fileName == "") {
            System.out.println("Please login before saving.");
        } else {
            writeFile(fileName, shoppingCart);
        }
        
    }

    public void users() {
        // use listfiles method on dirpath File
        File[] users = directory.listFiles();
        // use for loop with index due to formatting to print list of users
        if(users.length > 0){
            for(int i = 0; i < users.length; i++) {
                System.out.println((i+1) + ". " + users[i].getName());
            }
        } else {
            System.out.println("There are no users!");
        }
    }

}
