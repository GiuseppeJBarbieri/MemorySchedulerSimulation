package main_view.add_process_node;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Add_Process_Node_Controller implements Initializable {
	@FXML
	private ChoiceBox<String> processIdChoiceBox;
	@FXML
	private TextField processSizeTxt, burstTimeTxt;
	@FXML
	private Button addProcessBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
