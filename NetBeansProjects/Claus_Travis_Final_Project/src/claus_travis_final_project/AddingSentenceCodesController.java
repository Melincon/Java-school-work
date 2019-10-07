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
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
/**
 * FXML Controller class
 *
 * @author Travis
 */
public class AddingSentenceCodesController implements Initializable, ControlledScreen {

    @FXML private TextField sentenceCodesTextField;
    @FXML private TextField offenceTypeTextField;
    @FXML private Button addButton;
    private Connection connection;
    private PreparedStatement insertSentenceCode;
    
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
        try{
        insertSentenceCode.setInt(1,
                Integer.parseInt(sentenceCodesTextField.getText()));
        insertSentenceCode.setString(2,
                offenceTypeTextField.getText());
        insertSentenceCode.executeUpdate();
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
        insertSentenceCode = connection.prepareStatement(
        "INSERT INTO BCS345.OFFENCE_CODE "+
        "(CODE,OFFENCE_TYPE) VALUES (?,?)");
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }    
    
}
