package claus_travis_lb25;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * @author Travis
 */
public class FXMLDocumentController implements Initializable {
    private final double tax = 0.0854;
    private final double[][] priceArray = 
        {{2199.40,1454.90,960.40,226.85,552.60},
        {692.02,679.02,763.80,229.45,417.63},
        {1265.59,1443.90,933.90,252.45,455.29},
        {1299.55,1368.90,952.20,196.75,970.13}};
   
    @FXML Button okayButton = new Button();
    @FXML Button saveButton = new Button();
    @FXML Button cancelButton = new Button();
    
    @FXML TextField subtotalText = new TextField();
    @FXML TextField taxesText = new TextField();
    @FXML TextField totalText = new TextField();
    
    ToggleGroup ticketGroup = new ToggleGroup();
    ToggleGroup departingGroup = new ToggleGroup();
    ToggleGroup arrivingGroup = new ToggleGroup();
    
    @FXML RadioButton twoWay = new RadioButton();
    @FXML RadioButton oneWay = new RadioButton();

    @FXML RadioButton lgaDepart = new RadioButton();
    @FXML RadioButton jfkDepart = new RadioButton();
    @FXML RadioButton ewrDepart = new RadioButton();
    @FXML RadioButton bwiDepart = new RadioButton();
    
    @FXML RadioButton cdgArrive = new RadioButton();
    @FXML RadioButton lhrArrive = new RadioButton();
    @FXML RadioButton hndArrive = new RadioButton();
    @FXML RadioButton yulArrive = new RadioButton();
    @FXML RadioButton svoArrive = new RadioButton();
    
    private int findSelection(RadioButton[] thisArray){
        for(int i = 0; i < thisArray.length; i++)
            if(thisArray[i].isSelected())
                return i;
        System.err.println("No value chosen, please try again");
        return -1;
    }


    @FXML
    private void okayButtonAction(ActionEvent event) {
        final RadioButton[] ticketArray = {oneWay,twoWay};
        final RadioButton[] departArray = {lgaDepart,jfkDepart,
        ewrDepart,bwiDepart};
        final RadioButton[] arriveArray = {cdgArrive,lhrArrive,
        hndArrive,yulArrive,svoArrive};
        double subtotal = (findSelection(ticketArray)+1)*
                (priceArray[findSelection(departArray)]
                        [findSelection(arriveArray)]);
        if(findSelection(ticketArray) == 1)
            subtotal = subtotal*.80;
        double salesTax = subtotal*tax;
        
        subtotalText.setText(String.valueOf(subtotal));
        taxesText.setText(String.valueOf(salesTax));
        totalText.setText(String.valueOf(salesTax+subtotal));
    }
    @FXML
    private void saveButtonAction(ActionEvent event){
        
    }
    @FXML
    private void cancelButtonAction(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
