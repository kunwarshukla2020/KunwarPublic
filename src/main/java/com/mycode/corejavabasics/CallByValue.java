package com.mycode.corejavabasics;

import java.util.ArrayList;
import java.util.List;

class Forecast {
	public int temp;
	public int pressure;
}

// Java is call by value
public class CallByValue {

	public static void main(String[] args) {
		// String doesnt change
		String weather = "rainy";
		changeString(weather);
		System.out.println("weather is: " + weather);

		// arrays changed, address is passed but by value
		String[] rainyDays = new String[] { "Monday", "Friday" };
		changeArray(rainyDays);
		System.out.println("Rainy days were: " + rainyDays[0] + " and " + rainyDays[1]);

		// Obj changed
		Forecast forecast = new Forecast();
		forecast.pressure = 700;
		forecast.temp = 20;
		changeObject(forecast);
		System.out.println("forecast.temp " + forecast.temp);

		// Obj special case not changed
		Object x = null;
		changeObject1(x);
		System.out.println("x--->" + x); // print null

		List<String> list1 = new ArrayList<>();
		list1.add("foo");

		List<String> list2 = list1;
		List<String> list3 = new ArrayList<>(list2);

		list1.clear();
		changeList(list2); //list changed
		list3.add("baz");

		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}

	private static void changeList(List<String> list2) {
		list2.add("bar");
	}

	public static void changeString(String weather) {
		weather = "sunny";
	}

	public static void changeArray(String[] rainyDays) {
		rainyDays[1] = "Sunday";
	}

	public static void changeObject(Forecast forecast) {
		forecast.temp = 35;
	}

	static void changeObject1(Object x) {
		x = "change";
	}
}

//OUTPUT-
//weather is: rainy
//Rainy days were: Monday and Sunday
//forecast.temp 35
//x--->null
//[bar]
//[bar]
//[foo, baz]
