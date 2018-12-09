package main_view.director;
/*
 * 
 * Created By Giuseppe Barbieri
 * Memory Management Simulation App
 * Com 310-S01
 * 12/06/2018
 * 
 * Description: This class checks to see if memory can be compacted in the segment list.
 * 
 * 3 way...
 * 	1. User decision
 * 	2. If total process size is twice the size of the total memory size.
 * 	3. If a process has been in the waiting queue for longer than 80 cpu seconds.
 * 
 */
import alerts.Alert_For_Compacting;
import javafx.application.Platform;
import model.Process_Object;

public class Memory_Compaction_Checker {

	private Main_View_Director directorMap;
	
	public Memory_Compaction_Checker(Main_View_Director directorMap) {
		this.directorMap = directorMap;
	}
	
	public void checkMemoryForCompaction() {
		//check for elapsed time a process has been in the queue
		int processSize = 0;
		for(Process_Object e : directorMap.getWaitingQueue().getWaitingQueue()) {
			processSize += Integer.parseInt(e.getProcessSize());
			if((Integer.parseInt(e.getTimeEnteredIntoQueue()) - ((int) directorMap.getMainC().getElapsedTimeTxt() * (int) directorMap.getCsptnC().getCpuSpeedChoice())) >= 80) {
				alertForCompacting("A process has been in the queue for too long. Time to compact.");
				compactMemory();
			}
			
			if(processSize >= (Integer.parseInt(directorMap.getSanC().getTotalMemoryTxt()) * 2)) {
				alertForCompacting("The total process size in the waiting queue is 2 times the size of the total memory size.");
				compactMemory();
				processSize = 0;
			}
			
		}
		
	}
	/*
	 * Calls the ffa algorithm to compact the memory since the segment list is originated there.
	 */
	public void compactMemory() {
		directorMap.getFfat().compactMemory();
	}
	
	public void alertForCompacting(String s) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				new Alert_For_Compacting(s);
			}
		});
	}
}
