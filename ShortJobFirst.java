import java.util.ArrayList;

public class ShortJobFirst {
    static ArrayList<Process>processes = new ArrayList<Process>();
    static ArrayList<Integer>inWaitProcesses = new ArrayList<Integer>();
    static int time=0;
    public static void addProcess(Process p){
        if(processes.size()==0)
            processes.add(p);
        else {
            int indx=0;
            while (indx<processes.size() && processes.get(indx).duration<=p.duration) {
                indx++;
            }
            processes.add(indx,p);
        }
    }
    public static void execute() {
        int counter = 0;
        while (counter < processes.size()) {
            inWaitProcesses.clear();
            for (int i = 0; i < processes.size(); i++) {
                if (processes.get(i).arrivalTime <= time && !processes.get(i).isExecuted) {
                    if (inWaitProcesses.size() == 0)
                        inWaitProcesses.add(i);
                    else {
                        int indx = 0;
                        while (indx < inWaitProcesses.size() &&
                                processes.get(inWaitProcesses.get(indx)).duration <= processes.get(inWaitProcesses.get(i)).duration) {
                            indx++;
                        }
                        inWaitProcesses.add(indx, i);
                    }
                }
                if (inWaitProcesses.size() != 0) {
                    Process p = processes.get(inWaitProcesses.get(0));
                    p.setWaitingTime(time - p.arrivalTime);
                    p.setExecuted(true);
                    counter++;
                    time += p.duration;
                }
                if (inWaitProcesses.size() == 0) {
                    time++;
                }
            }
        }
    }

        public static ArrayList<Process> schedule(ArrayList<Process> p) {
            for(int i=0;i<p.size();i++){
                addProcess(p.get(i));
            }
            execute();
            return processes;
        }
}
