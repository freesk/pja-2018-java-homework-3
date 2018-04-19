package com.github.freesk.pja2018javahomework3;

import java.util.ArrayList;

public class StopService {

	public StopService() {}
	
    public static ArrayList<Stop> getStopsByType(ArrayList<Stop> stops, int type) {
    	ArrayList<Stop> list = new ArrayList<Stop>();
    	
    	for (Stop s : stops)
    		if (s.getTypeId() == 0 || s.getTypeId() == type) list.add(s);
    		
    	return list;
    }
    
	public static String getStopType(Stop s) {
		return TransportTypeService.getTypeById(s.getTypeId());
	}

}
