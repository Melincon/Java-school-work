package claus_travis_lb9;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Travis
 */
public class membership implements Serializable {
    private double monthlyFee;

    public double getMonthlyFee() {
        return monthlyFee;
    }
    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
        
    public void displayMembers(ArrayList<members>
            members){
        int i = 1;
        for(members m : members){
            System.out.println(i + ". " +
                    m.getFullName());
        i++;
        }
    }
    public void displayMember(members member){
        System.out.print("ID: " + member.getId()
        + "\nfullName: " + member.getFullName()
        + "\nbirthDate: " + member.getBirthDate()
        + "\njoinDate: " + member.getJoinDate()
        + "\nexpireDate: " + member.getExpireDate()
        + "\nisActive: " + member.isIsActive());
    }
    public double displayRevenue(silver silverMembership){
        double total = 0;
        for(members m: silverMembership.getMembers())
            if(m.isIsActive())
                total += silverMembership.getMonthlyFee();
        return total;
    }
    public double displayRevenue(gold goldMembership){
        double total = 0;
        for(members m: goldMembership.getMembers())
            if(m.isIsActive())
                total += goldMembership.getMonthlyFee();
        return total;
    }
    public double displayRevenue(platinum platMembership){
        double total = 0;
        for(members m: platMembership.getMembers())
            if(m.isIsActive())
                total += platMembership.getMonthlyFee();
        return total;
    }
    
    membership(){
        this(0.0);
    }
    membership(double monthlyFee){
        this.monthlyFee = monthlyFee;
    }
}
