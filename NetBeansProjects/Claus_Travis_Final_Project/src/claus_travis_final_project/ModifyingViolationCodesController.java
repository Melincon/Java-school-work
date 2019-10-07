package claus_travis_final_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ModifyingViolationCodesController implements Initializable,ControlledScreen {

    @FXML private ComboBox violationSelectionComboBox;
    @FXML private ComboBox sentenceCodeComboBox;
    @FXML private TextField violationCodeTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private Button modifyButton;
    private Connection connection;
    private ObservableList<String> violationCodeList;
    private ObservableList<String> sentenceCodeList;
    private PreparedStatement selectAllViolationCodes;
    private PreparedStatement selectAllSentenceCodes;
    private PreparedStatement selectViolationCode;
    private PreparedStatement selectSentenceCode;
    private PreparedStatement modifyViolationCode;
    private ViolationCode selectedViolationCode;
    private PreparedStatement selectSentenceCodeByCode;
    private SentenceCode selectedSentenceCode;
    private ViolationCode modifiedViolationCode;
    private ScreensController myController;
    
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
    private void handleViolationSelectionComboBoxAction(ActionEvent event){
        SentenceCode tempSentenceCode = new SentenceCode();
        String selection = violationSelectionComboBox
                .getSelectionModel().getSelectedItem().toString();
        try{
            selectViolationCode.setString(1, selection);
            ResultSet sqlResult = selectViolationCode.executeQuery();
            if(sqlResult.next()){
                selectSentenceCodeByCode.setInt(1, sqlResult.getInt(3));
                ResultSet sqlSentenceResult = selectSentenceCodeByCode.executeQuery();
                tempSentenceCode = new SentenceCode(sqlSentenceResult.getInt(1)
                        ,sqlSentenceResult.getString(2));
                selectedViolationCode = new ViolationCode(sqlResult.getInt(1)
                        ,sqlResult.getString(2),tempSentenceCode);
            }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        sentenceCodeComboBox.getSelectionModel().select(tempSentenceCode.getOffenceType());
    }
    @FXML
    private void handleSentenceCodeComboBoxAction(ActionEvent event){
        String Selection = sentenceCodeComboBox.getSelectionModel().getSelectedItem().toString();
        try{
            selectSentenceCode.setString(1, Selection);
            ResultSet sqlResult = selectSentenceCode.executeQuery();
            selectedSentenceCode = new SentenceCode(sqlResult.getInt(1),sqlResult.getString(2));
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }
    @FXML
    private void handleModifyButtonAction(ActionEvent event){
        handleSentenceCodeComboBoxAction(event);
        modifiedViolationCode = new ViolationCode(Integer.parseInt(violationCodeTextField.getText())
        ,descriptionTextArea.getText(),selectedSentenceCode);
        try{
            modifyViolationCode.setInt(1, modifiedViolationCode.getViolationCode());
            modifyViolationCode.setString(2, modifiedViolationCode.getDescription());
            modifyViolationCode.setInt(3, modifiedViolationCode.getSentenceCode().getSentenceCode());
            modifyViolationCode.setInt(4, selectedViolationCode.getViolationCode());
            modifyViolationCode.executeUpdate();
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       try{
           connection = DriverManager.getConnection(
                   "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
           selectAllViolationCodes = connection.prepareStatement(
                   "SELECT * FROM BCS345.VIOLATION_CODE");
           selectAllSentenceCodes = connection.prepareStatement(
                   "SELECT * FROM BCS345.OFFENCE_CODE");
           selectViolationCode = connection.prepareStatement(
                   "SELECT * FROM BCS345.VIOLATION_CODE WHERE DESCRIPTION=?");
           selectSentenceCodeByCode = connection.prepareStatement(
                   "SELECT * FROM BCS345.OFFENCE_CODE WHERE CODE=?");
           selectSentenceCode = connection.prepareStatement(
                   "SELECT * FROM BCS345.OFFENCE_CODE WHERE OFFENCE_TYPE=?");
           modifyViolationCode = connection.prepareStatement(
                   "UPDATE BCS345.VIOLATION_CODE SET CODE=?, DESCRIPTION=?,"
                           + " OFFENCE_TYPE=? WHERE CODE=?");
       } 
       catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
      /* initializeSelectionComboBox();
       initializeSentenceCodeComboBox();*/
    }
    @FXML    
    private void initializeSelectionComboBox(){
        violationCodeList.clear();
        try{
            ResultSet sqlResult = selectAllViolationCodes.executeQuery();
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
        violationSelectionComboBox.setItems(violationCodeList);
    }
    @FXML
    private void initializeSentenceCodeComboBox(){
        sentenceCodeList.clear();
        try{
            ResultSet sqlResult = selectAllSentenceCodes.executeQuery();
            while(sqlResult.next()){
                sentenceCodeList.add(sqlResult.getString(2));
            }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        sentenceCodeComboBox.setItems(sentenceCodeList);
    }
    
}
