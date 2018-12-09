package alerts;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class creates a new alert box with any given message.
 * 
 */
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alert_For_Compacting {

	public Alert_For_Compacting(String s1) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning!");
		alert.setHeaderText(s1);
		alert.setContentText("Click ok to continue.");
		alert.showAndWait();
	}
}
