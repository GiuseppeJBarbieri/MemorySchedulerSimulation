/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/04/2018
 * 
 * Description: This is the main class. I used Javafx for the GUI.
 * 
 * It launches the Display_Main_View class which loads the main view.
 */
package app;

import javafx.application.Application;
import javafx.stage.Stage;
import main_view.main.Display_Main_View;

public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		new Display_Main_View(arg0);
	}

}
