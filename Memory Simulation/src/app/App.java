package app;

import javafx.application.Application;
import javafx.stage.Stage;
import main_view.Display_Main_View;

public class App extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		new Display_Main_View(arg0);
	}

}