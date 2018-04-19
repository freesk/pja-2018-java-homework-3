package com.github.freesk.pja2018javahomework3;

import java.util.ArrayList;

public class JoinedStop extends Stop {

	private ArrayList<Stop> stops = new ArrayList<Stop>();
	private int typeId = 0;

	public JoinedStop() {}
	
	public JoinedStop(ArrayList<Stop> stops) {
		this.stops = stops;
		this.typeId = getTypeId();
	}
	
	public void addStop(Stop stop) {
		stops.add(stop);
		this.typeId = getTypeId();
	}
	
	public int getTypeId() {
		// return default 
		if (stops.isEmpty())
			return 0;
		// get type of the first stop
		int type = stops.get(0).getTypeId(); 		
		// if at least one doesn't equal to the first, return default
		for (Stop s : stops)
			if (s.getTypeId() != type) return 0;
		// else, return current
		return type;
	}
	
	public String getName() {
		String res = "";
		for (int i = 0; i < stops.size(); i++) {
			res += stops.get(i).getName();
			res += (i == (stops.size() - 1) ? "" : ", "); 
		}
		return res;
	}
	
	public Stop getChildById(int n) {
		return this.stops.get(n);
	}
	
	private String printChildren() {
		String res = "";
		for (Stop s : stops)
			res += "    {\n" + 
		           "       id: " + s.id + "\n" +
		           "       name: " + s.getName() + "\n" +
		           "       type: " + s.getTypeId() + "\n" +
		           "    }\n";
		
		return res;
	}
	
	@Override
	public String toString() {
		return "{\n" + 
				"  id  : " + id + "\n" + 
				"  type: " + typeId + "\n" +
				"  children: {\n" +
				printChildren() + 
				"  }\n" +
				"}";				
				
	}

}
