package bookings;

import java.util.ArrayList;

import members.Driver;

public abstract class Fare {
	
	protected double fare;
	
	ArrayList<Driver> observers = new ArrayList<Driver>();
	
	public Fare() {
	}
	
	public void addObserver(Driver driver) {
		if(!observers.contains(driver)) {
			driver.setObserver(true);
			observers.add(driver);
			
		}
	}
	
	public void removeObserver(Driver driver) {
		driver.setObserver(false);
		observers.remove(driver);
	}
	
	public void notifyObservers(String message) {
		for (Driver driver : observers) {
			driver.update(this, message);
		}
	}

}
