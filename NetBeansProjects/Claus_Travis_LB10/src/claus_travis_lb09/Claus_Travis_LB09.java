package claus_travis_lb09;
/**
 *
 * @author Travis
 */
public class Claus_Travis_LB09 {

    public static void main(String[] args) {
        vehicle[] thisList = new vehicle[6];
        thisList[0] = new compactCar();
        thisList[1] = new compactCar("Ford","Focus");
        thisList[2] = new midsizeCar();
        thisList[3] = new midsizeCar("Mercedes","c300");
        thisList[4] = new sportsCar();
        thisList[5] = new sportsCar("mercedes","500s");
        
        for(int i = 0; i < 6; i++)
            thisList[i].turnOn();
        
        thisList[3].setIsDriveable(false);
        
        for(vehicle car: thisList)
            if(car instanceof compactCar)
                car.accelerate(7);
            else if(car instanceof midsizeCar)
                car.accelerate(17);
            else if(car instanceof sportsCar)
                car.accelerate(37);
        
        for(vehicle car: thisList)
            System.out.println(car.toString());
        
        for(vehicle car: thisList)
            if(car instanceof compactCar)
                car.accelerate(17);
            else if(car instanceof midsizeCar)
                car.accelerate(27);
            else if(car instanceof sportsCar)
                car.accelerate(47);
            
        for(vehicle car: thisList)
            System.out.println(car.toString());
        
        for(vehicle car: thisList)
            if(car instanceof compactCar)
                car.decelerate(500);
            else if(car instanceof midsizeCar)
                car.decelerate(37);
            else if(car instanceof sportsCar)
                car.decelerate(57);
        
        for(vehicle car: thisList)
            System.out.println(car.toString());
    }
    
}
