package calsswork_march;

/**
 *
 * @author Travis
 */
public class Calsswork_march {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        vehicle myCar = new sportCar("chevy","corvette");
        System.out.println(myCar.getClass());
        vehicle[] thisList = new vehicle[1];
        sportCar thisCar = new sportCar();
        thisList[0] = thisCar;
    }
    
}
