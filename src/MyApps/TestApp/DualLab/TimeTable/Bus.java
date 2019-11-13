package MyApps.TestApp.DualLab.TimeTable;

public class Bus {
    private String DepartureTime;
    private String ArrivalTime;
    private String Company;

    Bus(String[] Line) {


        this.Company = Line[0];
        this.DepartureTime = Line[1];
        this.ArrivalTime = Line[2];

    }

    String getDepartureTime() {
        return DepartureTime;
    }

    String getArrivalTime() {
        return ArrivalTime;
    }

    String getCompany() {
        return Company;
    }

    @Override
    public String toString() {
        return Company + " " + DepartureTime + " " + ArrivalTime;
    }

    boolean getTravelTime() {

        int[] intArrivalTime = this.convertArrivalTime();
        int[] intDepartureTime = this.convertDepartureTime();

        return (60 * intArrivalTime[0] + intArrivalTime[1]) - (60 * intDepartureTime[0] + intDepartureTime[1]) < 60;
    }

    int[] convertDepartureTime() {
        String[] splittedDepartureTime = this.DepartureTime.split(":");
        int[] intDepartureTime = new int[2];
        for (int i = 0; i < 2; i++) {
            intDepartureTime[i] = Integer.parseInt(splittedDepartureTime[i]);
        }
        return intDepartureTime;
    }

    int[] convertArrivalTime() {
        String[] splittedArrivalTime = this.ArrivalTime.split(":");
        int[] intArrivalTime = new int[2];
        for (int i = 0; i < 2; i++) {
            intArrivalTime[i] = Integer.parseInt(splittedArrivalTime[i]);
        }
        return intArrivalTime;
    }


}
