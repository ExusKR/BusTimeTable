package MyApps.TestApp.DualLab.TimeTable;

import java.util.Comparator;

class ArrivalTimeComparator implements Comparator<Bus> {
    public int compare(Bus A, Bus B){
        if(A.convertArrivalTime()[0] > B.convertArrivalTime()[0]) return 1;
        if(A.convertArrivalTime()[0] < B.convertArrivalTime()[0]) return -1;
        return Integer.compare(A.convertArrivalTime()[1], B.convertArrivalTime()[1]);
    }
}