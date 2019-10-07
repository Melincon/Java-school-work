package claus_travis_final_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Travis
 */
public class ModifyingSentenceCodesController implements Initializable,ControlledScreen {

    @FXML private ComboBox modifyComboBox;
    @FXML private TextField sentenceCodeTextField;
    @FXML private TextField offenceTypeTextField;
    @FXML private Button modifyButton;
    private ObservableList<String> cbList;
    private Connection connection;
    private PreparedStatement selectAllSentenceCodes;
    private PreparedStatement modifySentenceCode;
    private PreparedStatement selectSentenceCode;
    private SentenceCode tempSentenceCode;
    private SentenceCode tempSentenceCode2;
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
    private void handleModifyButtonAction(ActionEvent event) {
        tempSentenceCode2 = new SentenceCode(Integer.parseInt(sentenceCodeTextField.getText())
            ,offenceTypeTextField.getText());
        try{
        modifySentenceCode.setInt(1, tempSentenceCode2.getSentenceCode());
        modifySentenceCode.setString(2, tempSentenceCode2.getOffenceType());
        modifySentenceCode.setInt(3,tempSentenceCode.getSentenceCode());
        modifySentenceCode.executeUpdate();
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        initializeComboBox();
    }
    @FXML
    private void handleModifyComboBoxAction(ActionEvent event) {
        String Selection = modifyComboBox.getSelectionModel().getSelectedItem().toString();
        try{
            selectSentenceCode.setString(1, Selection);
            ResultSet sqlResult = selectSentenceCode.executeQuery();
            tempSentenceCode = new SentenceCode(sqlResult.getInt(1),sqlResult.getString(2));
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        sentenceCodeTextField.setText(String.valueOf(tempSentenceCode.getSentenceCode()));
        sentenceCodeTextField.setText(tempSentenceCode.getOffenceType());
    }
    public void initialize(URL url, ResourceBundle rb) {
        try{
            connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
            selectAllSentenceCodes = connection.prepareStatement(
                "SELECT * FROM BCS345.OFFENCE_CODE");
            modifySentenceCode = connection.prepareStatement(
                "UPDATE BCS345.OFFENCE_CODE SET CODE=?, OFFENCE_TYPE=? WHERE CODE=?");
            selectSentenceCode = connection.prepareStatement(
                "SELECT * FROM BCS345.OFFENCE_CODE WHERE OFFENCE_TYPE=?");
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
        ResultSet sqlResult = selectAllSentenceCodes.executeQuery();
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
        modifyComboBox.setItems(cbList);
    }
    
}
