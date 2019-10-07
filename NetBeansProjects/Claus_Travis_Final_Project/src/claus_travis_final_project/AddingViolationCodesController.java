package claus_travis_final_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 * FXML Controller class
 *
 * @author Travis
 */
public class AddingViolationCodesController implements Initializable, ControlledScreen {

    @FXML private ComboBox sentenceCodeComboBox;
    @FXML private TextField violationCodeTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private Button addButton;
    private ObservableList<String> cbList;
    private SentenceCode selectedCode;
    private Connection connection;
    private PreparedStatement insertViolationCode;
    private PreparedStatement selectCode;
    private PreparedStatement selectSentenceCodes;
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
    private void handleAddButtonAction(ActionEvent event){
        try{
            insertViolationCode.setInt(1,Integer.parseInt(
                violationCodeTextField.getText()));
            insertViolationCode.setString(2,
                    descriptionTextArea.getText());
            insertViolationCode.setInt(3,
                    selectedCode.getSentenceCode());
            insertViolationCode.executeUpdate();
        }
        catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }
    @FXML
    private void handleSentenceCodeComboBoxAction(ActionEvent event){
        String selection = String.valueOf(sentenceCodeComboBox
                .getSelectionModel().getSelectedItem().toString());
        try{
            selectCode.setString(1,selection);
            ResultSet sqlResult = selectCode.executeQuery();
            if(sqlResult.next())
            {
                selectedCode = new SentenceCode(sqlResult.getInt(1),
                    sqlResult.getString(2));
            }
                }
        catch(SQLException sqlEx){
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
        insertViolationCode = connection.prepareStatement(
            "INSERT INTO BCS345.VIOLATION_CODE (CODE,DESCRIPTION,OFFENCE_TYPE) "
                    + "VALUES (?,?,?)");
        selectCode = connection.prepareStatement(
            "SELECT * FROM BCS345.OFFENCE_CODE WHERE Offence_Type=?");
        selectSentenceCodes = connection.prepareStatement(
                "SELECT * FROM BCS345.OFFENCE_CODE");
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        
      /* initializeComboBox();*/
    }    
    private void initializeComboBox(){
        try{
            ResultSet sqlResult = selectSentenceCodes.executeQuery();
        {
            while(sqlResult.next()){
                cbList.add(sqlResult.getString(2));
            }
        }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        sentenceCodeComboBox.setItems(cbList);
    }
}
