package javaapplication13;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.lang.IllegalStateException;
import java.lang.SecurityException;
import java.util.InputMismatchException;
import java.util.Formatter;
import java.util.Scanner;
public class Claus_Travis_LB15 {
    private static Scanner input;
    private static Formatter output;
    private static final Scanner cin =
            new Scanner(System.in);
    private static double reportTotal = 0.0; 
    public static void openReadFile(){
        try{
            input = new Scanner(Paths.get(
                    "C:\\Users\\Travis\\Desktop\\Items.txt"));
        }
        catch(IOException ioe){
            System.err.print("Error opening file."
                    + " Exiting.\n\n");
            System.exit(1);
        }
    }
    public static void formatHeader(){
        output.format("%-50s %-15s %-7s %-10s %-10s %n %n",
                "Item Name","Scu Number",
                "Price","Total #","Projected Income");
    }
    public static void openWriteFile(){
        try{
            output = new Formatter(
                    "C:\\Users\\Travis\\Desktop\\Report.txt");
        }
        catch(SecurityException se){
            System.err.print("Permission Denied to write."
                    + " Terminating\n\n");
            System.exit(1);
        }
        catch(FileNotFoundException fnfe){
            System.err.print("Error opening write file."
                    + "Terminating");
            System.exit(1);
        }
        formatHeader();
    }
    public static void closeReadFile(){
        if (input != null)
            input.close();
    }
    public static void closeWriteFile(){
        if(output != null)
            output.close();
    }
    public static void readFile(){
        try{
            while(input.hasNext())
                writeFile(input.nextLine());
        }
        catch(IllegalStateException ise){
            System.err.print("Error reading file."
                    + " Exiting\n\n");
            System.exit(1);
        }
    }
    public static void writeFile(String thisString){
        String stringList[] = thisString.split(",");
        output.format("%-50s %-15s %-7s %-10s %-10f %n",
                stringList[0],stringList[1],stringList[2],
                stringList[3],
                Double.parseDouble(stringList[2])*
                        Integer.parseInt(stringList[3]));
        reportTotal += Double.parseDouble(stringList[2])*
                        Integer.parseInt(stringList[3]);
        if(!input.hasNext())
            output.format("Total: " + reportTotal);
    }
    public static void main(String[] args) {
        int response = 0;
        do{
     System.out.print("1. Open input/output files.\n"
             + "2. Compose Report.txt from items.txt.\n"
             + "3. Close input/output files.\n"
             + "4. Exit\n\n"
             + "Input: ");
     try{
        response = cin.nextInt();
     }
     catch(InputMismatchException ime){
         System.err.print("Invalid Input\n\n");
         cin.nextLine();
     }
     switch(response){
         case 1:
             openReadFile();
             openWriteFile();
             break;
         case 2:
             readFile();
             break;
         case 3:
             closeReadFile();
             closeWriteFile();
             break;
         case 4:
             System.exit(0);
             break;
         default:
             System.err.print("Invalid Input\n\n");
             break;
     }
        }
     while(response != 4);
    }
    
}
