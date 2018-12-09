package main_view.how_to_use;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class shows the how to use stage for the GUI.
 * 
 */
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Display_How_To_Use_Stage {

	public Display_How_To_Use_Stage() {
		Stage stage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/how_to_use/How_To_Use_Stage_Skin.fxml"));
			AnchorPane root = loader.load();
			@SuppressWarnings("unused")
			How_To_Use_Stage_Controller controller = loader.getController();
			Scene scene = new Scene(root, 500, 500);
			scene.getStylesheets().add(getClass().getResource("/app/application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
