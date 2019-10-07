/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claus_travis_final_project;

/**
 *
 * @author Travis
 */
public class ViolationCode {
    private int violationCode;
    private String description;
    private SentenceCode sentenceCode;

    public int getViolationCode() {
        return violationCode;
    }
    public void setViolationCode(int violationCode) {
        this.violationCode = violationCode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public SentenceCode getSentenceCode() {
        return sentenceCode;
    }
    public void setSentenceCode(SentenceCode sentenceCode) {
        this.sentenceCode = sentenceCode;
    } 
    
    ViolationCode(){
        this(0,"null",new SentenceCode());
    }
    ViolationCode(int violationCode){
        this(violationCode,"null",new SentenceCode());
    }
    ViolationCode(int violationCode,String description){
        this(violationCode,description,new SentenceCode());
    }
    ViolationCode(int violationCode,String description
            ,SentenceCode sentenceCode){
        this.violationCode = violationCode;
        this.description = description;
        this.sentenceCode = sentenceCode;
    }
}
