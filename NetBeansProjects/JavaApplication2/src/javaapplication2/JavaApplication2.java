package javaapplication2;
import java.security.SecureRandom;
public class JavaApplication2 {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new 
        SecureRandom();
        
        int guessNumber = randomNumbers.nextInt(101);
        System.out.println(guessNumber);
    }
    
}
