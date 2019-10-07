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
public class DeletingViolationCodesController implements Initializable, ControlledScreen {

    @FXML private ComboBox violationSelectionComboBox;
    @FXML private TextField violationCodeTextField;
    @FXML private TextField sentenceCodeTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private Button deleteButton;
    private Connection connection;
    private ObservableList<String> cbList;
    private PreparedStatement selectViolationCode;
    private PreparedStatement deleteViolationCode;
    private PreparedStatement nullifyViolations;
    private PreparedStatement selectAllViolationCodes;
    private ViolationCode tempViolationCode;
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
        String Selection = violationSelectionComboBox
                .getSelectionModel().getSelectedItem()
                .toString();
        try{
            selectViolationCode.setString(1, Selection);
            ResultSet sqlViolationResult = selectViolationCode.executeQuery();
            if(sqlViolationResult.next()){
            tempViolationCode = new ViolationCode(sqlViolationResult.getInt(1)
                ,sqlViolationResult.getString(2));
        }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        sentenceCodeTextField.setText("");
        violationCodeTextField.setText(
            String.valueOf(tempViolationCode.getViolationCode()));
        descriptionTextArea.setText(tempViolationCode.getDescription());
    }
    @FXML
    private void handleDeleteButtonAction(ActionEvent event){
        try{
        deleteViolationCode.setInt(1, tempViolationCode.getViolationCode());
        nullifyViolations.setInt(1, tempViolationCode.getViolationCode());
        deleteViolationCode.executeUpdate();
        nullifyViolations.executeUpdate();
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        
      /*  initializeComboBox();*/
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
            selectViolationCode = connection.prepareStatement(
                "SELECT * FROM BCS345.VIOLATION_CODE WHERE DESCRIPTION=?");
            deleteViolationCode = connection.prepareStatement(
                "DELETE FROM BCS345.VIOLATION_CODE WHERE CODE=?");
            nullifyViolations = connection.prepareStatement(
                "UPDATE BCS345.VIOLATION SET VIOLATION_CODE=NULL"
                        + " WHERE VIOLATION_CODE=?");
            selectAllViolationCodes = connection.prepareStatement(
                "SELECT * FROM BCS345.VIOLATION_CODE");
            }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        
    }
    @FXML
    private void initializeComboBox(){
        cbList.clear();
        try{
            ResultSet sqlResult = selectAllViolationCodes.executeQuery();
            while(sqlResult.next()){
                cbList.add(sqlResult.getString(2));
            }
        
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        violationSelectionComboBox.setItems(cbList);
    }
}
