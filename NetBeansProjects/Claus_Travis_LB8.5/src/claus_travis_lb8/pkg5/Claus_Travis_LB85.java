package claus_travis_lb8.pkg5;
import java.util.Scanner;
public class Claus_Travis_LB85 {
    private static final double tax = 1.0525;
    private static final Scanner keyboardIn =
            new Scanner(System.in);
    public static void displayMenu(){
     System.out.print("\n1. Check-in\n" +
            "2. Check-out\n" +
                    "3. Report\n" +
                    "4. Exit\n\n" +
             "Input: ");
    }
    public static void printAvail(room[] roomArray){
                System.out.println("Availability:");
        for(int i = 0; i < 3; i++)
            System.out.print("Room " + (i+1) + ": " +
                    roomArray[i].
                            getRoomNumber() + " " +
                            roomArray[i].
                                    isAvailable() +
                            "\n");
        System.out.print("4. Exit\n\n");
    }
    public static date buildDate(){
        int month = 0;
        int day = 0;
        int year = 0;
        System.out.print("\nMonth: ");
        month = keyboardIn.nextInt();
        System.out.print("\nDay: ");
        day = keyboardIn.nextInt();
        System.out.print("\nYear: ");
        year = keyboardIn.nextInt();
        date thisDate = new date(month,day,year);
        return thisDate;
    }
    public static customer buildCustomer(){
        date birthDate;
        date inDate;
        date outDate;
        String fName;
        String lName;
        int guestCount = 0;
        System.out.print("First name: ");
        fName = keyboardIn.next();
        System.out.print("Last Name: ");
        lName = keyboardIn.next();
        System.out.print("Birth Date: ");
        birthDate = buildDate();
        System.out.print("In Date: ");
        inDate = buildDate();
        System.out.print("Out Date: ");
        outDate = buildDate();
        System.out.print("Guest Count: ");
        guestCount = keyboardIn.nextInt();
        customer thisCustomer = new customer(fName,lName,
        birthDate,inDate,new date(),guestCount,
                0.0);
        return thisCustomer;
    }
    public static void hourlyPay(customer thisCustomer,
            room thisRoom) {
        int hours = 0;
        double total = 0.0;
        System.out.print("\nTotal Hours spent: ");
        hours = keyboardIn.nextInt();
        if(hours <= 3)
            total = thisRoom.getRate()*tax;
        else total = tax*(thisRoom.getRate()+(15*(hours - 3)));
        System.out.print("\nAmount Due: $" + total);
        thisCustomer.setPricePaid(total);
        thisRoom.setRevenue(thisRoom.getRevenue() + total);
    }
    public static void dailyPay(customer thisCustomer,
            room thisRoom){
        int days = 0;
        double total = 0.00;
        System.out.print("\nTotal days spent: ");
        days = keyboardIn.nextInt();
        if(thisCustomer.getGuestCount() <= 1)
            total = tax*(days*thisRoom.getRate());
        else 
            total = tax*(days*(thisRoom.getRate()+(20*
                    (thisCustomer.getGuestCount()-1))));
        System.out.print("\nAmount Due: $" + total);
        thisCustomer.setPricePaid(total);
        thisRoom.setRevenue(thisRoom.getRevenue() + total);
    }
    public static void checkIn(room[] roomArray){
        int response = 0;
        int rate = 0;
        int rateResponse = 0;
        do{
            System.out.print("\n1. Daily Rates\n-or-\n"
                + "2.Hourly Rates\nInput: ");
        rateResponse = keyboardIn.nextInt();
            switch(rateResponse){
                case 1: 
                    rate = 115;
                    break;
                case 2:
                    rate = 65;
                    break;
                default:
                    System.out.print("\nInvalid Input");
                    break;
            }
        }while(rate == 0);
        double amountDue = 0.0;
        customer thisCustomer = buildCustomer();
        printAvail(roomArray);
        System.out.print("\nPlease choose an " +
                "available room, or exit.\n\nInput: ");
        response = keyboardIn.nextInt();
                switch(response){
                case 1:
                    roomArray[0] = new room(111,3,"Full",
                            false,3,rate,thisCustomer,
                            false,roomArray[0].getRevenue());
                    if(rateResponse == 2)
                        hourlyPay(thisCustomer,roomArray[0]);
                    else dailyPay(thisCustomer,roomArray[0]);
                    break;
                case 2:
                    roomArray[1] = new room(222,2,"Queen",
                            false,4,rate,thisCustomer,
                            false,roomArray[1].getRevenue());
                    if(rateResponse == 2)
                        hourlyPay(thisCustomer,roomArray[1]);
                    else dailyPay(thisCustomer,roomArray[1]);
                    break;
                case 3:
                    roomArray[2] = new room(333,1,"King",
                            true,1,rate,thisCustomer,
                            false,roomArray[2].getRevenue());
                    if(rateResponse == 2)
                        hourlyPay(thisCustomer,roomArray[2]);
                    else dailyPay(thisCustomer,roomArray[2]);
                    break;
                }
    }
    public static void checkOut(room[] roomArray){
        int response = 0;
        do{
        printAvail(roomArray);
        System.out.print("Please choose an " +
                "occupied room, or exit.\n\nInput: ");
        response = keyboardIn.nextInt();
        switch(response){
                case 1:
                    roomArray[0] = new room(111,3,"Full",
                            false,3,0.0,new customer(),
                            true,roomArray[0].getRevenue());
                    break;
                case 2:
                    roomArray[1] = new room(222,2,"Queen",
                            false,4,0.0,new customer(),
                            true,roomArray[1].getRevenue());
                    break;
                case 3:
                    roomArray[2] = new room(333,1,"King",
                            true,1,0.0,new customer(),
                            true,roomArray[2].getRevenue());
                    break;
                case 4:
                    break;
                default:
                    System.out.print("Invalid " +
                            "Input, please try " +
                            "again.\n\n");
        }
        }while(response != 4);
    }
    public static void report(room[] roomArray){
        System.out.println("Room  Revenue");
        double totalRevenue = 0;
        for(int i = 0;i < 3; i++)
            totalRevenue += roomArray[i].getRevenue();
        for(int i = 0; i < 3; i++)
        System.out.print(
                    roomArray[i].
                            getRoomNumber() + "   " +
                            roomArray[i].
                                    getRevenue() + "\n");
                            
        System.out.print("----------\n" +
                            "Total:  " + totalRevenue +
                "\n\n");
    }
    public static void main(String[] args) {
        room[] roomArray = {new room(111,3,"Full",false,
        3,0.0,new customer(),true,0.0),
            new room(222,2,"Queen",false,4,0.0,
                    new customer(),true,0.0),
            new room(333,1,"King",true,1,0.0,
            new customer("Mellow","Mike",
                    new date(9,27,1997),new date(1,1,2010),
            new date(8,8,8888),0,73321.25),false,73321.25)};
        int response = 0;
        do{
            displayMenu();
            response = keyboardIn.nextInt();
            switch(response){
                case 1:
                    checkIn(roomArray);
                    break;
                case 2:
                    checkOut(roomArray);
                    break;
                case 3:
                    report(roomArray);
                    break;
                case 4:
                    break;
                default:
                    System.out.print("Invalid " +
                            "Input, please try " +
                            "again.\n\n");
            }
        }while(response != 4);
    }
}