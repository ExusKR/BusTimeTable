package MyApps.TestApp.DualLab.TimeTable;

import java.util.Comparator;

class CompanyComparator implements Comparator<Bus> {

    @Override
    public int compare(Bus A, Bus B) {
        if(A.getCompany().equals("Posh") && B.getCompany().equals( "Grotty")) return -1;
        else return 1;
    }
}