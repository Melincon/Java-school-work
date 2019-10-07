package claus_travis_lb9;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.nio.file.Files;
/**
 * 
 * @author Travis
 *
 */
public class Claus_Travis_LB9 {
    public static silver silverMembers = new silver();
    public static gold goldMembers = new gold();
    public static platinum platMembers = new platinum();
    private static final Scanner CIN =
            new Scanner(System.in);
    private static final DateTimeFormatter DATEFORMAT =
            DateTimeFormatter.ofPattern("MM-dd-yyyy");
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    
    public static void printMenu(){
        System.out.print("1. Add a new member\n"
                + "2. Delete a member\n"
                + "3. Freeze a membership\n"
                + "4. Display a Member\n"
                + "5. Revenue report\n"
                + "6. Exit\n\n"
                + "Input: ");
    }
    public static void addMember(){
        String id = "";
        String firstName = "";
        String lastName = "";
        String fullName = "";
        LocalDate birthDate = LocalDate.now();
        LocalDate joinDate = LocalDate.now();
        LocalDate expireDate = LocalDate.now();
        boolean isActive = true;
        boolean flag;
        do{
        try{
            System.out.print("memberID: ");
            id = CIN.next();
            flag = false;
        }
        catch(InputMismatchException ime){
            System.err.println(
                    "InputMismatchException thrown,"
                            + " please try again.");
            CIN.nextLine();
            flag = true;
        }
        }while(flag);
        do{
        try{
            System.out.print("fullName(First Last): ");
            firstName = CIN.next();
            lastName = CIN.next();
            flag = false;
        }
        catch(InputMismatchException ime){
            System.err.println(
                    "InputMimatchException thrown,"
                            + " please try again.");
            CIN.nextLine();
            flag = true;
        }
        }while(flag);
        do{
        try{
            String stringDate;
            System.out.print("birthDate(mm-dd-yyyy): ");
            stringDate = CIN.next();
            birthDate = LocalDate.parse(
                    stringDate, DATEFORMAT);
            flag = false;
        }
        catch(InputMismatchException ime){
            System.err.println(
                    "InputMismatchException thrown,"
                            + " please try again.");
            CIN.nextLine();
            flag = true;
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
            System.err.println(
                    "ArrayIndexOutOfBoundsException thrown"
                            + ", please try again.");
        flag = true;
        }
        }while(flag);
        do{
        try{
            String stringDate;
            System.out.print("joinDate(mm-dd-yyyy): ");
            stringDate = CIN.next();
            joinDate = LocalDate.parse(
                    stringDate, DATEFORMAT);
        
        flag = false;
        }
        catch(InputMismatchException ime){
            System.err.println(
                    "InputMismatchException thrown,"
                            + " please try again.");
            CIN.nextLine();
        flag = true;
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
            System.err.println(
                    "ArrayIndexOutOfBoundsException thrown"
                            + ", please try again.");
        flag = true;
        }
        }while(flag);
        do{
        try{
            String stringDate;
            System.out.print("expireDate(mm-dd-yyyy): ");
            stringDate = CIN.next();
            expireDate = LocalDate.parse(
                    stringDate, DATEFORMAT);
        flag = false;
        }
        catch(InputMismatchException ime){
            System.err.println(
                    "InputMismatchException thrown,"
                            + " please try again.");
            CIN.nextLine();
        flag = true;
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
            System.err.println(
                    "ArrayIndexOutOfBoundsException thrown"
                            + ", please try again.");
        flag = true;
        }
        }while(flag);
        do{
        try{
            System.out.print("isActive(true -or- false): ");
            CIN.nextBoolean();
        flag = false;
        }
        catch(InputMismatchException ime){
            System.err.println(
                    "InputMismatchException thrown,"
                            + " please try again.");
            CIN.nextLine();
        flag = true;
        }
        }while(flag);
        fullName = String.join(" ", firstName,lastName);
        members tempMembers = new members(
            id,fullName,birthDate,joinDate,
                expireDate,isActive);
        try{
            int response;
            do{
            System.out.print("1. Silver\n"
                    + "2. Gold\n"
                    + "3. Platinum\n"
                    + "4. Exit\n\n"
                    + "Input: ");
            response = CIN.nextInt();
            switch(response){
                case 1:
                    silverMembers.addMembers(tempMembers);
                    break;
                case 2:
                    goldMembers.addMembers(tempMembers);
                    break;
                case 3:
                    platMembers.addMembers(tempMembers);
                    break;
                case 4:
                    break;
                default:
                    System.err.println(
                            "Invalid Input, "
                                    + "please try again.");
                    break;
            }
            }while(response != 4);
        }
        catch(InputMismatchException ime){
            System.err.println(
                    "InputMismatchException thrown,"
                            + " please try again.");
            CIN.nextLine();
        }
    }
    public static void deleteMember(){
        int response;
        do{
        System.out.print("What membership does the member"
                + " posses?\n"
                + "1. Silver\n"
                + "2. Gold\n"
                + "3. Platinum\n"
                + "4. Exit\n\n"
                + "Input: ");
        response = CIN.nextInt();
        switch(response){
            case 1:
                silverRemove();
                break;
            case 2:
                goldRemove();
                break;
            case 3:
                platRemove();
                break;
            case 4:
                break;
            default:
                System.err.println("Invalid input, "
                        + "please try again.");
                break;
        }
        }while(response != 4);
    }
    public static void silverRemove(){
        int response = 0;
        silverMembers.displayMembers(
                        silverMembers.getMembers());
        System.out.print("Which member would you like "
                + "to remove?\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("InputMismatchException"
                    + " thrown, please try again");
        }
        silverMembers.getMembers().remove(response - 1);
    }
    public static void goldRemove(){
        int response = 0;
        goldMembers.displayMembers(
                        goldMembers.getMembers());
        System.out.print("Which member would you like "
                + "to remove?\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("InputMismatchException"
                    + " thrown, please try again");
        }
        goldMembers.getMembers().remove(response - 1);
    }
    public static void platRemove(){
        int response = 0;
        platMembers.displayMembers(
                        platMembers.getMembers());
        System.out.print("Which member would you like "
                + "to remove?\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("InputMismatchException"
                    + " thrown, please try again");
        }
        platMembers.getMembers().remove(response - 1);
    }
    public static void freezeMember(){
        int response;
        do{
        System.out.print("What membership does the member "
                + "possess?\n"
                + "1. Silver\n"
                + "2. Gold\n"
                + "3. platinum\n"
                + "4. Exit\n\n"
                + "Input: ");
        response = CIN.nextInt();
        switch(response){
            case 1:
                silverFreeze();
                break;
            case 2:
                goldFreeze();
                break;
            case 3:
                platFreeze();
                break;
            case 4:
                break;
            default:
                System.err.println("Invalid input, "
                        + "please try again");
                break;
        }
        }while(response != 4);
    }
    public static void silverFreeze(){
        int response = 0;
        silverMembers.displayMembers(
                silverMembers.getMembers());
        System.out.print("Which member would you like "
                + "to freeze?\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("InputMismatchException"
                    + " thrown, please try again");
        }
        silverMembers.getMembers().get(response - 1)
                    .setIsActive(false);
    }
    public static void goldFreeze(){
        int response = 0;
        goldMembers.displayMembers(
                goldMembers.getMembers());
        System.out.print("Which member would you like "
                + "to freeze?\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("InputMismatchException "
                    + "thrown, please try again");
        }
        goldMembers.getMembers().get(response - 1)
                    .setIsActive(false);
    }
    public static void platFreeze(){
        int response = 0;
        platMembers.displayMembers(
                platMembers.getMembers());
        System.out.print("\n\nWhich member would you like "
                + "to freeze\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("InputMismatchException"
                    + " thrown, please try again");
        }
        platMembers.getMembers().get(response - 1)
                .setIsActive(false);
    }
    public static void displayMember(){
        int response = 0;
        do{
        System.out.print("\n\nWhich members would you "
                + "like to see.\n\n"
                + "1. Silver\n"
                + "2. Gold\n"
                + "3. Platinum\n"
                + "4. Exit\n\n"
                + "Input: ");
        try{
        response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
                System.err.println("InputMismatchException, "
                        + "thrown, please try again.");
                }
        switch(response){
            case 1:
                displaySilverMember();
                        break;
            case 2:
                displayGoldMember();
                        break;
            case 3:
                displayPlatMember();
                        break;
            case 4:
                break;
            default:
                System.err.println("Invalid input, "
                        + "please try again");
        }
        }while(response != 4);
    }
    public static void displaySilverMember(){
        int response = 0;
        silverMembers.displayMembers(silverMembers
        .getMembers());
        System.out.print("Which member would you like "
                + "to print?\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
            System.err.println("InputMismatchException"
                    + " thrown, please try again");
            CIN.nextLine();
        }
        silverMembers.displayMember(
        silverMembers.getMembers().get(response - 1));
    }
    public static void displayGoldMember(){
     int response = 0;
     goldMembers.displayMembers(goldMembers
     .getMembers());
     System.out.print("Which member would you like"
             + " to print?\n\n"
             + "Input: ");
     try{
         response = CIN.nextInt();
     }
     catch(InputMismatchException ime){
         System.err.println("InputMismatchException thrown,"
                 + "please try again");
         CIN.nextLine();
     }
     goldMembers.displayMember(
     goldMembers.getMembers().get(response - 1));
    }
    public static void displayPlatMember(){
        int response = 0;
        platMembers.displayMembers(platMembers
        .getMembers());
        System.out.print("Which member would you like"
                + "to print?\n\n"
                + "Input: ");
        try{
            response = CIN.nextInt();
        }
        catch(InputMismatchException ime){
        System.err.println("InputMismatchException thrown,"
                + "please try again");
        CIN.nextLine();
        }
        platMembers.displayMember(
        platMembers.getMembers().get(response - 1));
    }
    public static void revenueReport(){
        double total = silverMembers.displayRevenue(
                silverMembers) + 
                goldMembers.displayRevenue(goldMembers) + 
                platMembers.displayRevenue(platMembers);
        System.out.print("Revenue:" + total
                + "\nSilver: " + silverMembers.displayRevenue(
                        silverMembers)
        + "\nGold: " + goldMembers.displayRevenue(goldMembers)
        + "\nPlatinum: " + platMembers.displayRevenue
        (platMembers) + "\n\n");
    }
    public static void deserializeData(){
        deserializeSilver();
        deserializeGold();
        deserializePlat();
    }
    public static void deserializeSilver(){
        try{
            input = new ObjectInputStream(
            Files.newInputStream(Paths.get("silver.ser")));
        }
        catch(IOException ioe){
            System.err.println("Error opening silver");
        }
        try{
        while(true){
            silverMembers = (silver) input.readObject();
        }
        }
        catch(EOFException eofe){
            System.out.print("%No More Records%");
        }
        catch(ClassNotFoundException cnfe){
            System.err.println("Invalid object Exception");
        }
        catch(IOException ioe){
            System.err.println("Error reading from silver");
        }
        try{
            if(input != null)
                input.close();
        }
        catch(IOException ioe){
            System.err.println("error closing silver");
            System.exit(1);
        }
    }
    public static void deserializeGold(){
        try{
            input = new ObjectInputStream(
            Files.newInputStream(Paths.get("gold.ser")));
        }
        catch(IOException ioe){
            System.err.println("Error opening gold");
        }
        try{
        while(true){
            goldMembers = (gold) input.readObject();
        }
        }
        catch(EOFException eofe){
            System.out.print("No More Records");
        }
        catch(ClassNotFoundException cnfe){
            System.err.println("Invalid object Exception");
        }
        catch(IOException ioe){
            System.err.println("Error reading from gold");
        }
        try{
            if(input != null)
                input.close();
        }
        catch(IOException ioe){
            System.err.println("error closing gold");
            System.exit(1);
        }
    }
    public static void deserializePlat(){
        try{
            input = new ObjectInputStream(
            Files.newInputStream(Paths.get("platinum.ser")));
        }
        catch(IOException ioe){
            System.err.println("Error opening platinum");
        }
        try{
        while(true){
            platMembers = (platinum) input.readObject();
        }
        }
        catch(EOFException eofe){
            System.out.println("%No More Records%");
        }
        catch(ClassNotFoundException cnfe){
            System.err.println("Invalid object Exception");
        }
        catch(IOException ioe){
            System.err.println("Error reading from platinum");
        }
        try{
            if(input != null)
                input.close();
        }
        catch(IOException ioe){
            System.err.println("error closing platinum");
            System.exit(1);
        }
    }
    public static void serializeData(){
        serializeSilver();
        serializeGold();
        serializePlat();
    }
    public static void serializeSilver(){
        try{
            output = new ObjectOutputStream(
            Files.newOutputStream(Paths.get("silver.ser")));
        }
        catch(IOException ioe){
            System.err.println("Error opening silver.");
            System.exit(1);
        }
        try{
            output.writeObject(silverMembers);
        }
        catch(IOException ioe){
            System.err.println("Error writing to silver");
        }
        try{
            if(output != null)
            output.close();
        }
        catch(IOException ioe){
            System.err.println("Error Closing silver");
        }
    }
    public static void serializeGold(){
        try{
            output = new ObjectOutputStream(
            Files.newOutputStream(Paths.get("gold.ser")));
        }
        catch(IOException ioe){
            System.err.println("Error opening gold.");
            System.exit(1);
        }
        try{
            output.writeObject(goldMembers);
        }
        catch(IOException ioe){
            System.err.println("Error writing to gold");
        }
        try{
            if(output != null)
            output.close();
        }
        catch(IOException ioe){
            System.err.println("Error Closing gold");
        }
    }
    public static void serializePlat(){
        try{
            output = new ObjectOutputStream(
            Files.newOutputStream(Paths.get("platinum.ser")));
        }
        catch(IOException ioe){
            System.err.println("Error opening platinum.");
            System.exit(1);
        }
        try{
            output.writeObject(platMembers);
        }
        catch(IOException ioe){
            System.err.println("Error writing to platinum");
        }
        try{
            if(output != null)
            output.close();
        }
        catch(IOException ioe){
            System.err.println("Error Closing platinum");
        }
    }
    public static void main(String[] args) {
        int response = 0; 
        deserializeData();
        do{
            try{
                printMenu();
                response = CIN.nextInt();
            }
            catch(InputMismatchException ime){
                System.err.println(
                        "InputMismatchException thrown,"
                                + " please try again.");
                CIN.nextLine();
            }
            switch(response){
                case 1:
                    addMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    freezeMember();
                    break;
                case 4:
                    displayMember();
                    break;
                case 5:
                    revenueReport();
                    break;
                case 6:
                    serializeData();
                    System.exit(0);
                    break;
                default:
                    System.err.println(
                            "Invalid input.");
                    break;
            }
        }while(response != 6);
    }
}
