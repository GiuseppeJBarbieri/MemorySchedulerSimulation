package memory_array_view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Segment_Object;

public class Memory_Array_Node_Controller implements Initializable {
	@FXML
	// Main Container for the Memory Array
	private HBox memoryArrayContainerHBox;
	@FXML
	// Container for the Memory Array
	private VBox memoryArrayVBox;
	@FXML
	private VBox memBlock1VBox, memBlock2VBox, memBlock3VBox, memBlock4VBox, memBlock5VBox, memBlock6VBox,
			memBlock7VBox, memBlock8VBox, memBlock9VBox, memBlock10VBox;
	@FXML
	private HBox process1HBox, process2HBox, process3HBox, process4HBox, process5HBox, process6HBox, process7HBox,
			process8HBox, process9HBox, process10HBox, process11HBox, process12HBox, process13HBox, process14HBox,
			process15HBox;
	@FXML
	private TextField memB1SizeTxt, memB2SizeTxt, memB3SizeTxt, memB4SizeTxt, memB5SizeTxt, memB6SizeTxt, memB7SizeTxt,
			memB8SizeTxt, memB9SizeTxt, memB10SizeTxt;
	@FXML
	private Label processSize1, processSize2, processSize3, processSize4, processSize5, processSize6, processSize7,
			processSize8, processSize9, processSize10, processSize11, processSize12, processSize13, processSize14,
			processSize15;
	@FXML
	private Label processBurst1, processBurst2, processBurst3, processBurst4, processBurst5, processBurst6,
			processBurst7, processBurst8, processBurst9, processBurst10, processBurst11, processBurst12, processBurst13,
			processBurst14, processBurst15;
	@FXML
	private Label osSizeLbl1, memB1LimitLbl, memB2LimitLbl, memB3LimitLbl, memB4LimitLbl, memB5LimitLbl, memB6LimitLbl,
			memB7LimitLbl, memB8LimitLbl, memB9LimitLbl, memB10LimitLbl;
	@FXML
	private Label memB1BaseLbl, memB2BaseLbl, memB3BaseLbl, memB4BaseLbl, memB5BaseLbl, memB6BaseLbl, memB7BaseLbl,
			memB8BaseLbl, memB9BaseLbl, memB10BaseLbl;
	@FXML
	private Label limitOSLbl, freespaceSize, baseOsLbl;

	private ArrayList<TextField> memBlockSizeTxtList;
	private ArrayList<Label> processSizeLblList;
	private ArrayList<Label> processBurstLblList;
	private ArrayList<Label> memBlockBaseLblList;
	private ArrayList<Label> memBlockLimitLblList;
	private ArrayList<VBox> memBlockVBoxList;
	private ArrayList<HBox> processHBoxList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		memBlockSizeTxtList = new ArrayList<>();
		processSizeLblList = new ArrayList<>();
		processBurstLblList = new ArrayList<>();
		memBlockBaseLblList = new ArrayList<>();
		memBlockLimitLblList = new ArrayList<>();
		memBlockVBoxList = new ArrayList<>();
		processHBoxList = new ArrayList<>();

		setProcessHBoxList();
		setTextFieldList();
		setLabelList();
		setMemBlockVBoxList();

	}

	public TextField setMemB1SizeTxt(String s) {
		memB1SizeTxt.setText(s);
		return memB10SizeTxt;
	}

	public void setMemBlockTxtFields(ArrayList<Segment_Object> segmentList) {
		for (int i = 0; i < 10; i++) {
			memBlockSizeTxtList.get(i).setText(Integer.toString((segmentList.get(i).getLimit() - segmentList.get(i).getBase())));
		}
	}

	private void setProcessHBoxList() {
		processHBoxList.add(process1HBox);
		processHBoxList.add(process2HBox);
		processHBoxList.add(process3HBox);
		processHBoxList.add(process4HBox);
		processHBoxList.add(process5HBox);
		processHBoxList.add(process6HBox);
		processHBoxList.add(process7HBox);
		processHBoxList.add(process8HBox);
		processHBoxList.add(process9HBox);
		processHBoxList.add(process10HBox);
		processHBoxList.add(process11HBox);
		processHBoxList.add(process12HBox);
		processHBoxList.add(process13HBox);
		processHBoxList.add(process14HBox);
		processHBoxList.add(process15HBox);
	}

	private void setMemBlockVBoxList() {
		memBlockVBoxList.add(memBlock1VBox);
		memBlockVBoxList.add(memBlock2VBox);
		memBlockVBoxList.add(memBlock3VBox);
		memBlockVBoxList.add(memBlock4VBox);
		memBlockVBoxList.add(memBlock5VBox);
		memBlockVBoxList.add(memBlock6VBox);
		memBlockVBoxList.add(memBlock7VBox);
		memBlockVBoxList.add(memBlock8VBox);
		memBlockVBoxList.add(memBlock9VBox);
		memBlockVBoxList.add(memBlock10VBox);
	}

	private void setLabelList() {
		processSizeLblList.add(processSize1);
		processSizeLblList.add(processSize2);
		processSizeLblList.add(processSize3);
		processSizeLblList.add(processSize4);
		processSizeLblList.add(processSize5);
		processSizeLblList.add(processSize6);
		processSizeLblList.add(processSize7);
		processSizeLblList.add(processSize8);
		processSizeLblList.add(processSize9);
		processSizeLblList.add(processSize10);
		processSizeLblList.add(processSize11);
		processSizeLblList.add(processSize12);
		processSizeLblList.add(processSize13);
		processSizeLblList.add(processSize14);
		processSizeLblList.add(processSize15);

		processBurstLblList.add(processBurst1);
		processBurstLblList.add(processBurst2);
		processBurstLblList.add(processBurst3);
		processBurstLblList.add(processBurst4);
		processBurstLblList.add(processBurst5);
		processBurstLblList.add(processBurst6);
		processBurstLblList.add(processBurst7);
		processBurstLblList.add(processBurst8);
		processBurstLblList.add(processBurst9);
		processBurstLblList.add(processBurst10);
		processBurstLblList.add(processBurst11);
		processBurstLblList.add(processBurst12);
		processBurstLblList.add(processBurst13);
		processBurstLblList.add(processBurst14);
		processBurstLblList.add(processBurst15);

		memBlockBaseLblList.add(memB1BaseLbl);
		memBlockBaseLblList.add(memB2BaseLbl);
		memBlockBaseLblList.add(memB3BaseLbl);
		memBlockBaseLblList.add(memB4BaseLbl);
		memBlockBaseLblList.add(memB5BaseLbl);
		memBlockBaseLblList.add(memB6BaseLbl);
		memBlockBaseLblList.add(memB7BaseLbl);
		memBlockBaseLblList.add(memB8BaseLbl);
		memBlockBaseLblList.add(memB9BaseLbl);
		memBlockBaseLblList.add(memB10BaseLbl);

		memBlockLimitLblList.add(memB1LimitLbl);
		memBlockLimitLblList.add(memB2LimitLbl);
		memBlockLimitLblList.add(memB3LimitLbl);
		memBlockLimitLblList.add(memB4LimitLbl);
		memBlockLimitLblList.add(memB5LimitLbl);
		memBlockLimitLblList.add(memB6LimitLbl);
		memBlockLimitLblList.add(memB7LimitLbl);
		memBlockLimitLblList.add(memB8LimitLbl);
		memBlockLimitLblList.add(memB9LimitLbl);
		memBlockLimitLblList.add(memB10LimitLbl);
	}

	private void setTextFieldList() {
		memBlockSizeTxtList.add(memB1SizeTxt);
		memBlockSizeTxtList.add(memB2SizeTxt);
		memBlockSizeTxtList.add(memB3SizeTxt);
		memBlockSizeTxtList.add(memB4SizeTxt);
		memBlockSizeTxtList.add(memB5SizeTxt);
		memBlockSizeTxtList.add(memB6SizeTxt);
		memBlockSizeTxtList.add(memB7SizeTxt);
		memBlockSizeTxtList.add(memB8SizeTxt);
		memBlockSizeTxtList.add(memB9SizeTxt);
		memBlockSizeTxtList.add(memB10SizeTxt);
	}

}
