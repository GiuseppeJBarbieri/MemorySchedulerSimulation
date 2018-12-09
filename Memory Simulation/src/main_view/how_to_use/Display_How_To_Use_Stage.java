package main_view.how_to_use;

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
