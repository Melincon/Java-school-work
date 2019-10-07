package claus_travis_lb8;
import java.util.ArrayList;
import java.util.Scanner;
public class Claus_Travis_LB8 {
    private final static int rS = 3;       //Travis Claus
    private final static int cS = 6;       //Java Programming
    private final static Scanner kInput =  //2/4/2016
            new Scanner(System.in);
    public static void menu(){
        System.out.print("1. Ascending sort by KW.\n" +
        "2. Ascending sort by CFF.\n" +
                "3. Exit\n\nInput: ");
    }
    public static void kwSwap(double array[][],int first, int second){
        for(int c = 0; c < 3; c++) {
        double temp = array[first][c];
        array[first][c] = array[second][c];
        array[second][c] = temp;
        }        
    }
    public static void cffSwap(double array[][],int first, int second){
        for(int c = 0; c < 3; c++) {
        double temp = array[first][c];
        array[first][c] = array[second][c];
        array[second][c] = temp;
        }
    }
    public static void printArray(double[][] array){
        for(int c = 0; c < cS; c++){
            for(int r = 0; r < rS; r++)
                System.out.print(array[c][r] + "   ");
                System.out.println();}
                System.out.print("\n");        
    }
    public static double total(double[][] array, int c){
        double total = 0;
        for(int i = 0;i < cS; i++)
            total += array[i][c];
        return total;
    }
    public static double average(double total){
        return (total/cS);
    }
    public static void printSummary(double[][] array){
        System.out.print("Summary:" +
                "\nElectricity total for " + cS + " years: " +
        total(array,1) + 
                "\nAvg for " + cS + " years: " + 
                average(total(array,1)) +
        "\n\nNatural Gas total for " + cS + " years: " +
                total(array,2) +
        "\nAvg for " + cS + " years: " +
                average(total(array,2)));
    }
    public static void kwSort(double[][] array){
        for(int c = 0;c < cS; c++){
            int smallest = c;
            for(int i = c;i < cS;i++)
                if(array[i][1] < array[smallest][1])
                    smallest = i;
            kwSwap(array, c, smallest);
        }            
    }
    public static void cffSort(double[][] array){
        for(int c = 0;c < cS; c++){
            int smallest = c;
            for(int i = c;i < cS;i++)
                if(array[i][2] < array[smallest][2])
                    smallest = i;
            cffSwap(array, c, smallest);    
        }
    }
    public static void main(String[] args) {
        int flag = 3;
        double[][] list = {{2010,3174.07,839.85,},
                {2011,1933.62,840.57},
                {2012,5133.25,668.13},
                {2013,8115.95,1312.63},
                {2014,10665.44,1621.49},
                {2015,10886.72,708.46}};
        System.out.print("The original array: \n\n");
        printArray(list);
                do {
                    menu();
                    flag = kInput.nextInt();
                    System.out.print("\n\n");
                    switch(flag){
                        case 1: 
                            kwSort(list);
                            printArray(list);
                            printSummary(list);
                            break;
                        case 2:
                            cffSort(list);
                            printArray(list);
                            printSummary(list);
                            break;
                        case 3:
                            System.exit(1);
                            break;
                        default:
                            System.out.print("Input invalid, "
                                    + "please try again.\n\n");
                            break;  
                    }
                }while(flag != 3);
                }
}