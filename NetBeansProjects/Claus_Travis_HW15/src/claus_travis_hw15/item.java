package claus_travis_hw15;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Harry Espaillat
 * @editor Travis Claus
 */
public class item implements Serializable{
    private String Name;
    private String partNo;
    private double price;
    private int qty;
    private LocalDate expiration;
    private static final long serialVersionUID = 1996L;
    private transient DateTimeFormatter todayFormatter =
            DateTimeFormatter.ofPattern("MM-DD-YYYY");
    
    @Override
    public String toString() {
        Period daysLeft = Period.between(
                expiration,LocalDate.now());
        return String.format("%-13s%-50s%-2d%-1s%-2d%-1s%-10d%-7d%n",
                partNo, Name,expiration.getMonthValue(),"-",
                expiration.getDayOfMonth(),"-",
                expiration.getYear(),(daysLeft.getDays() +
                        daysLeft.getMonths()*30 +
                        daysLeft.getYears()*365)*-1);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public DateTimeFormatter getTodayFormatter() {
        return todayFormatter;
    }

    public void setTodayFormatter(DateTimeFormatter todayFormatter) {
        this.todayFormatter = todayFormatter;
    }
    
    item(){
        this("","",0.0,0,0,0,0);
    }
    item(String Name,String partNo,double price,
            int qty,int month,int day,int year){
        this.Name = Name;
        this.partNo = partNo;
        this.price = price;
        this.qty = qty;
        this.expiration = LocalDate.of(year,month,day);
    }
}

