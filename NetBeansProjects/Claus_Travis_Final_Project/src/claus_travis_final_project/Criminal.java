package claus_travis_final_project;
import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author Travis
 */
public class Criminal {
    private String ssn;
    private String birthCountry;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String city;
    private String state;
    private String zip;

    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getBirthCountry() {
        return birthCountry;
    }
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    Criminal(){
        this("","USA","null","null",Date.valueOf(LocalDate.now())
                ,"null","null","null","null");
    }
    Criminal(String ssn){
        this(ssn,"USA","null","null",Date.valueOf(LocalDate.now())
                ,"null","null","null","null");
    }
    Criminal(String ssn,String birthCountry){
        this(ssn,birthCountry,"null","null",Date.valueOf(LocalDate.now())
                ,"null","null","null","null");
    }
    Criminal(String ssn,String birthCountry,String firstName){
        this(ssn,birthCountry,firstName,"null",Date.valueOf(LocalDate.now())
                ,"null","null","null","null");
    }
    Criminal(String ssn,String birthCountry,String firstName,String lastName){
        this(ssn,birthCountry,firstName,lastName,Date.valueOf(LocalDate.now())
                ,"null","null","null","null");
    }
    Criminal(String ssn,String birthCountry,String firstName,String lastName
    ,Date birthDate){
        this(ssn,birthCountry,firstName,lastName,birthDate
                ,"null","null","null","null");
    }
    Criminal(String ssn,String birthCountry,String firstName,String lastName
    ,Date birthDate,String address){
        this(ssn,birthCountry,firstName,lastName,birthDate
                ,address,"null","null","null");
    }
    Criminal(String ssn,String birthCountry,String firstName,String lastName
    ,Date birthDate,String address,String city){
        this(ssn,birthCountry,firstName,lastName,birthDate
                ,address,city,"null","null");
    }
    Criminal(String ssn,String birthCountry,String firstName,String lastName
    ,Date birthDate,String address,String city,String state){
        this(ssn,birthCountry,firstName,lastName,birthDate
                ,address,city,state,"null");
    }
    Criminal(String ssn,String birthCountry,String firstName,String lastName
    ,Date birthDate,String address,String city,String state,String zip){
        this.ssn = ssn;
        this.birthCountry = birthCountry;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
