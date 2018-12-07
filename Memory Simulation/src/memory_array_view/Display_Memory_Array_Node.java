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
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Segment_Object;

public class Display_Memory_Array_Node {
	private Memory_Array_Node_Controller controller;

	public Display_Memory_Array_Node(VBox memArrBox) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/memory_array_view/Memory_Array_Skin.fxml"));
			HBox root = loader.load();
			controller = loader.getController();
			memArrBox.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void setMemBlockSizeTxtFields(ArrayList<Segment_Object> segmentList) {
		controller.setMemBlockTxtFields(segmentList);
	}

}
