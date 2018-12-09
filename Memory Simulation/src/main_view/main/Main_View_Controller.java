package main_view.main;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class shows the main stage for the GUI.
 * It also loads each node on the GUI.
 * 
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main_view.add_process_node.Display_Add_Process_Node;
import main_view.cpu_speed_partition_type_node.Display_CPU_Speed_Partition_Type_Node;
import main_view.director.Main_View_Director;
import main_view.how_to_use.Display_How_To_Use_Stage;
import main_view.memory_array_information_node.Display_Memory_Array_Info_Node;
import main_view.memory_array_node.Display_Memory_Array_Node;
import main_view.setup_app_node.Display_Setup_App_Node;
import main_view.simulation_controls_node.Display_Simulation_Controls_Node;
import main_view.waiting_queue_node.Display_Waiting_Queue_Node;

public class Main_View_Controller implements Initializable {
	
	@FXML
	private HBox footerHBox, processCpuSpeedHBox;
	@FXML
	private VBox leftSetupAppVBox, memoryBox;
	@FXML
	private MenuItem howToUseMenuBtn;
	
	@SuppressWarnings("unused")
	private Display_Memory_Array_Node memArrayNode;
	private Display_Add_Process_Node addProccessNode;
	private Display_CPU_Speed_Partition_Type_Node displayCPUSpeedNode;
	private Display_Memory_Array_Info_Node displayMemArrInfoNode;
	private Display_Setup_App_Node displaySetupAppNode;
	private Display_Simulation_Controls_Node displaySimControlsNode;
	private Display_Waiting_Queue_Node displayWaitingQueueNode;
	private Main_View_Director mainDirector;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mainDirector = new Main_View_Director(this);
		memArrayNode = new Display_Memory_Array_Node(memoryBox, mainDirector);
		displayWaitingQueueNode = new Display_Waiting_Queue_Node(mainDirector);
		displaySetupAppNode = new Display_Setup_App_Node(mainDirector, memArrayNode);
		displayCPUSpeedNode = new Display_CPU_Speed_Partition_Type_Node(mainDirector);
		displayMemArrInfoNode = new Display_Memory_Array_Info_Node(mainDirector);
		displaySimControlsNode = new Display_Simulation_Controls_Node(mainDirector, memoryBox, memArrayNode);
		addProccessNode = new Display_Add_Process_Node(mainDirector);
		
		footerHBox.getChildren().addAll(displayWaitingQueueNode.getNode(), displaySimControlsNode.getNode(), displayMemArrInfoNode.getNode());
		processCpuSpeedHBox.getChildren().addAll(addProccessNode.getNode(),  displayCPUSpeedNode.getNode());
		leftSetupAppVBox.getChildren().addAll(displaySetupAppNode.getNode());
		
		howToUseMenuBtn.setOnAction(e -> showHowToUseStage());
	}


	private void showHowToUseStage() {
		new Display_How_To_Use_Stage();
	}
	public VBox getMemoryBox() {
		return memoryBox;
	}
}
