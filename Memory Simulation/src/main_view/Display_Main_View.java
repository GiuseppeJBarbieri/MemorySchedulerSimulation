/*
 * 
 * Created By Giuseppe Barbieri
 * Cpu Scheduler App
 * Com 310-S01
 * 11/04/2018
 * 
 */

package main_view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Display_Main_View {

	public Display_Main_View(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_view/Main_View_Skin.fxml"));
			AnchorPane  root = loader.load();
			@SuppressWarnings("unused")
			Main_View_Controller controller = loader.getController();
			Scene scene = new Scene(root, 901, 676);
			scene.getStylesheets().add(getClass().getResource("/app/application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
