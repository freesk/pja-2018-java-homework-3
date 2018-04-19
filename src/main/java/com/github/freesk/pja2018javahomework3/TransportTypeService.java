package com.github.freesk.pja2018javahomework3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TransportTypeService {

	private static final Map<Integer, String> hm = createMap();

    private static Map<Integer, String> createMap() {
        Map<Integer, String> result = new HashMap<Integer, String>();
        result.put(0, "BUS & TRAIN");
        result.put(1, "BUS");
        result.put(2, "TRAIN");
        return Collections.unmodifiableMap(result);
    }
    
    public static String getTypeById(int n) {
    	return hm.get(n);
    }
	
}
