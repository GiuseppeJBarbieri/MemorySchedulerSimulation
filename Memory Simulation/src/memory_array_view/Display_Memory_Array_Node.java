/*
 * 
 * Created By Giuseppe Barbieri
 * Cpu Scheduler App
 * Com 310-S01
 * 11/04/2018
 * 
 */

package memory_array_view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class Display_Memory_Array_Node {

	public Display_Memory_Array_Node(VBox memArrBox) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/memory_array_view/Memory_Array_Skin.fxml"));
			VBox root = loader.load();
			Memory_Array_Node_Controller controller = loader.getController();
			//controller.setMemArrayContainer(memArrBox);
			memArrBox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
