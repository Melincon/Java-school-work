/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxswitchingscenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class FXMLMainController implements Initializable, ControlledScreen {
    ScreensController myController;
    private Parent root;
    private Scene scene;
    private Stage newStage;
    
    @FXML AnchorPane rootAnchor;
    @FXML MenuItem mnuFileClose;
    @FXML MenuItem mnuClientAdd;
    @FXML MenuItem mnuClientRemove;
    
    @FXML
    private void handlemnuFileClose(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void handleMnuClientAdd(ActionEvent event) {
        myController.setScreen("AddClient");     
    }

    @FXML
    private void handleMnuClientRemove(ActionEvent event) {
        myController.setScreen("RemoveClient");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
}


