package claus_travis_hw10;
import java.util.ArrayList;
/**
 *
 * @author Travis
 */
public class Claus_Travis_HW10 {

    public static void main(String[] args) {
        ArrayList<CarbonFootPrint> thisList =
                new ArrayList<>();
        
        thisList.add(new Building(85.5,79.3,45.6,
            48.2,64.58,64.5));
        thisList.add(new Car(2,6,true,21.86));
        thisList.add(new Bicycle(23.7,true,false,89.5));
        
        for(CarbonFootPrint thisFootPrint: thisList)
            System.out.println(thisFootPrint.toString());
        
        for(CarbonFootPrint thisFootPrint: thisList)
            thisFootPrint.increaseEmissions();
        
        for(CarbonFootPrint thisFootPrint: thisList)
            System.out.println(thisFootPrint.toString());
        
        for(CarbonFootPrint thisFootPrint: thisList)
            thisFootPrint.increaseEmissions();
        
        for(CarbonFootPrint thisFootPrint: thisList)
            System.out.println(thisFootPrint.toString());
        
        for(CarbonFootPrint thisFootPrint: thisList)
            thisFootPrint.decreaseEmissions();
        
        for(CarbonFootPrint thisFootPrint: thisList)
            System.out.println(thisFootPrint.toString());
    }
    
}
