package claus_travis_hw10;
/**
 *
 * @author Travis
 */
public class Car implements CarbonFootPrint {
    private int doorCount;
    private int gearCount;
    private boolean isLeather;
    private double gasolineGallons;
    
    public int getDoorCount(){
        return this.doorCount;
    }
    public void setDoorCount(int doorCount){
        this.doorCount = doorCount;
    }
    public int getGearCount(){
        return this.gearCount;
    }
    public void setGearCount(int gearCount){
        this.gearCount = gearCount;
    }
    public boolean getIsLeather(){
        return this.isLeather;
    }
    public void setIsLeather(boolean isLeather){
        this.isLeather = isLeather;
    }
    public double getGasolineGallons(){
        return this.gasolineGallons;
    }
    public void setGasolinGallons(double gasolineGallons){
        this.gasolineGallons = gasolineGallons;
    }
    @Override
    public double getCarbonFootPrint(){
        return (this.gasolineGallons*19.6);
    }
    @Override
    public void increaseEmissions(){
        this.gasolineGallons += 7.7;
    }
    @Override
    public void decreaseEmissions(){
        if(gasolineGallons > 7.7)
            this.gasolineGallons -= 7.7;
        else this.gasolineGallons = 0;
    }
    @Override
    public String toString(){
        return String.format("I am a car with %s doors and"
                + "carbon emissions: %s%n ", 
                doorCount,getCarbonFootPrint());
    }
    
    public Car(){
        this(0,0,true,0.0);
    }
    public Car(int doorCount){
        this(doorCount,0,true,0.0);
    }
    public Car(int doorCount,int gearCount){
        this(doorCount,gearCount,true,0.0);
    }
    public Car(int doorCount,int gearCount, boolean isLeather){
        this(doorCount,gearCount,isLeather,0.0);
    }
    public Car(int doorCount,int gearCount,boolean isLeather,
            double gasolineGallons){
        this.doorCount = doorCount;
        this.gearCount = gearCount;
        this.isLeather = isLeather;
        this.gasolineGallons = gasolineGallons;
    }
}
