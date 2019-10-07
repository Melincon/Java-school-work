package claus_travis_lb9;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Travis
 */
public class silver extends membership
implements Serializable{
    private transient ArrayList<String> benefits;
    private ArrayList<members> members;
    private final long serialVersionUID = 4545645L;

    public ArrayList<String> getBenefits() {
        return benefits;
    }
    public void setBenefits(ArrayList<String> benefits) {
        this.benefits = benefits;
    }
    public ArrayList<members> getMembers() {
        return members;
    }
    public void setMembers(ArrayList<members> members) {
        this.members = members;
    }
    public void addMembers(members thisMember){
        this.members.add(thisMember);
    }
    
    silver(){
        super(10.00);
        this.benefits = new ArrayList(3);
        this.benefits.add(0,"$10 per month");
        this.benefits.add(1,"$99 Setup fee:");
        this.benefits.add(2,"3 free personal"
                + " training classes");
        this.members = new ArrayList();
    }
    silver(ArrayList<members> thisList){
        super(10.00);
        this.benefits = new ArrayList(3);
        this.benefits.add(0,"$10 per month");
        this.benefits.add(1,"$99 Setup fee:");
        this.benefits.add(2,"3 free personal"
                + " training classes");
        this.members = thisList;
    }
}
