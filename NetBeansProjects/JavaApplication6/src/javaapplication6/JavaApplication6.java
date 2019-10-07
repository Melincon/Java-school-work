package javaapplication6;
import java.util.Scanner;
public class JavaApplication6 {

    private static void displayArray(int[] year,
            double[] kilo, double[] therm, int size)
    {
        System.out.println("Year" + "     KW        "
                + "  CFF");
        for(int i = 0; i < size; i++)
            System.out.println(year[i]+" - "+kilo[i] + 
                    "     " + therm[i]);
    }

    private static void displayMenu()
    {
        System.out.println("1. Ascending - KW");
        System.out.println("2. Ascending - CFF");
        System.out.println("3. Exit");
    }
    
    public static void main(String[] args) {
       Scanner keyboardIn = new Scanner(System.in);
       final int size = 6;
       int response = 0;
       int[] yearArray = {2010,2011,2012,2013,
       2014,2015};
       double[] kwArray = {3174.07,1933.62,5133.25,
       8115.95,10665.44,10886.72};
       double[] cffArray = {839.85,840.57,668.13,
           1312.63,1621.49,708.46};
       
       displayArray(yearArray,kwArray,cffArray,size);
       System.out.println();
       response = keyboardIn.nextInt();
       do
       {
           displayMenu();
           System.out.print("Please male a "
                   + "selection: ");
           switch(response)
           {
               case 1:
                   break;
               case 2:
                   break;
           }
       }while(response != 3);
    }
}