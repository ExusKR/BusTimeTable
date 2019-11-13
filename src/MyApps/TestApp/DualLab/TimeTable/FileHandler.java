package MyApps.TestApp.DualLab.TimeTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FileHandler {
    public static void read(List<Bus> list, File file) {

        Scanner scn;

        try {
            scn = new Scanner(file);
            while (scn.hasNextLine()) {
                String[] Line;
                Line = scn.nextLine().split(" ");
                Bus singleOne = new Bus(Line);
                if (singleOne.getTravelTime()) {
                    list.add(singleOne);
                }

            }

            scn.close();

        } catch (FileNotFoundException exp) {
            System.out.println("Вы не указали путь к файлу.");
            System.exit(-1);
        }
    }

    public static void write(List<Bus> list) {
        ListIterator<Bus> iterator = list.listIterator();
        try (FileWriter writer = new FileWriter("output.txt", false)) {
            boolean f = true;
            while (iterator.hasNext()) {
                Bus bus = iterator.next();
                if (f && bus.getCompany().equals("Grotty")) {
                    f = false;
                    writer.write("\n");
                }
                writer.write(bus.toString() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
