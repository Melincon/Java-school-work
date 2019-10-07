/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Travis
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label nameLabel;
    private TextField firstField;
    private TextField lastField;
    private Button thisButton;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String thisString = "Hello, " + firstField.getText()
                + " " + lastField.getText();
        nameLabel.setText(thisString);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
