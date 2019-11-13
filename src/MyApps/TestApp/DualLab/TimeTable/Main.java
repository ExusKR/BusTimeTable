package MyApps.TestApp.DualLab.TimeTable;

import java.io.File;


public class Main {
    public static void main(String[] arg) {
        TimeTable table = new TimeTable();
        File inputFile = new File(arg[0]);

        FileHandler.read(table.getBusList(), inputFile);

        table.handleList();

        FileHandler.write(table.getBusList());
    }
}
