package claus_travis_lb8.pkg5;
public class customer {
    String firstName;
    String lastName;
    date birthDate;
    date inDate;
    date outDate;
    int guestCount;
    double pricePaid;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public date getBirthDate() {
        return birthDate;
    }
    public date getInDate() {
        return inDate;   
    }
    public date getOutDate() {
        return outDate;
    }
    public int getGuestCount() {
        return guestCount;
    }
    public double getPricePaid() {
        return pricePaid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBirthDate(date birthDate) {
        this.birthDate = birthDate;
    }
    public void setInDate(date inDate) {
        this.inDate = inDate;
    }
    public void setOutDate(date outDate) {
        this.outDate = outDate;
    }
    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }
    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }
    
    public customer(){
        this("","",new date(),new date(),new date(),
                0,0.0);
    }
    public customer(String firstName){
        this(firstName,"",new date(),new date(),
                new date(),0,0.0);
    }
    public customer(String firstName,String lastName){
        this(firstName,lastName,new date(),
                new date(),new date(),0,0.0);
    }
    public customer(String firstName,String lastName,
            date birthDate){
        this(firstName,lastName,birthDate,new date(),
                new date(),0,0.0);
    }
    public customer(String firstName,String lastName,
            date birthDate,date inDate){
        this(firstName,lastName,birthDate,inDate,
                new date(),0,0.0);
    }
    public customer(String firstName,String lastName,
            date birthDate,date inDate,date outDate){
        this(firstName,lastName,birthDate,inDate,
                outDate,0,0.0);
    }
    public customer(String firstName,String lastName,
            date birthDate,date inDate,date outDate,
            int guestCount){
        this(firstName,lastName,birthDate,inDate,
                outDate,guestCount,0.0);
    }
    public customer(String firstName,String lastName,
            date birthDate, date inDate, date outDate,
            int guestCount, double pricePaid){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.inDate = inDate;
        this.outDate = outDate;
        this.guestCount = guestCount;
        this.pricePaid = pricePaid;
    }
}
