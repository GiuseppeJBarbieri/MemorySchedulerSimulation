package memory_array_view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Segment_Object;

public class Memory_Array_Node_Controller implements Initializable {
	@FXML
	private HBox memoryArrayContainerHBox;
	@FXML
	private VBox freeSpaceVBox, osMemBlockVBox, memoryArrayVBox, memBlock1VBox, memBlock2VBox, memBlock3VBox, memBlock4VBox,
			memBlock5VBox, memBlock6VBox, memBlock7VBox, memBlock8VBox, memBlock9VBox, memBlock10VBox;
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
	private Label memB1LimitLbl, memB2LimitLbl, memB3LimitLbl, memB4LimitLbl, memB5LimitLbl, memB6LimitLbl,
			memB7LimitLbl, memB8LimitLbl, memB9LimitLbl, memB10LimitLbl;
	@FXML
	private Label memB1BaseLbl, memB2BaseLbl, memB3BaseLbl, memB4BaseLbl, memB5BaseLbl, memB6BaseLbl, memB7BaseLbl,
			memB8BaseLbl, memB9BaseLbl, memB10BaseLbl;
	@FXML
	private Label limitOSLbl, freespaceSize, baseOsLbl, freeSpaceBaseLbl, freeSpaceSize, freeSpaceLimitLbl, osSizeLbl1;

	@FXML
	private AnchorPane limitMemBHBox1, limitMemBHBox2, limitMemBHBox3, limitMemBHBox4, limitMemBHBox5, limitMemBHBox6,
			limitMemBHBox7, limitMemBHBox8, limitMemBHBox9, limitMemBHBox10;
	@FXML
	private AnchorPane baseMemBHBox1, baseMemBHBox2, baseMemBHBox3, baseMemBHBox4, baseMemBHBox5, baseMemBHBox6,
			baseMemBHBox7, baseMemBHBox8, baseMemBHBox9, baseMemBHBox10;

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

	public void startDisplayingMemBlocks(ArrayList<Segment_Object> segmentList) {
		ArrayList<Segment_Object> segmentListCopy = new ArrayList<>();
		ArrayList<Segment_Object> orderedIndexMBList = new ArrayList<>();
		Integer lowestBaseIndex = 0;
		memoryArrayVBox.getChildren().clear();
		memoryArrayVBox.getChildren().add(osMemBlockVBox);

		for (Segment_Object e : segmentList) {
			segmentListCopy.add(e);
		}
		int lowestBase = 4097; // 1 + max memory size
		for (int i = 0; i < segmentList.size(); i++) {
			lowestBase = 4097; // 1 + max memory size
			if (segmentListCopy.size() != 0) {
				for (int j = 0; j < segmentListCopy.size(); j++) {
					if (segmentListCopy.get(j).getBase() < lowestBase) {
						lowestBase = segmentListCopy.get(j).getBase();
						lowestBaseIndex = j;
					}
				}
				orderedIndexMBList.add(segmentListCopy.get(lowestBaseIndex));
				segmentListCopy.remove(segmentListCopy.get(lowestBaseIndex));
			}
		}
		for (Segment_Object e : orderedIndexMBList) {
			System.out.println("MemBlockID: " + e.getSegmentId());
			if (e.getObj() != null) {
				System.out.println("\tContains Process" + e.getObj().getProcessId());
			}

		}
		System.out.println("---------------------------------------");
		// now that we have an organized list we must display it to the array node

		for (int i = 0; i < orderedIndexMBList.size(); i++) {
			if (orderedIndexMBList.get(i).getSegmentId() == 1) { // memBlock1VBox the memory block memoryArrayVBox is the container for the mem blocks
				memoryArrayVBox.getChildren().add(memBlock1VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 2) {
				memoryArrayVBox.getChildren().add(memBlock2VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 3) {
				memoryArrayVBox.getChildren().add(memBlock3VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 4) {
				memoryArrayVBox.getChildren().add(memBlock4VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 5) {
				memoryArrayVBox.getChildren().add(memBlock5VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 6) {
				memoryArrayVBox.getChildren().add(memBlock6VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 7) {
				memoryArrayVBox.getChildren().add(memBlock7VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 8) {
				memoryArrayVBox.getChildren().add(memBlock8VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 9) {
				memoryArrayVBox.getChildren().add(memBlock9VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 10) {
				memoryArrayVBox.getChildren().add(memBlock10VBox);
			} else if (orderedIndexMBList.get(i).getSegmentId() == 0) {
				memoryArrayVBox.getChildren().add(freeSpaceVBox);
				freeSpaceBaseLbl.setText(Integer.toString(orderedIndexMBList.get(i).getBase()));
				freeSpaceSize.setText(orderedIndexMBList.get(i).getObj().getProcessSize());
				freeSpaceLimitLbl.setText(Integer.toString(orderedIndexMBList.get(i).getLimit()));
			}
		}

	}

	public void setFreeSpaceInformation(String memorySize) {
		// sets the base and the size of the free space
		if (memorySize != null) {
			freeSpaceLimitLbl.setText(memorySize);
			freeSpaceSize.setText(Integer.toString((Integer.parseInt(memorySize) - 200)));
		}
	}

	public void setMemBlockTxtFields(ArrayList<Segment_Object> segmentList) {
		for (int i = 0; i < segmentList.size(); i++) {
			resetProcesses(segmentList);
			setProcessBoxToSegmentBox(segmentList);
			memBlockSizeTxtList.get(i)
					.setText(Integer.toString((segmentList.get(i).getLimit() - segmentList.get(i).getBase())));
			memBlockBaseLblList.get(i).setText(Integer.toString(segmentList.get(i).getBase()));
			memBlockLimitLblList.get(i).setText(Integer.toString(segmentList.get(i).getLimit()));
			// if the process is not in a segment then reset process
			// also if there is no process in a segment make the segment free space

			if (segmentList.get(i).getObj() != null) {
				if (segmentList.get(i).getObj().getProcessId().equals("P1")) {
					processSizeLblList.get(0).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(0).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P2")) {
					processSizeLblList.get(1).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(1).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P3")) {
					processSizeLblList.get(2).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(2).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P4")) {
					processSizeLblList.get(3).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(3).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P5")) {
					processSizeLblList.get(4).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(4).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P6")) {
					processSizeLblList.get(5).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(5).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P7")) {
					processSizeLblList.get(6).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(6).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P8")) {
					processSizeLblList.get(7).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(7).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P9")) {
					processSizeLblList.get(8).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(8).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P10")) {
					processSizeLblList.get(9).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(9).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P11")) {
					processSizeLblList.get(10).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(10).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P12")) {
					processSizeLblList.get(11).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(11).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P13")) {
					processSizeLblList.get(12).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(12).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P14")) {
					processSizeLblList.get(13).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(13).setText(segmentList.get(i).getObj().getBurstSize());
				} else if (segmentList.get(i).getObj().getProcessId().equals("P15")) {
					processSizeLblList.get(14).setText(segmentList.get(i).getObj().getProcessSize());
					processBurstLblList.get(14).setText(segmentList.get(i).getObj().getBurstSize());
				}

			}
		}

	}

	private void setProcessBoxToSegmentBox(ArrayList<Segment_Object> segmentList) {
		for (int i = 0; i < segmentList.size(); i++) {
			if (segmentList.get(i).getObj() != null) {
				if (segmentList.get(i).getObj().getProcessId().equals("P1")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process1HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process1HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process1HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process1HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process1HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process1HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process1HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process1HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process1HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process1HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P2")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process2HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process2HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process2HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process2HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process2HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process2HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process2HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process2HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process2HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process2HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P3")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process3HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process3HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process3HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process3HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process3HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process3HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process3HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process3HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process3HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process3HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P4")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process4HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process4HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process4HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process4HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process4HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process4HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process4HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process4HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process4HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process4HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P5")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process5HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process5HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process5HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process5HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process5HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process5HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process5HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process5HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process5HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process5HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P6")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process6HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process6HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process6HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process6HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process6HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process6HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process6HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process6HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process6HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process6HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P7")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process7HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process7HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process7HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process7HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process7HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process7HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process7HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process7HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process7HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process7HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P8")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process8HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process8HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process8HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process8HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process8HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process8HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process8HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process8HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process8HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process8HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P9")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process9HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process9HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process9HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process9HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process9HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process9HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process9HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process9HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process9HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process9HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P10")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process10HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process10HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process10HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process10HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process10HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process10HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process10HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process10HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process10HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process10HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P11")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process11HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process11HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process11HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process11HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process11HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process11HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process11HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process11HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process11HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process11HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P12")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process12HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process12HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process12HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process12HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process12HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process12HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process12HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process12HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process12HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process12HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P13")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process13HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process13HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process13HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process13HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process13HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process13HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process13HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process13HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process13HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process13HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P14")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process14HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process14HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process14HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process14HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process14HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process14HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process14HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process14HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process14HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process14HBox, limitMemBHBox10);
					}
				} else if (segmentList.get(i).getObj().getProcessId().equals("P15")) {
					if (i == 0) {
						memBlock1VBox.getChildren().setAll(baseMemBHBox1, process15HBox, limitMemBHBox1);
					} else if (i == 1) {
						memBlock2VBox.getChildren().setAll(baseMemBHBox2, process15HBox, limitMemBHBox2);
					} else if (i == 2) {
						memBlock3VBox.getChildren().setAll(baseMemBHBox3, process15HBox, limitMemBHBox3);
					} else if (i == 3) {
						memBlock4VBox.getChildren().setAll(baseMemBHBox4, process15HBox, limitMemBHBox4);
					} else if (i == 4) {
						memBlock5VBox.getChildren().setAll(baseMemBHBox5, process15HBox, limitMemBHBox5);
					} else if (i == 5) {
						memBlock6VBox.getChildren().setAll(baseMemBHBox6, process15HBox, limitMemBHBox6);
					} else if (i == 6) {
						memBlock7VBox.getChildren().setAll(baseMemBHBox7, process15HBox, limitMemBHBox7);
					} else if (i == 7) {
						memBlock8VBox.getChildren().setAll(baseMemBHBox8, process15HBox, limitMemBHBox8);
					} else if (i == 8) {
						memBlock9VBox.getChildren().setAll(baseMemBHBox9, process15HBox, limitMemBHBox9);
					} else if (i == 9) {
						memBlock10VBox.getChildren().setAll(baseMemBHBox10, process15HBox, limitMemBHBox10);
					}
				}
			}
		}
	}

	private void resetProcesses(ArrayList<Segment_Object> segmentList) {
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int p4 = 0;
		int p5 = 0;
		int p6 = 0;
		int p7 = 0;
		int p8 = 0;
		int p9 = 0;
		int p10 = 0;
		int p11 = 0;
		int p12 = 0;
		int p13 = 0;
		int p14 = 0;
		int p15 = 0;

		// if its not in the segment list then remove it
		for (int i = 0; i < segmentList.size(); i++) {
			if (segmentList.get(i).getObj() != null) {
				if (segmentList.get(i).getObj().getProcessId().equals("P1")) {
					p1 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P2")) {
					p2 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P3")) {
					p3 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P4")) {
					p4 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P5")) {
					p5 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P6")) {
					p6 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P7")) {
					p7 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P8")) {
					p8 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P9")) {
					p9 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P10")) {
					p10 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P11")) {
					p11 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P12")) {
					p12 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P13")) {
					p13 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P14")) {
					p14 = 1;
				} else if (segmentList.get(i).getObj().getProcessId().equals("P15")) {
					p15 = 1;
				}
			}
		}

		if (p1 == 0) {
			processSizeLblList.get(0).setText("0");
			processBurstLblList.get(0).setText("0");
		}
		if (p2 == 0) {
			processSizeLblList.get(1).setText("0");
			processBurstLblList.get(1).setText("0");
		}
		if (p3 == 0) {
			processSizeLblList.get(2).setText("0");
			processBurstLblList.get(2).setText("0");
		}
		if (p4 == 0) {
			processSizeLblList.get(3).setText("0");
			processBurstLblList.get(3).setText("0");
		}
		if (p5 == 0) {
			processSizeLblList.get(4).setText("0");
			processBurstLblList.get(4).setText("0");
		}
		if (p6 == 0) {
			processSizeLblList.get(5).setText("0");
			processBurstLblList.get(5).setText("0");
		}
		if (p7 == 0) {
			processSizeLblList.get(6).setText("0");
			processBurstLblList.get(6).setText("0");
		}
		if (p8 == 0) {
			processSizeLblList.get(7).setText("0");
			processBurstLblList.get(7).setText("0");
		}
		if (p9 == 0) {
			processSizeLblList.get(8).setText("0");
			processBurstLblList.get(8).setText("0");
		}
		if (p10 == 0) {
			processSizeLblList.get(9).setText("0");
			processBurstLblList.get(9).setText("0");
		}
		if (p11 == 0) {
			processSizeLblList.get(10).setText("0");
			processBurstLblList.get(10).setText("0");
		}
		if (p12 == 0) {
			processSizeLblList.get(11).setText("0");
			processBurstLblList.get(11).setText("0");
		}
		if (p13 == 0) {
			processSizeLblList.get(12).setText("0");
			processBurstLblList.get(12).setText("0");
		}
		if (p14 == 0) {
			processSizeLblList.get(13).setText("0");
			processBurstLblList.get(13).setText("0");
		}
		if (p15 == 0) {
			processSizeLblList.get(14).setText("0");
			processBurstLblList.get(14).setText("0");
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
