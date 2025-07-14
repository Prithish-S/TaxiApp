package taxiBookingApp;

import java.util.*;

public class Taxi {
    int id;
    String currentLocation;
    boolean isAvailable;
    int totalEarnings;

    static List<Taxi> taxiList = new ArrayList<>();
    List<Booking> bookingList = new ArrayList<>();


    public Taxi(int id) {
        this.id = id;
        this.currentLocation = "A";
        this.isAvailable = true;
        this.totalEarnings = 0;
    }

    public static void setNoOfTaxis(int count) {
        for (int i = 1; i <= count; i++) {
            taxiList.add(new Taxi(i));
        }
    }

    // Assign taxi at pickup with lowest earnings
    public static Taxi assignTaxiAtLocation(String pickup) {
        Taxi selectedTaxi = null;
        int minEarnings = Integer.MAX_VALUE;

        for (Taxi t : taxiList) {
            if (t.isAvailable && t.currentLocation.equalsIgnoreCase(pickup)) {
                if (t.totalEarnings < minEarnings) {
                    minEarnings = t.totalEarnings;
                    selectedTaxi = t;
                }
            }
        }

        if (selectedTaxi != null) {
            selectedTaxi.isAvailable = false;
        }

        return selectedTaxi;
    }

    public static void releaseTaxi(Taxi taxi, String drop, int fare, Booking booking) {
        taxi.currentLocation = drop;
        taxi.totalEarnings += fare;
        taxi.bookingList.add(booking);  // ✅ Store booking history
        taxi.isAvailable = true;
    }


    public static void showTaxiStatus() {
        for (Taxi t : taxiList) {
            System.out.println("\nTaxi-" + t.id + " | Total Earnings: ₹" + t.totalEarnings);
        }
    }
}
