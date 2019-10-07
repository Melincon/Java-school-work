package claus_travis_final_project;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Travis
 */
public class Claus_Travis_Final_Project extends Application {
    
    @Override
    public void start(Stage primaryStage){
        
        ScreensController mainContainer = new ScreensController();
        
        // add all your FXML Screens to this container
        mainContainer.loadScreen("Home", "Home.fxml");
        mainContainer.loadScreen("AddingCriminal", "AddingCriminal.fxml");
        mainContainer.loadScreen("AddingSentenceCodes", "AddingSentenceCodes.fxml");
        mainContainer.loadScreen("AddingViolationCodes", "AddingViolationCodes.fxml");
        mainContainer.loadScreen("AddingViolation", "AddingViolation.fxml");
        mainContainer.loadScreen("DeletingSentenceCodes", "DeletingSentenceCodes.fxml");
        mainContainer.loadScreen("DeletingViolationCodes", "DeletingViolationCodes.fxml");
        mainContainer.loadScreen("DeletingViolation", "DeletingViolation.fxml");
        mainContainer.loadScreen("DisplayingCriminal", "DisplayingCriminal.fxml");
        mainContainer.loadScreen("ModifyingSentenceCodes", "ModifyingSentenceCodes.fxml");
        mainContainer.loadScreen("ModifyingViolationCodes", "ModifyingViolationCodes.fxml");
        mainContainer.loadScreen("ViolationIncomeReport", "ViolationIncomeReport.fxml");
        
        
        mainContainer.setScreen("Home");
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        
        
        /*Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
