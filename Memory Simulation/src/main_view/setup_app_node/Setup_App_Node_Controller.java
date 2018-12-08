package main_view.setup_app_node;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Setup_App_Node_Controller implements Initializable {
	
	@FXML
	private Button setMemorySizeBtn;
	@FXML
	private ChoiceBox<String> algorithmChoiceBox, partitionSizeTypeChoiceBox;
	@FXML
	private RadioButton nGenerateRBtn, yGenerateRBtn, nPreloadRBtn, yPreloadRBtn;
	@FXML
	private TextField totalMemoryTxt;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
