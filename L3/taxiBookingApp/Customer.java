package taxiBookingApp;

import java.util.*;

public class Customer {
	static List<Integer> l=new ArrayList<>();
	int customer_id;
	
	Customer(int customer_id){
		this.customer_id=customer_id;
		l.add(customer_id);
	}
	
	public void setcustomer_id(int customer_id) {
		this.customer_id=customer_id;
		l.add(customer_id);
	}
	
	public int getcustomer_id() {
		return customer_id;
	}
	
	public static List<Integer> getallcustomers(){
		return l;
	}
	
	public void book(String pickup, String drop, int pickupTime) {
	    int distance = Location.calculateDistance(pickup, drop);
	    int time = Location.calculateTime(distance);
	    int fare = Location.calculatefare(pickup, drop);

	    Taxi assignedTaxi = Taxi.assignTaxiAtLocation(pickup);

	    if (assignedTaxi != null) {
	        System.out.println("Taxi can be allotted");
	        System.out.println("Taxi-" + assignedTaxi.id + " is allotted");

	        Booking booking = new Booking(customer_id, pickup, drop, pickupTime, distance, fare);

	        Taxi.releaseTaxi(assignedTaxi, drop, fare, booking);
	    } else {
	        System.out.println("Booking Rejected — No taxi available at " + pickup);
	    }
	}



}
