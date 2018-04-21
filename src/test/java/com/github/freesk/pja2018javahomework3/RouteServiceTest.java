package com.github.freesk.pja2018javahomework3;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.github.freesk.pja2018javahomework3.RouteService;
import com.github.freesk.pja2018javahomework3.Stop;

public class RouteServiceTest {

	@Test
	public void hasRouteTest() {
		RouteService.addRoute(1, "R1", new ArrayList<Stop>());
		boolean answer = RouteService.hasRoute("R1");
		Assert.assertEquals(true, answer);
	}
	
	@Test 
	public void removeRouteTest() {
		RouteService.addRoute(1, "R1", new ArrayList<Stop>());
		RouteService.removeByRouteId(0);
		boolean answer = RouteService.hasRoute("R1");
		Assert.assertEquals(false, answer);
	}
	
	@Test 
	public void getRoutesByStopTest() {
		Stop s = new Stop("test-stop-1", 1);
		ArrayList<Stop> stops = new ArrayList<Stop>();
		stops.add(s);
		RouteService.addRoute(1, "R1", new ArrayList<Stop>());
		RouteService.assingStopsToRouteId(0, stops);
		ArrayList<String> list = RouteService.getRoutesByStop(s);
		Assert.assertEquals(1, list.size());
	}
	
	@Test
	public void getRouteTypeOneTest() {
		RouteService.addRoute(1, "R1", new ArrayList<Stop>());
		String type = RouteService.getRouteType(1);
		Assert.assertEquals("BUS", type);
	}
	
	@Test
	public void getRouteTypeTwoTest() {
		RouteService.addRoute(2, "R1", new ArrayList<Stop>());
		String type = RouteService.getRouteType(2);
		Assert.assertEquals("TRAIN", type);
	}
	
	@Test(expected = IOException.class)
	public void paraseNameWithNull() throws IOException {
		String string = null;
		RouteService.parseName(string);	
	}
	
	@Test(expected = IOException.class)
	public void paraseNameWithTooLongString() throws IOException {
		String string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		RouteService.parseName(string);	
	}
	
	@Test(expected = IOException.class)
	public void paraseNameWithEmptyString() throws IOException {
		String string = "";
		RouteService.parseName(string);	
	}
	
	@Test(expected = IOException.class)
	public void paraseNameWithAlreadyExistingString() throws IOException {
		String string = "R1";
		RouteService.addRoute(1, "R1", new ArrayList<Stop>());
		RouteService.parseName(string);	
	}

}
