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
public class DeletingViolationController implements Initializable,ControlledScreen {

    @FXML private ComboBox violationIDComboBox;
    @FXML private TextField offenderTextField;
    @FXML private TextField violationDateTextField1;
    @FXML private TextField violationDateTextField2;
    @FXML private TextField violationDateTextField3;
    @FXML private TextField violationCodeTextField;
    @FXML private TextField violationLocationTextField;
    @FXML private TextField fineAmountTextField;
    @FXML private RadioButton isPaidRadioButton;
    @FXML private RadioButton isNotPaidRadioButton;
    @FXML private TextField convictionDateTextField1;
    @FXML private TextField convictionDateTextField2;
    @FXML private TextField convictionDateTextField3;
    @FXML private TextField sentenceLengthTextField;
    @FXML private TextArea commentsTextArea;
    private ObservableList<String> cbList;
    private Connection connection;
    private PreparedStatement selectAllViolations;
    private PreparedStatement deleteViolation;
    private Violation tempViolation;
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
    private void handleViolationIDComboBoxAction(ActionEvent event){
        String selection = violationIDComboBox
                .getSelectionModel().getSelectedItem()
                .toString();
        tempViolation = new Violation(selection);
    }
    @FXML
    private void handleDeleteButtonAction(ActionEvent event){
        try{
        deleteViolation.setString(1,tempViolation.getViolationIdentification());
        deleteViolation.executeUpdate();
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        initializeComboBox();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try{
         connection = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
         selectAllViolations = connection.prepareStatement(
            "SELECT * FROM BCS345.VIOLATION");
         deleteViolation = connection.prepareStatement(
            "DELETE FROM BCS345.VIOLATION WHERE ID=?");
                 
     }
     catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
       /* initializeComboBox();*/
    }
    @FXML    
    private void initializeComboBox(){
        cbList.clear();
        try{
            ResultSet sqlResult = selectAllViolations.executeQuery();
            while(sqlResult.next()){
                cbList.add(sqlResult.getString(1));
            }
        
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        violationIDComboBox.setItems(cbList);
    }
    
}
