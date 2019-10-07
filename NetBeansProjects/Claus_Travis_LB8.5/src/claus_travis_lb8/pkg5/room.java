package claus_travis_lb8.pkg5;
public class room {
    int roomNumber;
    int bedsCount;
    String bedSize;
    boolean smoke;
    int maxPersons;
    double rate;
    customer person;
    boolean available;
    double revenue;

    public int getRoomNumber() {
        return roomNumber;
    }
    public int getBedsCount() {
        return bedsCount;
    }
    public String getBedSize() {
        return bedSize;
    }
    public boolean isSmoke() {
        return smoke;
    }
    public int getMaxPersons() {
        return maxPersons;
    }
    public double getRate() {
        return rate;
    }
    public customer getPerson() {
        return person;
    }
    public boolean isAvailable() {
        return available;
    }
    public double getRevenue() {
        return revenue;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }
    public void setBedSize(String bedSize) {
        this.bedSize = bedSize;
    }
    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }
    public void setMaxPersons(int maxPersons) {
        this.maxPersons = maxPersons;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public void setPerson(customer person) {
        this.person = person;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    public room(){
        this(0,0,"",false,
                0,0.0,new customer(),true,0.0);
    }
    public room(int roomNumber){
        this(roomNumber,0,"",false,
                0,0.0,new customer(),true,0.0);
    }
    public room(int roomNumber,int bedsCount){
        this(roomNumber,bedsCount,"",false,
                0,0.0,new customer(),true,0.0);
    }
    public room(int roomNumber,int bedsCount,
            String bedSize){
        this(roomNumber,bedsCount,bedSize,false,
                0,0.0,new customer(),true,0.0);
    }
    public room(int roomNumber,int bedsCount,
            String bedSize,boolean smoke){
        this(roomNumber,bedsCount,bedSize,smoke,
                0,0.0,new customer(),true,
                0.0);
    }
    public room(int roomNumber,int bedsCount,
            String bedSize,boolean smoke,
            int maxPersons){
        this(roomNumber,bedsCount,bedSize,smoke,
                maxPersons,0.0,new customer(),true,
                0.0);
    }
    public room(int roomNumber,int bedsCount,
            String bedSize,boolean smoke,
            int maxPersons,double rate){
        this(roomNumber,bedsCount,bedSize,smoke,
                maxPersons,rate,new customer(),true,
                0.0);
    }
    public room(int roomNumber,int bedsCount,
            String bedSize,boolean smoke,
            int maxPersons,double rate,
            customer person){
        this(roomNumber,bedsCount,bedSize,smoke,
                maxPersons,rate,person,true,0.0);
    }
    public room(int roomNumber,int bedsCount,
            String bedSize,boolean smoke,
            int maxPersons,double rate,customer person,
            boolean available){
        this(roomNumber,bedsCount,bedSize,smoke,
                maxPersons,rate,person,available,0.0);
    }
    public room(int roomNumber,int bedsCount,
            String bedSize,boolean smoke,
            int maxPersons,double rate,customer person,
            boolean available,double revenue){
    this.roomNumber = roomNumber;
    this.bedsCount = bedsCount;
    this.bedSize = bedSize;
    this.smoke = smoke;
    this.maxPersons = maxPersons;
    this.rate = rate;
    this.person = person;
    this.available = available;
    this.revenue = revenue;
    }
}
