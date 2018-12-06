package memory_array_view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Memory_Array_Node_Controller implements Initializable {
	@FXML
	// Main Container for the Memory Array
	private VBox memoryArrayVBox;
	@FXML
	private Label memoryBlockSizeLbl1, memoryBlockSizeLbl2, memoryBlockSizeLbl3, memoryBlockSizeLbl4,
			memoryBlockSizeLbl5, memoryBlockSizeLbl6, memoryBlockSizeLbl7, memoryBlockSizeLbl8, memoryBlockSizeLbl9,
			memoryBlockSizeLbl10;
	@FXML
	private Label osSizeLbl, process1Size1, process1Size2, process1Size3, process1Size4, process1Size5, process1Size6,
			process1Size7, process1Size8, process1Size9, process1Size10;
	@FXML
	private VBox memBlockVBox1, memBlockVBox2, memBlockVBox3, memBlockVBox4, memBlockVBox5, memBlockVBox6,
			memBlockVBox7, memBlockVBox8, memBlockVBox9, memBlockVBox10;
	@FXML
	private VBox osMemBlockVBox, process1VBox1, process1VBox2, process1VBox3, process1VBox4, process1VBox5,
			process1VBox6, process1VBox7, process1VBox8, process1VBox9, process1VBox10;

	// Container from Main View
	private VBox memArrayContainer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//memArrayContainer.getChildren().add(memoryArrayVBox);
	}

	public void setMemArrayContainer(VBox memArrayContainer) {
		this.memArrayContainer = memArrayContainer;
	}

	public VBox getMemoryArrayVBox() {
		return memoryArrayVBox;
	}
}
