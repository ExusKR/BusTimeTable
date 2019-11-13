package MyApps.TestApp.DualLab.TimeTable;

import java.util.Comparator;

class DepartureTimeComparator implements Comparator<Bus> {
    public int compare(Bus A, Bus B){
        if(A.convertDepartureTime()[0] > B.convertDepartureTime()[0]) return -1;
        if(A.convertDepartureTime()[0] < B.convertDepartureTime()[0]) return 1;
        return -Integer.compare(A.convertDepartureTime()[1], B.convertDepartureTime()[1]);
    }
}
