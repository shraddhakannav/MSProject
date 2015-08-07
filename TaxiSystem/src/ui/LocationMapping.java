package ui;

import java.util.HashMap;

public class LocationMapping {

	private static LocationMapping locationsObject;
	private HashMap<String, Location> locations = new HashMap<String, Location>();

	private LocationMapping() {
		getLocations().put("sjsu", new Location(2, 3));
		getLocations().put("bunker hill lane", new Location(3, 5));
		getLocations().put("sfo", new Location(1, 2));
		getLocations().put("sjc", new Location(1, 2));
	}

	public static LocationMapping getLocationObject() {
		if (locationsObject == null) {
			locationsObject = new LocationMapping();
		}
		return locationsObject;
	}

	public HashMap<String, Location> getLocations() {
		return locations;
	}

}
