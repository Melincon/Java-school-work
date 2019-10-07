package claus_travis_final_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Travis
 */
public class ViolationIncomeReportController implements Initializable,ControlledScreen {

    @FXML private ComboBox revenueComboBox;
    @FXML private TextField revenueTextField;
    private Connection connection;
    private ObservableList<String> cbList;
    private PreparedStatement selectViolations;
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
    private void handleRevenueComboBoxAction(ActionEvent event){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        double total = 0;
        try{
           connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
           selectViolations = connection.prepareStatement(
                   "SELECT * FROM BCS345.VIOLATION WHERE FINE_ISPAID=TRUE");
           ResultSet sqlResult = selectViolations.executeQuery();
           while(sqlResult.next()){
               total =+ sqlResult.getDouble(6);
           }
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
        
    }
    
}
