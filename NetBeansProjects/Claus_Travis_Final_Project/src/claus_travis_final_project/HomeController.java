/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claus_travis_final_project;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Travis
 */
public class HomeController implements Initializable, ControlledScreen {
    @FXML private Button addPerson;
    @FXML private Button displayPerson;
    @FXML private Button addViolation;
    @FXML private Button removeViolation;
    @FXML private Button addViolationCode;
    @FXML private Button modifyViolationCode;
    @FXML private Button removeViolationCode;
    @FXML private Button addSentenceCode;
    @FXML private Button modifySentenceCode;
    @FXML private Button removeSentenceCode;
    @FXML private Button violationIncomeReport;
    @FXML AnchorPane rootAnchor;
    
    ScreensController myController;
    private Parent root;
    private Scene scene;
    private Stage newStage;
    @FXML
    private void addPerson(ActionEvent event){
        myController.setScreen("AddingCriminal");
    }
    @FXML
    private void displayPerson(ActionEvent event){
        myController.setScreen("DisplayingCriminal");
    }
    @FXML
    private void addViolation(ActionEvent event){
        myController.setScreen("AddingViolation");
    }
    @FXML
    private void removeViolation(ActionEvent event){
        myController.setScreen("DeletingViolation");
    }
    @FXML
    private void addViolationCode(ActionEvent event){
        myController.setScreen("AddingViolationCodes");
    }
    @FXML
    private void modifyViolationCode(ActionEvent event){
        myController.setScreen("ModifyingViolationCodes");
    }
    @FXML
    private void removeViolationCode(ActionEvent event){
        myController.setScreen("DeletingViolationCodes");
    }
    @FXML
    private void addSentenceCode(ActionEvent event){
        myController.setScreen("AddingSentenceCodes");
    }
    @FXML
    private void modifySentenceCode(ActionEvent event){
        myController.setScreen("ModifyingSentenceCodes");
    }
    @FXML
    private void removeSentenceCode(ActionEvent event){
        myController.setScreen("DeletingSentenceCodes");
    }
    @FXML
    private void violationIncomeReport(ActionEvent event){
        myController.setScreen("ViolationIncomeReport");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
}
