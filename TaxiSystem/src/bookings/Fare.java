package bookings;

import java.util.ArrayList;

import members.Driver;

public abstract class Fare {
	
	protected double fare;
	
	ArrayList<Driver> observers = new ArrayList<Driver>();
	
	public Fare() {
		// TODO Auto-generated constructor stub
	}
	
	public void addObserver(Driver driver) {
		observers.add(driver);
	}
	
	public void removeObserver(Driver driver) {
		observers.remove(driver);
	}
	
	public void notifyObservers(String message) {
		for (Driver driver : observers) {
			driver.update(this, message);
		}
	}

}
