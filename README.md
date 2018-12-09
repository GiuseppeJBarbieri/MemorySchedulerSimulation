# MemorySchedulerSimulation


Use the run.exe to run the application.

This application was developed by Giuseppe J Barbieri.

This is a memory management simulator.

Comments about the app...

1. I was only able to get one algorithm to work.
2. Only unequal partition types work.
3. When setting the memory size you can't have a size less than 1024 kb or greater than 4096.
4. Preload waiting queue uses processes that are preset.
5. Generate new process option can be turned on at anytime.
6. Dont forget to scroll over in the waiting queue.
7. You can add a new process at any time as long as its not already in the waiting queue.
8. You can change the cpu speed at anytime.
9. The memory array only uses fixed partitioning.

Designing the app.

I wanted to setup a full simulator with the memory segments and all. The example given didn't show the memory segments so I decided to get it all done.

Design structure.
The way I designed the structure was kind of like a web with the Main_View_Director being the central spot to pass info between nodes and classes. Each class contains a reference to the director, which is called the director map since it maps all the classes.

There is a seperate class for the waiting queue.

The algorithm class runs on a seperate thread than the GUI thread. It loops every second.