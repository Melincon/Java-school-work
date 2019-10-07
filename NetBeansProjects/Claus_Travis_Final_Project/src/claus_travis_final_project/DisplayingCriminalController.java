package claus_travis_final_project;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Travis
 */
public class DisplayingCriminalController implements Initializable,ControlledScreen {

   @FXML private ComboBox criminalComboBox;
   @FXML private TextField ssnTextField1;
   @FXML private TextField birthCountryTextField;
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField dobTextField1;
   @FXML private TextField addressTextField;
   @FXML private TextField cityTextField;
   @FXML private TextField stateTextField;
   @FXML private TextField zipTextField;
   @FXML private Button saveButton;
   private ObservableList<String> offenderList;
   private ObservableList<String> violationList;
   private Connection connection;
   private PreparedStatement selectAllOffenders;
   private PreparedStatement selectOffender;
   private PreparedStatement selectViolations;
   private Criminal tempOffender;
   private static Formatter output;
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
    private void handleSaveButtonAction(ActionEvent event) {
        openWriteFile();
        output.format("%s50%n%s50%n%s50%n%s50%n"
                + "%s50%n%s50%n%s50%n%s50%n%s50%n",
                tempOffender.getSsn()
    ,tempOffender.getBirthCountry()
    ,tempOffender.getFirstName()
    ,tempOffender.getLastName()
    ,tempOffender.getBirthDate().toString()
    ,tempOffender.getAddress()
    ,tempOffender.getCity()
    ,tempOffender.getState()
    ,tempOffender.getZip());
        closeWriteFile();
    }
    @FXML
    private void handleCriminalComboBoxSelection(ActionEvent event){
        String selection = criminalComboBox
                .getSelectionModel().getSelectedItem().toString();
        try{
        selectOffender.setString(1, selection);
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
        setTextFields();
    }
    @FXML
    private void setTextFields(){
    ssnTextField1.setText(tempOffender.getSsn());
    birthCountryTextField.setText(tempOffender.getBirthCountry());
    firstNameTextField.setText(tempOffender.getFirstName());
    lastNameTextField.setText(tempOffender.getLastName());
    dobTextField1.setText(tempOffender.getBirthDate().toString());
    addressTextField.setText(tempOffender.getAddress());
    cityTextField.setText(tempOffender.getCity());
    stateTextField.setText(tempOffender.getState());
    zipTextField.setText(tempOffender.getZip());
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
           connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
           selectAllOffenders = connection.prepareStatement(
                   "SELECT * FROM BCS345.OFFENDER");
           selectOffender = connection.prepareStatement(
                   "SELECT * FROM BCS345.OFFENDER WHERE ID=?");
           selectViolations = connection.prepareStatement(
                   "SELECT * FROM BCS345.VIOLATION WHERE OFFENDER_ID=?");
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
        offenderList.clear();
        
        try{
         ResultSet sqlResult = selectOffender.executeQuery();
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
        
        criminalComboBox.setItems(offenderList);
    }
    @FXML
    public static void closeWriteFile(){
        if(output !=null)
            output.close();
    }
    @FXML
    public static void openWriteFile(){
        try{
            output = new Formatter(
            "Criminal.txt");
        }
        catch(SecurityException se){
            System.err.println("Permission denied to write."
                    + " Terminating");
            System.exit(1);
        }
        catch(FileNotFoundException fnfe){
            System.err.println("Error opening write file."
                    + "Terminating");
            System.exit(1);
        }
    }
}
