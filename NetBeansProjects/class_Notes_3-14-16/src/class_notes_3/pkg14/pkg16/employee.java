package class_notes_3.pkg14.pkg16;
import java.util.ArrayList;
/**
 *
 * @author Travis
 */
public class employee {
    private double salary;
    private double rate;
    private ArrayList<Double> list;
    
    public void setSalary(double salary){
        this.salary = salary;
        this.rate = this.salary / 2080;
    }
    public double getSalary(){
        return salary;
    }
    public void setRate(double rate){
        this.rate = rate;
        this.salary = this.rate * 2080;
    }
    public double getRate(){
        return rate;
    }
    public employee(){
        this(45000.00,45000.00/2080);
    }
    public employee(double salary, double rate){
        if(salary > 0)
            this.salary = salary;
        else this.salary = rate * 2080;
    }
}
