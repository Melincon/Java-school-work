package claus_travis_lb9;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Travis
 */
public class platinum extends membership 
        implements Serializable{
    private transient ArrayList<String> benefits;
    private ArrayList<members> members;
    private final long serialVersionUID = 4352356546L;

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

    platinum(){
        super(99.99);
        this.benefits = new ArrayList(9);
        this.benefits.add(0,"$99.99 per month");
        this.benefits.add(1,"No Setup fee:");
        this.benefits.add(2,"Unlimited personal"
                + " training classes");
        this.benefits.add(3,"Unlimted Swimming"
                + " lessons");
        this.benefits.add(4,"Unlimited weight"
                + " lifting classes");
        this.benefits.add(5,"Unlimited workout"
                + " drinks");
        this.benefits.add(6,"Unlimited hot Yoga"
                + " classes");
        this.benefits.add(7,"Unlimited access to"
                + " racquetball court");
        this.benefits.add(8,"6 free massage sessions");
        this.members = new ArrayList();
    }
    platinum(ArrayList<members> thisList){
        super(99.99);
        this.benefits = new ArrayList(9);
        this.benefits.add(0,"$99.99 per month");
        this.benefits.add(1,"No Setup fee:");
        this.benefits.add(2,"Unlimited personal"
                + " training classes");
        this.benefits.add(3,"Unlimted Swimming"
                + " lessons");
        this.benefits.add(4,"Unlimited weight"
                + " lifting classes");
        this.benefits.add(5,"Unlimited workout"
                + " drinks");
        this.benefits.add(6,"Unlimited hot Yoga"
                + " classes");
        this.benefits.add(7,"Unlimited access to"
                + " racquetball court");
        this.benefits.add(8,"6 free massage sessions");
        this.members = thisList;
    }
}
