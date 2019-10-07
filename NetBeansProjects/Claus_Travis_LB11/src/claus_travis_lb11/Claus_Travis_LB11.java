package claus_travis_lb11;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
public class Claus_Travis_LB11 {        //Travis Claus
    private static customer me;         //Java Programming
    private static Scanner input;       
    
    public static void displayMenu(){
        System.out.print("1. Make a depsoit.\n" +
                "2. Make a withdrawal.\n" +
                "3. Check Balance.\n" +
                "4. Exit.\n\n");
    }
    public static void makeDeposit()
    throws HighDepositException, 
            NegativeDepositException,
            InputMismatchException,
            ArrayIndexOutOfBoundsException{
        System.out.print("Deposit amount: ");
        double deposit = input.nextDouble();
        if(deposit > 9999.99)
            throw new HighDepositException("You have exceeded "
                    + "the maximum.\n\n");
        else if(deposit < 1)
            throw new NegativeDepositException("No negative "
                    + "deposits.\n\n");
        else if(me.getDepositIndex() >= 9 || me.getDepositIndex() < 0)
            throw new ArrayIndexOutOfBoundsException("Too many "
                    + "deposits today.");
        me.setDeposit(deposit);
    } 
    public static void makeWithdrawal()
    throws DailyWithdrawalException,
            NegativeWithdrawalException,
            NegativeBalanceException,
            InputMismatchException,
            ArrayIndexOutOfBoundsException{
        System.out.print("Withdrawal amount: ");
        double withdrawal = input.nextDouble();
        if(withdrawal > 3000.00)
            throw new DailyWithdrawalException("Maximum Daily"
                    + " Withdrawal exceeded\n\n");
        else if(withdrawal < 1)
            throw new NegativeWithdrawalException("No negative"
                    + "withdrawals\n\n");
        else if((me.getBalance() - withdrawal) < 0)
            throw new NegativeBalanceException("No negative"
                    + " balances allowed.\n\n");
        else if(me.getWithdrawalIndex() >= 9 || me.getWithdrawalIndex() < 0)
            throw new ArrayIndexOutOfBoundsException("Too many "
                    + "withdrawals today.");
        me.setWithdrawal(withdrawal);
    }
    public static void checkBalance(){
        System.out.print("Balance: " + me.getBalance() + "\n\n");
    }
    public static void main(String[] args) {
        me = new customer(200.00);
        input = new Scanner(System.in);
        int response = 0;
        do{
        try{
        displayMenu();
        System.out.print("Input: ");
        response = input.nextInt();
        }
        catch(InputMismatchException ime){
            JOptionPane.showMessageDialog(null, 
                            "Enter a valid amount",
                    "Withdrawal Error", JOptionPane.ERROR_MESSAGE);
                  input.nextLine();
        }
        switch(response){
            case 1:
                try{
                makeDeposit();
                }
                catch(HighDepositException hde){
                    JOptionPane.showMessageDialog(null, 
                            "Enter a valid amount",
                    "Deposit Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(NegativeDepositException nde){
                  JOptionPane.showMessageDialog(null, 
                          "Enter a valid amount",
                    "Deposit Error", JOptionPane.ERROR_MESSAGE);          
                }
                catch(InputMismatchException ime){
                  JOptionPane.showMessageDialog(null, 
                            "Enter a valid amount",
                    "Deposit Error", JOptionPane.ERROR_MESSAGE);
                  input.nextLine();
                }
                catch(ArrayIndexOutOfBoundsException aioobe){
                  JOptionPane.showMessageDialog(null, 
                            "Too Many Deposits",
                    "Deposit Error", JOptionPane.ERROR_MESSAGE);  
                }
                break;
            case 2:
                try{
                makeWithdrawal();
                }
                catch(DailyWithdrawalException dwe){
                    JOptionPane.showMessageDialog(null, 
                            "Enter a valid amount",
                    "Withdrawal Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(NegativeWithdrawalException nwe){
                  JOptionPane.showMessageDialog(null, 
                          "Enter a valid amount",
                    "Withdrawal Error", JOptionPane.ERROR_MESSAGE);          
                }
                catch(NegativeBalanceException nbe){
                  JOptionPane.showMessageDialog(null, 
                          "Enter a valid amount",
                    "Withdrawal Error", JOptionPane.ERROR_MESSAGE);          
                }
                catch(InputMismatchException ime){
                  JOptionPane.showMessageDialog(null, 
                            "Enter a valid amount",
                    "Withdrawal Error", JOptionPane.ERROR_MESSAGE);
                  input.nextLine();
                }
                catch(ArrayIndexOutOfBoundsException aioobe){
                  JOptionPane.showMessageDialog(null, 
                            "Too Many Withdrawals",
                    "Deposit Error", JOptionPane.ERROR_MESSAGE);  
                }
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.exit(0);       
            }
        }while(true);
    } 
}
