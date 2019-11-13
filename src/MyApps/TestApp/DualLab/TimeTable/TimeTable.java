
package MyApps.TestApp.DualLab.TimeTable;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TimeTable {

    private LinkedList<Bus> busList = new LinkedList<>();

    public LinkedList<Bus> getBusList() {
        return busList;
    }

    void handleList() {


        Comparator<Bus> cmp = new ArrivalTimeComparator().thenComparing(new DepartureTimeComparator().thenComparing(new CompanyComparator()));
        busList.sort(cmp);
        ListIterator<Bus> iterator = busList.listIterator();

        Bus best;

        if (iterator.hasNext()) {
            best = iterator.next();
            while (iterator.hasNext()) {

                Bus temp = iterator.next();

                if (best.getDepartureTime().equals(temp.getDepartureTime())) {
                    if (best.getArrivalTime().equals(temp.getArrivalTime())) {
                        if (best.getCompany().equals("Posh") && temp.getCompany().equals("Grotty")) { //скорее всего удалить
                            iterator.remove();
                        } else {
                            best = temp;
                        }
                    } else {
                        if ((best.convertArrivalTime()[0] * 60 + best.convertArrivalTime()[1]) < (temp.convertArrivalTime()[0] * 60 + temp.convertArrivalTime()[1])) {
                            iterator.remove();
                        } else {
                            best = temp;
                        }
                    }
                } else {
                    if ((best.convertDepartureTime()[0] * 60 + best.convertDepartureTime()[1]) > (temp.convertDepartureTime()[0] * 60 + temp.convertDepartureTime()[1])) {
                        if ((best.convertArrivalTime()[0] * 60 + best.convertArrivalTime()[1]) <= (temp.convertArrivalTime()[0] * 60 + temp.convertArrivalTime()[1])) { //скорее всего удалить
                            iterator.remove();
                        } else {
                            best = temp;
                        }
                    } else {
                        best = temp;
                    }

                }
            }
        }

        Comparator<Bus> comparator = new CompanyComparator();
        busList.sort(comparator);
        System.out.println(busList);
    }
}


