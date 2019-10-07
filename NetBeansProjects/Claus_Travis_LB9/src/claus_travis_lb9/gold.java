package claus_travis_lb9;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Travis
 */
public class gold extends membership 
implements Serializable{
    private transient ArrayList<String> benefits;
    private ArrayList<members> members;
    private final long serialVersionUID = 4352345243L;

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
    
    gold(){
        super(39.99);
        this.benefits = new ArrayList(7);
        this.benefits.add(0,"$39.99 per month");
        this.benefits.add(1,"$99 setup fee:");
        this.benefits.add(2,"12 free personal"
                + " training classes");
        this.benefits.add(3,"4 free Swimming"
                + " lessons");
        this.benefits.add(4,"4 free weight"
                + " lifting classes");
        this.benefits.add(5,"2 free workout"
                + " drinks per week");
        this.benefits.add(6,"6 hot Yoga"
                + " classes");
        this.members = new ArrayList();
    }
    gold(ArrayList<members> thisList){
        super(39.99);
        this.benefits = new ArrayList(7);
        this.benefits.add(0,"$39.99 per month");
        this.benefits.add(1,"$99 setup fee:");
        this.benefits.add(2,"12 free personal"
                + " training classes");
        this.benefits.add(3,"4 free Swimming"
                + " lessons");
        this.benefits.add(4,"4 free weight"
                + " lifting classes");
        this.benefits.add(5,"2 free workout"
                + " drinks per week");
        this.benefits.add(6,"6 hot Yoga"
                + " classes");
        this.members = thisList;
    }
}
