package claus_travis_lb09;

/**
 * compact acc +2
 * midsize acc +5
 * sport acc + 10
 * 
 * create an array of vehicles
 * 
 * override toString to explaim details including
 * class, car name, and current speed
 * 
 * @author Travis
 */
public abstract class vehicle {
    private String make;
    private String model;
    private boolean isDrivable;
    
    public String getMake(){
        return this.make;
    }
    public void setMake(String make){
        this.make = make;
    }
    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public boolean getIsDriveable(){
        return this.isDrivable;
    }
    public void setIsDriveable(boolean isDriveable){
        this.isDrivable = isDriveable;
    }
    
    public abstract void accelerate(int speed);
    public abstract void decelerate(int speed);
    @Override
    public abstract String toString();
    public void turnOn(){
        this.isDrivable = true;
        System.out.println("The car is now on.");
    };
    
    public vehicle(){
        this("defaultMake","defaultModel",true);
    }
    public vehicle(String make){
        this(make,"defaultModel",true);
    }
    public vehicle(String make,String model){
        this(make,model,true);
    }
    public vehicle (String make, String model,boolean isDriveable){
        this.model = model;
        this.make = make;
        this.isDrivable = isDriveable;
    }

}
