import java.util.ArrayList;

public class Main {
    public static void main(String []args){
        ArrayList<Process> pp = new ArrayList<Process>();
        pp.add(new Process("p1",2,2,5));
        pp.add(new Process("p2",2,2,3));
        pp.add(new Process("p3",1,3,10));
        pp.add(new Process("p4",3,5,10));
        pp=ShortJobFirst.schedule(pp);
    }
}
