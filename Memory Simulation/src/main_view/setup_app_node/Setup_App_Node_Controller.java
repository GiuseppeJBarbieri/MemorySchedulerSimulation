package main_view.setup_app_node;

import java.net.URL;
import java.util.ResourceBundle;

import alerts.Missing_Information_Alert;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main_view.memory_array_node.Display_Memory_Array_Node;

public class Setup_App_Node_Controller implements Initializable {
	
	@FXML
	private Button setMemorySizeBtn;
	@FXML
	private ChoiceBox<String> algorithmChoiceBox, partitionSizeTypeChoiceBox;
	@FXML
	private RadioButton nGenerateRBtn, yGenerateRBtn, nPreloadRBtn, yPreloadRBtn;
	@FXML
	private TextField totalMemoryTxt;
	
	private String[] algorithmList = { "First-Fit", "Best-Fit", "Worst-Fit" };
	private String[] partitionSizeTypeList = { "Unequal" };
	private Display_Memory_Array_Node memArrayNode;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setMemorySizeBtn.setOnAction(e -> setTotalMemorySpace());
		algorithmChoiceBox.getSelectionModel().select(0);
		partitionSizeTypeChoiceBox.getSelectionModel().select(0);
		ObservableList<String> algorithmObsList = FXCollections.observableArrayList(algorithmList);
		algorithmChoiceBox.setItems(algorithmObsList);
		ObservableList<String> partitionSizeTypeObsList = FXCollections.observableArrayList(partitionSizeTypeList);
		partitionSizeTypeChoiceBox.setItems(partitionSizeTypeObsList);
		textFieldListener();
		ToggleGroup generateGroup = new ToggleGroup();
		yGenerateRBtn.setToggleGroup(generateGroup);
		nGenerateRBtn.setToggleGroup(generateGroup);
		nGenerateRBtn.setSelected(true);
		ToggleGroup preloadGroup = new ToggleGroup();
		yPreloadRBtn.setToggleGroup(preloadGroup);
		nPreloadRBtn.setToggleGroup(preloadGroup);
		yPreloadRBtn.setSelected(true);
		totalMemoryTxt.setText("2048");
	}

	public void setTotalMemorySpace() {
		if (Integer.parseInt(totalMemoryTxt.getText()) < 1024) {
			new Missing_Information_Alert("Memory total can't be less than 1024KB (1MB) and max 4096KB (4MB).");

		} else if (Integer.parseInt(totalMemoryTxt.getText()) > 4096) {
			new Missing_Information_Alert("Memory total can't be less than 1024KB (1MB) and max 4096KB (4MB).");
		} else {
			memArrayNode.setFreeSpaceInformation(totalMemoryTxt.getText());
		}
	}
	
	private void textFieldListener() {
		totalMemoryTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					totalMemoryTxt.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}
	
	public boolean isYPreloadRBtnSelected() {
		if(yPreloadRBtn.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isYGenerateRBtnSelected() {
		if(yGenerateRBtn.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public void setMemArrayNode(Display_Memory_Array_Node memArrayNode) {
		this.memArrayNode = memArrayNode;
	}
	
	public void disableSetMemorySizeBtn(boolean x) {
		setMemorySizeBtn.setDisable(x);
	}
	
	public void setSetMemorySizeBtn(String s) {
		setMemorySizeBtn.setText(s);
		setMemorySizeBtn.setDisable(true);
	}
	public String getTotalMemoryTxt() {
		return totalMemoryTxt.getText();
	}
	public int getAlgorithmChoiceBoxSelectedIndex() {
		return algorithmChoiceBox.getSelectionModel().getSelectedIndex();
	}
}
