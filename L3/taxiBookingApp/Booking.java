package taxiBookingApp;

public class Booking {
    static int bookingCounter = 1;

    int bookingId;
    int customerId;
    String from;
    String to;
    int pickupTime;
    int dropTime;
    int amount;

    public Booking(int customerId, String from, String to, int pickupTime, int distance, int fare) {
        this.bookingId = bookingCounter++;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = pickupTime + (distance / 15);
        this.amount = fare;
    }
}
