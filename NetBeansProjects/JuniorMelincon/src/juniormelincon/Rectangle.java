package juniormelincon;

/**
 *
 * @author Travis
 */
public class Rectangle {
    private double length;
    private double width;
    private double area;
    private double perimeter;
    private double diagnol;
    
    public double getLength(){
        return this.length;
    }
    public void setLength(double length){
        this. length = length;
    }
    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getArea(){
        return this.area;
    }
    public void setArea(double area){
        this.area = area;
    }
    public double getPerimeter(){
        return this.perimeter;
    }
    public void setPerimeter(double perimiter){
        this.perimeter = perimiter;
    }
    public double getDiagnol(){
        return this.diagnol;
    }
    public void setDiagnol(double diagnol){
        this.diagnol = diagnol;
    }
    
    Rectangle(){
        this(0.0,0.0,0.0,0.0,0.0);
    }
    Rectangle(double length){
        this(length,0.0,0.0,0.0,0.0);
    }
    Rectangle(double length, double width){
        this(length,width,length*width,2*(length + width),0.0);
    }
    Rectangle(double length, double width, double area){
        this(length,width,area,2*(length + width),0.0);
    }
    Rectangle(double length, double width, double area, double perimeter){
        this(length,width,area,perimeter,0.0);
    }
    Rectangle(double length, double width, double area, double perimeter, double diagnol){
        this.width = width;
        this.length = length;
        this.area = area;
        this.perimeter = perimeter;
        this.diagnol = diagnol;
    }
}
