package main_view.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class loads the Main View which shows the main view of the application.
 * 
 */

public class Display_Main_View {

	public Display_Main_View(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/main/Main_View_Skin.fxml"));
			AnchorPane root = loader.load();
			@SuppressWarnings("unused")
			Main_View_Controller controller = loader.getController();
			Scene scene = new Scene(root, 1356, 888);
			scene.getStylesheets().add(getClass().getResource("/app/application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
