package taxiBookingApp;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of taxis to initialize: ");
        int taxiCount = sc.nextInt();
        Taxi.setNoOfTaxis(taxiCount);

        Location.showLocations();

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Pickup Point : ");
        String pickup = sc.next().toUpperCase();

        System.out.print("Enter Drop Point : ");
        String drop = sc.next().toUpperCase();

        System.out.print("Enter Pickup Time : ");
        int pickupTime = sc.nextInt();

        Customer customer = new Customer(customerId);
        customer.book(pickup, drop, pickupTime);

        Taxi.showTaxiStatus();
    }
}
