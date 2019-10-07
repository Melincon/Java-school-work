package claus_travis_final_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Date;
/**
 *
 * @author Travis
 */
public class AddingCriminalController implements Initializable, ControlledScreen {
    
   @FXML private TextField ssnTextField1;
   @FXML private TextField ssnTextField2;
   @FXML private TextField ssnTextField3;
   @FXML private TextField birthCountryTextField;
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField dobTextField1;
   @FXML private TextField dobTextField2;
   @FXML private TextField dobTextField3;
   @FXML private TextField addressTextField;
   @FXML private TextField cityTextField;
   @FXML private TextField stateTextField;
   @FXML private TextField zipTextField;
   @FXML private Button addButton;
   private Connection connection;
   private PreparedStatement insertOffender;
   
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
    private void handleAddButtonAction(ActionEvent event) {
        String ssn = ssnTextField1.getText() + ssnTextField2.getText()
                + ssnTextField3.getText();
        Date birthDate = Date.valueOf(LocalDate.of(
                Integer.parseInt(dobTextField3.getText())
                ,Integer.parseInt(dobTextField1.getText())
                ,Integer.parseInt(dobTextField2.getText())));
        Criminal tempCriminal = new Criminal(ssn,birthCountryTextField.getText()
                ,firstNameTextField.getText(),lastNameTextField.getText()
            ,birthDate,addressTextField.getText(),cityTextField.getText()
            ,stateTextField.getText(),zipTextField.getText());
        try{
            insertOffender.setString(1,tempCriminal.getSsn());
            insertOffender.setString(2,tempCriminal.getBirthCountry());
            insertOffender.setString(3,tempCriminal.getFirstName());
            insertOffender.setString(4,tempCriminal.getLastName());
            insertOffender.setDate(5,tempCriminal.getBirthDate());
            insertOffender.setString(6,tempCriminal.getAddress());
            insertOffender.setString(7,tempCriminal.getCity());
            insertOffender.setString(8,tempCriminal.getState());
            insertOffender.setString(9,tempCriminal.getZip());
            insertOffender.executeUpdate();
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
            insertOffender = connection.prepareStatement(
                "INSERT INTO BCS345.OFFENDER (ID,COUNTRY_OF_BIRTH,FIRST_NAME,"
                        + "LAST_NAME,DOB,ADDRESS,CITY,STATE,ZIP) "
                        + "VALUES (?,?,?,?,?,?,?,?,?)");
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }    
    
}
