package claus_travis_hw15;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Travis Claus
 */
public class Claus_Travis_HW15 {
    private static ObjectInputStream input;
    private static ObjectOutputStream oOutput;
    private static Formatter output;
    private static final Scanner cin =
            new Scanner(System.in);
    public static void openReadFile(){
        try{
            input = new ObjectInputStream(
            Files.newInputStream(Paths.get(
            "C:\\Users\\Travis\\Desktop\\Inventory.dat")));
        }
        catch(IOException ioe){
            System.err.println("Error opening file."
                    + "Exiting.");
            System.exit(1);
        }
    }
    public static void openWriteFile(){
        try{
            output = new Formatter(
            "C:\\Users\\Travis\\Desktop\\Report.txt");
        }
        catch(SecurityException se){
            System.err.println("Permission denied to write."
                    + " Terminating");
            System.exit(1);
        }
        catch(FileNotFoundException fnfe){
            System.err.println("Error opening write file."
                    + "Terminating");
            System.exit(1);
        }
    }
    public static void closeReadFile(){
        try{
            if(input != null)
            input.close();
        }
        catch(IOException ioe){
            System.err.println("Error opening file."
                    + "Exiting.");
            System.exit(1);
        }
    }
    public static void closeWriteFile(){
        if(output !=null)
            output.close();
    }
    public static void readData(){
        try{
            output.format("%-13s%-50s%-15s%-7s%n%n",
                    "ItemNo","Item","Expiration","Good-For");
            while(true){
                item product;
                product = (item) input.readObject();
                writeReport(product);
            }
        }
        catch(EOFException eofe){
            System.out.print("No more data");
        }
        catch(ClassNotFoundException cnfe){
            System.err.println("Invalid object type. "
                    + "Termitting.");
        }
        catch(IOException ioe){
            System.err.println("Error reading from file. "
                    + "Termitting.");
        }
    }
    public static void writeReport(item product){
        output.format(product.toString());
    }
    private static void serializeData()
    {
        item items[] = new item[10];
        items[0] =  new item("Albacore Solid White In Water Tuna, 12 oz","9297681",3.93,250,2,12,2017);
        items[1] =  new item("Uncle Ben's Original Brown Rice, 2 lb","10420927",3.65,1500,12,21,2020);
        items[2] =  new item("Quaker Oats Old Fashioned Oats, 42 oz","9268013",3.98,103,6,3,2018);
        items[3] =  new item("Thai Red Curry Paste, 4 oz","550487758",2.53,70,8,1,2017);
        items[4] =  new item("Kraft Macaroni & Cheese","009237204",4.5,781,3,14,2018);
        items[5] =  new item("Hormel Beef Pot Roast Bowls, 10 oz","009293209",2.28,84,11,23,2016);
        items[6] =  new item("Kraft Velveeta Shells & Cheese, 12 oz","551273036",6.05,57,7,27,2017);
        items[7] =  new item("Thai Pad Rice Noodle Cart, 9.77 oz","550487760",2.48,97,4,28,2019);
        items[8] =  new item("Great Value Beef Stew, 20 oz","550369454",2.00,264,10,15,2016);
        items[9] =  new item("Great Value Mashed Potatoes, 26.7 oz","550892494",2.68,191,11,17,2019);
        
        try
        {
            oOutput = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get(
                            "C:\\Users\\Travis\\Desktop\\Inventory.dat")));
            for(item tempItem : items)
            oOutput.writeObject(tempItem);  
        }
        catch(IOException ioe)
        {
            System.out.println("Unable to open binary file for writing an object");
        }
        finally
        {
            try
            {
            if(oOutput != null)
                oOutput.close();
            }
            catch(IOException ioe)
            {
                System.out.println(
                        "Can't close the outputStream");
            }
        }
    }
    public static void main(String[] args) {
        int response = 0;
        do{
        System.out.print("1. Open Files\n"
                + "2. Read Files\n"
                + "3. Close Files\n"
                + "4. Exit\n\n"
                + "Input: ");
        try{
            response = cin.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("Invalid Input");
         cin.nextLine();
        }
        switch(response){
         case 1:
             serializeData();
             openReadFile();
             openWriteFile();
             break;
         case 2:
             readData();
             break;
         case 3:
             closeReadFile();
             closeWriteFile();
             break;
         case 4:
             System.exit(0);
             break;
         default:
             System.err.println("Invalid Input");
             break;
     }
        }
     while(response != 4);
    }
        
}
