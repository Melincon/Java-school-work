package claus_travis_hw10;
/**
 *
 * @author Travis
 */
public class Building implements CarbonFootPrint {
    private double height;
    private double width;
    private double length;
    private double propaneGallons;
    private double dieselGallons;
    private double naturalGasFeet;
    
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getLength(){
        return this.length;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getPropaneGallons(){
        return this.propaneGallons;
    }
    public void setPropaneGallons(double propaneGallons){
        this.propaneGallons = propaneGallons;
    }
    public double getDieselGallons(){
        return this.dieselGallons;
    }
    public void setDieselFallons(double dieselGallons){
        this.dieselGallons = dieselGallons;
    }
    public double getNaturalGasFeet(){
        return this.naturalGasFeet;
    }
    public void setNaturalGasGallons(double naturalGasFeet){
        this.naturalGasFeet = naturalGasFeet;
    }
    @Override
    public double getCarbonFootPrint(){
        return ((this.propaneGallons*12.7)+(this.dieselGallons*22.4)
                +(this.naturalGasFeet*117.10));
    }
    @Override 
    public void increaseEmissions(){
        this.propaneGallons += 10.7;
        this.dieselGallons += 10.7;
        this.naturalGasFeet += 10.7;
    }
    @Override
    public void decreaseEmissions(){
        if(propaneGallons > 10.7)
            this.propaneGallons -= 10.7;
        else this.propaneGallons = 0;
        if(dieselGallons > 10.7)
            this.dieselGallons -= 10.7;
        else this.dieselGallons = 0;
        if(naturalGasFeet > 10.7)
            this.naturalGasFeet -= 10.7;
        else this.naturalGasFeet = 0;
    }
    @Override
    public String toString(){
        return String.format("I am a building with "
                + "a height of %s and a carbon "
                + "emissions of: %s%n", 
                height,getCarbonFootPrint());
    }
    
    public Building(){
        this(0.0,0.0,0.0,0.0,0.0,0.0);
    }
    public Building(double height){
        this(height,0.0,0.0,0.0,0.0,0.0);
    }
    public Building(double height,double width){
        this(height,width,0.0,0.0,0.0,0.0);
    }
    public Building(double height,double width,double length){
        this(height,width,length,0.0,0.0,0.0);
    }
    public Building(double height,double width,double length,
            double propaneGallons){
        this(height,width,length,propaneGallons,0.0,0.0);
    }
    public Building(double height,double width,double length,
            double propaneGallons,double dieselGallons){
        this(height,width,length,propaneGallons,dieselGallons,0.0);
    }
    public Building(double height,double width,double length,
            double propaneGallons,double dieselGallons,
            double naturalGasFeet){
        this.height = height;
        this.width = width;
        this.length = length;
        this.propaneGallons = propaneGallons;
        this.dieselGallons = dieselGallons;
        this.naturalGasFeet = naturalGasFeet;
    }
}
