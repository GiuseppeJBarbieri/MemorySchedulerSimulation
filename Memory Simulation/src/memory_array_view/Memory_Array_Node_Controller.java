package memory_array_view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class Memory_Array_Node_Controller implements Initializable {
	@FXML
	private VBox memoryArrayVBox;

	private VBox memArrayContainer;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		memArrayContainer.getChildren().add(memoryArrayVBox);
	}
	
	public void setMemArrayContainer(VBox memArrayContainer) {
		this.memArrayContainer = memArrayContainer;
	}
	public VBox getMemoryArrayVBox() {
		return memoryArrayVBox;
	}
}
