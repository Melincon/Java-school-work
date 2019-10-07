/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxswitchingscenes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXSwitchingScenes extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ScreensController mainContainer = new ScreensController();
        
        // add all your FXML Screens to this container
        mainContainer.loadScreen("Main", "FXMLMain.fxml");
        mainContainer.loadScreen("AddClient", "FXMLAddClient.fxml");
        mainContainer.loadScreen("RemoveClient", "FXMLRemoveClient.fxml");
        
        
        mainContainer.setScreen("Main");
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
