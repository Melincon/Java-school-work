package claus_travis_hw11;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
public class Claus_Travis_HW11 {
    private static final SecureRandom random =
            new SecureRandom();
    private static final Scanner input =
            new Scanner(System.in);
    
    public static void diagnostics()
    throws BadIgnitionException,
            DeadBatteryException,
            HeadLightException,
            BrakeLightException,
            TailLightException,
            FootBrakeException,
            ParkingBrakeException{
        int i = 0;
        for(i = 0; i < 7; i++){
        int randomInt = random.nextInt(550) + 1;
        System.out.print("Random Integer: " + randomInt +
        "\n\n");
        if(randomInt  > 49 && 56 > randomInt)
            throw new BadIgnitionException(
            "Bad Ignition");
        else if(randomInt  > 74 && 81 > randomInt)
            throw new DeadBatteryException(
            "Dead Battery");
        else if(randomInt  > 209 && 216 > randomInt)
            throw new HeadLightException(
            "Faulty Head Light");
        else if(randomInt  > 234 && 241 > randomInt)
            throw new BrakeLightException(
            "Faulty Brake Light");
        else if(randomInt  > 279 && 286 > randomInt)
            throw new TailLightException(
            "Faulty Tail Light");
        else if(randomInt  > 384 && 390 > randomInt)
            throw new FootBrakeException(
            "Faulty Foot Brake");
        else if(randomInt  > 389 && 396 > randomInt)
            throw new ParkingBrakeException(
            "Faulty Parking Brake");
        }
        if(i == 7)
            JOptionPane.showMessageDialog(null,
                "No Problems Found",
                "Diagnostic test complete",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void display(){
        try{
            diagnostics();
        }
        catch(BadIgnitionException bie){
            JOptionPane.showMessageDialog(null,
                    "Bad Ignition.",
                    "Diagnostic test failed.",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(DeadBatteryException dbe){
            JOptionPane.showMessageDialog(null,
                    "Dead Battery.",
                    "Diagnostic test failed.",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(HeadLightException hle){
            JOptionPane.showMessageDialog(null,
                    "Faulty Head Light.",
                    "Diagnostic test failed.",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(BrakeLightException ble){
            JOptionPane.showMessageDialog(null,
                    "Faulty Brake Light.",
                    "Diagnostic test failed.",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(TailLightException tle){
            JOptionPane.showMessageDialog(null,
                    "Faulty Tail Light.",
                    "Diagnostic test failed.",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(FootBrakeException fbe){
            JOptionPane.showMessageDialog(null,
                    "Faulty Foot Brake.",
                    "Diagnostic test failed.",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(ParkingBrakeException pbe){
            JOptionPane.showMessageDialog(null,
                    "Faulty Parking Break.",
                    "Diagnostic test failed.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
       int response = 0; 
       do{
       try{    
       System.out.print("Enter '1' to run diagnostics.\n"
               + "Enter '2' to exit.\n\nInput: ");
       response = input.nextInt();
       }
       catch(InputMismatchException ime){
           JOptionPane.showMessageDialog(null,
                   "Input must be an integer",
                   "Invalid Input",
                   JOptionPane.ERROR_MESSAGE);
           input.nextLine();
       }
       switch(response){
           case 1:
               display();
               break;
           case 2:
               break;
           default:
               break;
       }
       }while(response != 2);
       }
    }

