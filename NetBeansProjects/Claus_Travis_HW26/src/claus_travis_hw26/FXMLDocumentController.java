/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claus_travis_hw26;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Travis
 */
public class FXMLDocumentController implements Initializable {
    
    private ObservableList<String> countryComboBoxList;
    private ObservableList<String> citiesListViewList;
    
    @FXML private ComboBox countryComboBox;
    @FXML private TextField continentTextField;
    @FXML private ListView citiesListView;
    @FXML private TextField populationTextField;
    @FXML private TextField politicalSystemTextField;
    @FXML private TextField primaryReligionTextField;
    @FXML private TextField languageTextField;

    
    
    
    @FXML
    private void handleComboAction(ActionEvent event) {
        String index = String.valueOf(countryComboBox
                .getSelectionModel().getSelectedIndex()+1);
        try(Connection con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/CountryDB",
                "bcs345", "temp");
        Statement sqlStatement = con.createStatement();
        ResultSet sqlResult = sqlStatement.executeQuery(
                "SELECT * FROM Country WHERE ID= " + index)) 
                {
            if(sqlResult.next()){
            continentTextField.setText(sqlResult.getString(3));
            populationTextField.setText(sqlResult.getString(4));
            politicalSystemTextField.setText(sqlResult.getString(5));
            primaryReligionTextField.setText(sqlResult.getString(6));
            languageTextField.setText(sqlResult.getString(7));
            }
            handleCityList();
             
                }
        catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }
    private void handleCityList(){
        citiesListViewList.clear();
    String index = String.valueOf(countryComboBox
            .getSelectionModel().getSelectedIndex()+1);
        try(Connection con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/CountryDB",
                "bcs345", "temp");
        Statement sqlStatement = con.createStatement();
        ResultSet sqlResult = sqlStatement.executeQuery(
                "SELECT Name FROM City WHERE COUNTRY_ID= " + index))
        
        {
            while(sqlResult.next()){
                citiesListViewList.add(sqlResult.getString(1));
            }
           // citiesListViewList.clear();
        }
            catch(SQLException sqlEx){
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
      countryComboBoxList = FXCollections.observableArrayList();
      citiesListViewList = FXCollections.observableArrayList();
      
      
      try {
	Class.forName("org.apache.derby.jdbc.ClientDriver");
	} 
	catch (ClassNotFoundException ex)
	{
     JOptionPane.showMessageDialog(null, ex.getMessage(),
             "Database Error", JOptionPane.ERROR_MESSAGE); 
                //Dispaly error message if something goes wrong.
        }
      
      
      try(Connection con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/CountryDB",
                "bcs345", "temp");
        Statement sqlStatement = con.createStatement();
        ResultSet sqlResult = sqlStatement.executeQuery(
                "SELECT * FROM Country"))
        {
            while(sqlResult.next()){
                countryComboBoxList.add(sqlResult.getString(2));
            }
        
        }
        catch(SQLException sqlEx)
        {
            JOptionPane.showMessageDialog(null, sqlEx.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            //Dispaly error message if something goes wrong.
        }
                
            countryComboBox.setItems(countryComboBoxList);
            citiesListView.setItems(citiesListViewList);
    }   
    
}
