package ui;

import java.util.HashMap;

public class LocationMapping {

	private static LocationMapping locationsObject;
	private HashMap<String, Location> locations = new HashMap<String, Location>();

	private LocationMapping() {
		getLocations().put("1 Washington Square , San Jose", new Location(2, 3));
		getLocations().put("2933 Bunker hill lane, Santa Clara", new Location(3, 5));
		getLocations().put("1000 Lakeshore circle , Campbell", new Location(1, 2));
		getLocations().put("2045 W Remington Drive, Fremont", new Location(1, 2));
		getLocations().put("4322 Albany dr, Fremont", new Location(4,5));
		getLocations().put("2134 Kaiser dr, Cupertino", new Location(3,4));
		getLocations().put("900 Kaiely dr, Palo Alto", new Location(6,6));
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
