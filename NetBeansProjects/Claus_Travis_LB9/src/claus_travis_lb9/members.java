package claus_travis_lb9;
import java.time.LocalDate;
import java.io.Serializable;
/**
 *
 * @author Travis
 */
public class members implements Serializable {
    private String id;
    private String fullName;
    private LocalDate birthDate;
    private LocalDate joinDate;
    private LocalDate expireDate;
    private boolean isActive;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
    public LocalDate getExpireDate() {
        return expireDate;
    }
    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
    public boolean isIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    members(){
        this("","",LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),true);
    }
    members(String id){
        this(id,"",LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),true);
    }
    members(String id,String fullName){
        this(id,fullName,LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),true);
    }
    members(String id,String fullName,
            LocalDate birthDate){
        this(id,fullName,birthDate,LocalDate.now(),
                LocalDate.now(),true);
    }
    members(String id,String fullName,
            LocalDate birthDate,LocalDate joinDate){
        this(id,fullName,birthDate,joinDate,
                LocalDate.now(),true);
    }
    members(String id,String fullName,
            LocalDate birthDate,LocalDate joinDate,
            LocalDate expireDate){
        this(id,fullName,birthDate,joinDate,
                expireDate,true);
    }
    members(String id,String fullName,
            LocalDate birthDate,LocalDate joinDate,
            LocalDate expireDate,boolean isActive){
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.expireDate = expireDate;
        this.isActive = isActive;
    }
}
