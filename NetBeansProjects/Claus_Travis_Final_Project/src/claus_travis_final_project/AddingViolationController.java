package claus_travis_final_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Travis
 */
public class AddingViolationController implements Initializable, ControlledScreen {

    @FXML private TextField violationIDTextField;
    @FXML private ComboBox offenderComboBox;
    @FXML private TextField violationDateTextField1;
    @FXML private TextField violationDateTextField2;
    @FXML private TextField violationDateTextField3;
    @FXML private ComboBox violationCodeComboBox;
    @FXML private TextField violationLocationTextField;
    @FXML private TextField fineAmountTextField;
    @FXML private RadioButton isPaidRadioButton;
    @FXML private RadioButton isNotPaidRadioButton;
    @FXML private TextField convictionDateTextField1;
    @FXML private TextField convictionDateTextField2;
    @FXML private TextField convictionDateTextField3;
    @FXML private TextField sentenceLengthTextField;
    @FXML private Button initialize;
    @FXML private TextArea commentsTextArea;
    private ObservableList<String> offenderList;
    private ObservableList<String> violationCodeList;
    private Connection connection;
    private PreparedStatement insertViolation;
    private PreparedStatement selectOffender;
    private PreparedStatement selectViolationCode;
    private PreparedStatement selectAllOffender;
    private PreparedStatement selectAllViolationCode;
    private PreparedStatement selectSentenceCode;
    private ViolationCode tempViolationCode;
    private Criminal tempOffender;
    private Violation tempViolation;
    private ScreensController myController;
    
    @FXML
    private void initializeCombo(ActionEvent event){
    initializeViolationCodeComboBox();
    initializeOffenderCodeComboBox();
    }
    @FXML private Button exit;
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
    @FXML
    public void exit(ActionEvent event)
    {
        myController.setScreen("Home");
    }
    
    @FXML
    private void handleOffenderComboBoxAction(ActionEvent event){
        String index = offenderComboBox.getSelectionModel()
                .getSelectedItem().toString();
        try{
            selectOffender.setString(1, index);
        ResultSet sqlResult = selectOffender.executeQuery();
        if(sqlResult.next()){
            tempOffender = new Criminal(sqlResult.getString(1)
            ,sqlResult.getString(2),sqlResult.getString(3)
            ,sqlResult.getString(4),sqlResult.getDate(5)
            ,sqlResult.getString(6),sqlResult.getString(7)
            ,sqlResult.getString(8),sqlResult.getString(9));
        }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }
    @FXML
    private void handleViolationCodeComboBoxAction(ActionEvent event){
        String index = violationCodeComboBox.getSelectionModel()
                .getSelectedItem().toString();
        SentenceCode tempSentenceCode = new SentenceCode();
        try{
            selectViolationCode.setString(1, index);
        ResultSet sqlViolationResult = selectViolationCode.executeQuery();
        if(sqlViolationResult.next()){
            try{
                selectSentenceCode.setInt(1,sqlViolationResult.getInt(3));
                ResultSet sqlSentenceResult = selectSentenceCode.executeQuery();
                if(sqlSentenceResult.next()){
                    tempSentenceCode = new SentenceCode(
                        sqlSentenceResult.getInt(1),
                        sqlSentenceResult.getString(2));
                }
            }
            catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
            tempViolationCode = new ViolationCode(sqlViolationResult.getInt(1)
            ,sqlViolationResult.getString(2),tempSentenceCode);
        }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }
    @FXML
    private void handleAddButtonAction(ActionEvent event){
        boolean isPaid = isPaid();
        Date violationDate = Date.valueOf(LocalDate.of(
                Integer.parseInt(violationDateTextField3.getText())
                ,Integer.parseInt(violationDateTextField1.getText())
                ,Integer.parseInt(violationDateTextField2.getText())));
        Date convictionDate = Date.valueOf(LocalDate.of(
                Integer.parseInt(convictionDateTextField3.getText())
                ,Integer.parseInt(convictionDateTextField1.getText())
                ,Integer.parseInt(convictionDateTextField2.getText())));
        tempViolation = new Violation(violationIDTextField.getText()
                ,tempOffender,tempViolationCode,violationDate
                ,violationLocationTextField.getText()
                ,Double.parseDouble(fineAmountTextField.getText())
                ,isPaid,convictionDate
                ,Integer.parseInt(sentenceLengthTextField.getText())
                ,commentsTextArea.getText());
        try{
            insertViolation.setString(1,tempViolation.getViolationIdentification());
            insertViolation.setString(2,tempViolation.getOffender().getSsn());
            insertViolation.setInt(3,tempViolation.getViolationCode().getViolationCode());
            insertViolation.setDate(4,tempViolation.getViolationDate());
            insertViolation.setString(5,tempViolation.getViolationLocation());
            insertViolation.setDouble(6,tempViolation.getFineAmount());
            insertViolation.setBoolean(7,tempViolation.isIsPaid());
            insertViolation.setDate(8,tempViolation.getConvictionDate());
            insertViolation.setInt(9,tempViolation.getSentenceLength());
            insertViolation.setString(10,tempViolation.getComments());
            insertViolation.executeUpdate();
            
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }
    @FXML
    private boolean isPaid(){
        if (isPaidRadioButton.isSelected())
                return true;
        else return false;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        connection = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
        insertViolation = connection.prepareStatement(
            "INSERT INTO BCS345.VIOLATION (ID,OFFENDER_ID,VIOLATION_CODE,"
                    + "VIOLATION_DATE,VIOLATION_LOCATION,FINE_AMOUNT,"
                    + "FINE_ISPAID,CONVICTION_DATE,SENTENCE_LENGTH,"
                    + "COMMENTS) VALUES (?,?,?,?,?,?,?,?,?,?)");
        selectOffender = connection.prepareStatement(
            "SELECT * FROM BCS345.OFFENDER WHERE LAST_NAME=?");
        selectViolationCode = connection.prepareStatement(
            "SELECT * FROM BCS345.VIOLATION_CODE WHERE DESCRIPTION=?");
        selectAllOffender = connection.prepareStatement(
            "SELECT * FROM BCS345.OFFENDER");
        selectAllViolationCode = connection.prepareStatement(
            "SELECT * FROM BCS345.VIOLATION_CODE");
        selectSentenceCode = connection.prepareStatement(
            "SELECT * FROM BCS345.OFFENCE_CODE WHERE CODE=?");
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        /*initializeViolationCodeComboBox();
        intializeOffenderCodeComboBox();*/
        
    }
    @FXML
    private void initializeViolationCodeComboBox(){
        try{
        ResultSet sqlResult = selectAllViolationCode.executeQuery();
        while(sqlResult.next()){
            violationCodeList.add(sqlResult.getString(2));
        }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        violationCodeComboBox.setItems(violationCodeList);
    }
    @FXML
    private void initializeOffenderCodeComboBox(){
        try{
        ResultSet sqlResult = selectAllOffender.executeQuery();
        while(sqlResult.next()){
            offenderList.add(sqlResult.getString(4));
        }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        offenderComboBox.setItems(offenderList);
    }
    
}
