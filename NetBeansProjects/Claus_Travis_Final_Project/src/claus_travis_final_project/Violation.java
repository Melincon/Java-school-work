package claus_travis_final_project;
import java.time.LocalDate;
import java.sql.Date;
/**
 *
 * @author Travis
 */
public class Violation {
    private String violationIdentification;
    private Criminal offender;
    private ViolationCode violationCode;
    private Date violationDate;
    private String violationLocation;
    private double fineAmount;
    private boolean isPaid;
    private Date convictionDate;
    private int sentenceLength;
    private String comments;

    public String getViolationIdentification() {
        return violationIdentification;
    }

    public void setViolationIdentification(String violationIdentification) {
        this.violationIdentification = violationIdentification;
    }

    public Criminal getOffender() {
        return offender;
    }

    public void setOffender(Criminal offender) {
        this.offender = offender;
    }

    public ViolationCode getViolationCode() {
        return violationCode;
    }

    public void setViolationCode(ViolationCode violationCode) {
        this.violationCode = violationCode;
    }

    public Date getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(Date violationDate) {
        this.violationDate = violationDate;
    }

    public String getViolationLocation() {
        return violationLocation;
    }

    public void setViolationLocation(String violationLocation) {
        this.violationLocation = violationLocation;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Date getConvictionDate() {
        return convictionDate;
    }

    public void setConvictionDate(Date convictionDate) {
        this.convictionDate = convictionDate;
    }

    public int getSentenceLength() {
        return sentenceLength;
    }

    public void setSentenceLength(int sentenceLength) {
        this.sentenceLength = sentenceLength;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    
    
    Violation(){
        this("",new Criminal(),new ViolationCode()
                ,Date.valueOf(LocalDate.now()),"",0.0
                ,false,Date.valueOf(LocalDate.now()),0,"");
    }
    Violation(String violationIdentification){
        this(violationIdentification,new Criminal(),new ViolationCode()
                ,Date.valueOf(LocalDate.now()),"",0.0,false
                ,Date.valueOf(LocalDate.now()),0,"");
    }
    Violation(String violationIdentification,Criminal offender){
        this(violationIdentification,offender,new ViolationCode()
                ,Date.valueOf(LocalDate.now()),"",0.0,false
                ,Date.valueOf(LocalDate.now()),0,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode){
        this(violationIdentification,offender,violationCode
                ,Date.valueOf(LocalDate.now())
                ,"",0.0,false,Date.valueOf(LocalDate.now()),0,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode,Date violationDate){
        this(violationIdentification,offender,violationCode,violationDate
                ,"",0.0,false,Date.valueOf(LocalDate.now()),0,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode,Date violationDate
            ,String violationLocation){
        this(violationIdentification,offender,violationCode,violationDate
                ,violationLocation,0.0,false,Date.valueOf(LocalDate.now())
                ,0,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode,Date violationDate
            ,String violationLocation,double fineAmount){
        this(violationIdentification,offender,violationCode,violationDate
                ,violationLocation,fineAmount,false
                ,Date.valueOf(LocalDate.now()),0,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode,Date violationDate
            ,String violationLocation,double fineAmount,boolean isPaid){
        this(violationIdentification,offender,violationCode,violationDate
                ,violationLocation,fineAmount,isPaid,
                Date.valueOf(LocalDate.now()),0,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode,Date violationDate
            ,String violationLocation,double fineAmount,boolean isPaid
            ,Date convictionDate){
        this(violationIdentification,offender,violationCode,violationDate
                ,violationLocation,fineAmount,isPaid,convictionDate,0,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode,Date violationDate
            ,String violationLocation,double fineAmount,boolean isPaid
            ,Date convictionDate,int sentenceLength){
        this(violationIdentification,offender,violationCode,violationDate
                ,violationLocation,fineAmount,isPaid,convictionDate
                ,sentenceLength,"");
    }
    Violation(String violationIdentification,Criminal offender
            ,ViolationCode violationCode,Date violationDate
            ,String violationLocation,double fineAmount,boolean isPaid
            ,Date convictionDate,int sentenceLength,String comments){
        this.violationIdentification = violationIdentification;
        this.offender = offender;
        this.violationCode = violationCode;
        this.violationDate = violationDate;
        this.violationLocation = violationLocation;
        this.fineAmount = fineAmount;
        this.isPaid = isPaid;
        this.convictionDate = convictionDate;
        this.sentenceLength = sentenceLength;
        this.comments = comments;
    }
}
