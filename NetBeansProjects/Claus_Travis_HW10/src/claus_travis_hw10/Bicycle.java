package claus_travis_hw10;
/**
 *
 * @author Travis
 */
public class Bicycle implements CarbonFootPrint {
    private double rimRadius;
    private boolean isTassles;
    private boolean isPegs;
    private double lubricantGallons;
    
    public double getRimRadius(){
        return this.rimRadius;
    }
    public void setRimRadius(double rimRadius){
        this.rimRadius = rimRadius;
    }
    public boolean getIsTassles(){
        return this.isTassles;
    }
    public void setIsTassles(boolean isTassles){
        this.isTassles = isTassles;
    }
    public boolean getIsPegs(){
        return this.isPegs;
    }
    public void setIsPegs(boolean isPegs){
        this.isPegs = isPegs;
    }
    public double getLubricatnGallons(){
        return this.lubricantGallons;
    }
    public void setLubricatnGallons(double lubricantGallons){
        this.lubricantGallons = lubricantGallons;
    }
    @Override
    public double getCarbonFootPrint(){
        return (this.lubricantGallons*23.62);
    }
    @Override
    public void increaseEmissions(){
        this.lubricantGallons += 17.7;
    }
    @Override
    public void decreaseEmissions(){
        if(this.lubricantGallons > 17.7)
            this.lubricantGallons -= 17.7;
        else this.lubricantGallons = 0;
    }
    @Override
    public String toString(){
        return String.format("I am a Bicycle with rimRadius %s "
                + "and Omssions: %s%n",rimRadius,getCarbonFootPrint());
    }
    
    public Bicycle(){
        this(0.0,true,true,0.0);
    }
    public Bicycle(double rimRadius){
        this(rimRadius,true,true,0.0);
    }
    public Bicycle(double rimRadius,boolean isTassles){
        this(rimRadius,isTassles,true,0.0);
    }
    public Bicycle(double rimRadius,boolean isTassles,
            boolean isPegs){
        
        this(rimRadius,isTassles,isPegs,0.0);
    }
    public Bicycle(double rimRadius,boolean isTassles,
            boolean isPegs,double lubricantGallons){
        this.rimRadius = rimRadius;
        this.isTassles = isTassles;
        this.isPegs = isPegs;
        this.lubricantGallons = lubricantGallons;
    }
}
