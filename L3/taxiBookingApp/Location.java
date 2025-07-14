package taxiBookingApp;

import java.util.*;

public class Location {
	
	static List<String> locationlist=Arrays.asList("A","B","C","D","E","F");
	
	public static int calculateDistance(String pickup,String drop) {
		int index1=locationlist.indexOf(pickup.toUpperCase());
		int index2=locationlist.indexOf(drop.toUpperCase());
		int hops=Math.abs(index1-index2);
		return hops*15;
	}
	public static int calculateTime(int distance) {
		return (distance/15)*60;
	}
	
	
	public static int calculatefare(String pickup, String drop) {
		int distance = calculateDistance(pickup, drop); 
		if(distance<=5) return 100;
		return 100+(distance-5)*10;
	}
	
	public static void showLocations() {
		System.out.println(locationlist);
	}

}
