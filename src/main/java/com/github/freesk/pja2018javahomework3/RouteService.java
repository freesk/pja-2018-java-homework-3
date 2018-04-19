package com.github.freesk.pja2018javahomework3;

import java.io.IOException;
import java.util.ArrayList;

public class RouteService {
	
	final static int maxLength = 30;
	
	public static ArrayList<Route> routes = new ArrayList<Route>();

	public RouteService() {}
	
	public static boolean hasRoute(String name) {
		for(Route r : routes)
			if (r.name.equals(name)) return true;
		
		return false;
	} 
	
	public static String parseName(String string) throws IOException {
		if (string == null) 
			throw new IOException("[Error] cannot be null");
		else if (string.isEmpty())
    		throw new IOException("[Error] cannot be empty");
    	else if (string.length() > maxLength)
    		throw new IOException("[Error] cannot exceed 30 symobls");
    	else if (RouteService.hasRoute(string))
    		throw new IOException("[Error] route " + string + " already exists");
		
		return string;
	}
	
	public static int parseType(int n) throws IOException {
        if (n != 1 && n != 2)
        	throw new IOException("[Error] only 1 or 2");
        return n;
	}
	
	public static ArrayList<String> getAllRoutes() {
		ArrayList<String> res = new ArrayList<String>(); 
    	
    	for (Route r : routes)
    		res.add(r.name + " (" + RouteService.getRouteType(r.type) + ")");
    	
    	return res;
	}
	
	public static ArrayList<Stop> getRouteIdStops(int n) {
		return routes.get(n).stops;
	}
	
	public static String getRouteInfoById(int n) {
		Route r = routes.get(n);
		return r.name + " (" + RouteService.getRouteType(r.type) +  ")";
	}
	
	public static void addRoute(int type, String name, ArrayList<Stop> stops) {
		routes.add(new Route(type, name, stops));
	}
	
	public static ArrayList<String> getRoutesByStop(Stop stop) {
		ArrayList<String> res = new ArrayList<String>();
		
		for(Route r : routes)
			if (r.hasStop(stop)) res.add(r.name);
		
		return res;
	}
	
	public static Route getRoutById(int n) {
		return routes.get(n);
	}
	
	public static String getRouteType(int n) {
		if (n == 1)
			return "BUS";
		else if (n == 2) 
			return "TRAIN";
		else 
			return "undefined";
	}
	
	public static void removeByRouteId(int id) {
		if (id < 0)
			System.out.println("[Warning] route " + routes.get(id).name + " is unknown");
		else 
			routes.remove(id);
	}
	
	public static void renameRouteId(int id, String name) {
		routes.get(id).name = name;
	}
	
	public static void assingStopsToRouteId(int id, ArrayList<Stop> stops) {
		routes.get(id).stops = stops;
	}
	
	public static int getRouteIdType(int id) {
		return routes.get(id).type;
	}
	
	// inner class
	static class Route {

		private ArrayList<Stop> stops = new ArrayList<Stop>();
		private int type = 0;
		private String name = "";
		
		public Route() {}
		
		public Route(int type, String name) {
			this.type = type;
			this.name = name;
		}
		
		public Route(int type, String name, ArrayList<Stop> stops) {
			this(type, name);
			this.stops = stops;
		}
			
		public void assingStops(ArrayList<Stop> stops) {
			if (stops == null)
				System.out.println("[Warning] cannot assign null");
			else {
				this.stops = stops;	
			}
		}
		
		public int getNumberOfStops() {
			return stops.size();
		}
		
		public boolean hasStop(Stop stop) {
			int index = stops.indexOf(stop);
			return index > -1;
		}
		
		public void addStop(Stop stop) {
			if (stop.getType() != this.type) 
				throw new RuntimeException("[Error] cannot add " + stop.getName() + " to the route because of its type");
			
			stops.add(stop);
		}
		
		public void removeStop(Stop stop) {
			int index = stops.indexOf(stop);
			if (index < 0)
				throw new RuntimeException("[Error] " + stop.getName() + "does not exist in the route");
			
			stops.remove(index);
		}
		
	}

}
