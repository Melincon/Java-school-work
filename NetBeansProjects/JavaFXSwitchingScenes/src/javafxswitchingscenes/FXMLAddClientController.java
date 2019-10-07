/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxswitchingscenes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FXMLAddClientController implements Initializable, ControlledScreen {
    ScreensController myController;
    
    @FXML Button btnClose;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @Override
    public void setScreenParent(ScreensController screenParent) {
         myController = screenParent;
    }
    
    @FXML
    public void handleBtnClose(ActionEvent event)
    {
        myController.setScreen("Main");
    }


}
