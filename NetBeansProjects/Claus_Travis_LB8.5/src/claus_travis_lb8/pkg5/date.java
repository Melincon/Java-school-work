package claus_travis_lb8.pkg5;
public class date {
    private int month;
    private int day;
    private int year;

    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    public date(){
        this(1,1,2010);
    }
    public date(int month){
        this(month,1,2010);
    }
    public date(int month,int day){
        this(month,day,2010);
    }
    public date(int month, int day, int year){
        if(month < 1 || month > 12 || day < 1 ||
                day > 31 || year < 1900)
            throw new IllegalArgumentException(
            "Invalid date.");
        this.month = month;
        this.day = day;
        this.year = year;
    }
}
