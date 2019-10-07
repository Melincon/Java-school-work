package claus_travis_final_project;

/**
 *
 * @author Travis
 */
public class SentenceCode {
    private int sentenceCode;
    private String offenceType;

    public int getSentenceCode() {
        return sentenceCode;
    }
    public void setSentenceCode(int sentenceCode) {
        this.sentenceCode = sentenceCode;
    }
    public String getOffenceType() {
        return offenceType;
    }
    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }
    
    SentenceCode(){
        this(0,"null");
    }
    SentenceCode(int sentenceCode){
        this(sentenceCode,"null");
    }
    SentenceCode(int sentenceCode,String offenceType){
        this.sentenceCode = sentenceCode;
        this.offenceType = offenceType;
    }
}
