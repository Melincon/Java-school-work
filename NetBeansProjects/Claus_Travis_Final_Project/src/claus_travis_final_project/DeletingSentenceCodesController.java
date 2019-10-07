/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class DeletingSentenceCodesController implements Initializable, ControlledScreen {

    @FXML private ComboBox deleteComboBox;
    @FXML private TextField sentenceCodeTextField;
    @FXML private TextField offenceTypeTextField;
    @FXML private Button deleteButton;
    private ObservableList<String> cbList;
    private Connection connection;
    private PreparedStatement selectAllSentenceCodes;
    private PreparedStatement selectSentenceCode;
    private PreparedStatement deleteSentenceCode;
    private PreparedStatement nullifyViolationCodes;
    private SentenceCode tempSentenceCode;
    private ScreensController myController;
    
    @FXML
    private void initializeCombo(){
        initializeComboBox();
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
    private void handleDeleteButtonAction(ActionEvent event) {
        try{
        deleteSentenceCode.setInt(1, tempSentenceCode.getSentenceCode());
        nullifyViolationCodes.setInt(1, tempSentenceCode.getSentenceCode());
        deleteSentenceCode.executeUpdate();
        nullifyViolationCodes.executeUpdate();
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
    private void handleDeleteComboBoxAction(ActionEvent event){
        String Selection = deleteComboBox.getSelectionModel().getSelectedItem()
                .toString();
        try{
            selectSentenceCode.setString(1, Selection);
            ResultSet sqlSentenceResult = selectSentenceCode.executeQuery();
            if(sqlSentenceResult.next()){
            tempSentenceCode = new SentenceCode(sqlSentenceResult.getInt(1)
                ,sqlSentenceResult.getString(2));
        }
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
        sentenceCodeTextField.setText(
                String.valueOf(tempSentenceCode.getSentenceCode()));
        offenceTypeTextField.setText(tempSentenceCode.getOffenceType());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            connection = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/bcs345", "bcs345", "temp");
            selectAllSentenceCodes = connection.prepareStatement(
                "SELECT * FROM BCS345.OFFENCE_CODE");
            selectSentenceCode = connection.prepareStatement(
                "SELECT * FROM BCS345.OFFENCE_CODE WHERE OFFENCE_TYPE=?");
            deleteSentenceCode = connection.prepareStatement(
                "DELETE FROM BCS345.OFFENCE_CODE WHERE CODE=?");
            nullifyViolationCodes = connection.prepareStatement(
                "UPDATE BCS345.VIOLATION_CODE SET OFFENCE_TYPE=NULL"
                        + " WHERE OFFENCE_TYPE=?");
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
      /*  initializeComboBox();*/
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
        deleteComboBox.setItems(cbList);
    }
    
}
