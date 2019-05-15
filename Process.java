public class Process {
    String id;
    int priority,arrivalTime,duration,waitingTime;
    boolean isExecuted=false;
    public Process(String id,int priority,int arrivalTime,int duration){
        this.id=id;
        this.priority=priority;
        this.arrivalTime=arrivalTime;
        this.duration=duration;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }
}
