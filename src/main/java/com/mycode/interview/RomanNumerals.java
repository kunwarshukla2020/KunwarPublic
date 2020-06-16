package com.mycode.interview;

import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumerals {
	static Map<String, String> managerMap = new LinkedHashMap<>();
	static Map<String, String> employeeMap = new LinkedHashMap<>();
	static Map<String, String> employeeMap1 = new LinkedHashMap<>();
	// static Map<String,Map<String,String>> managerMap1 = new HashMap<>();

	public static void main(String args[]) {
		RomanNumerals(7);
		/*for (int i = 1; i < 256; i++) {
			System.out.println("i=" + i + " -> " + RomanNumerals(i));
		}*/
	}

	public static String RomanNumerals(int Int) {
		LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
		/*roman_numerals.put("M", 1000);
		roman_numerals.put("CM", 900);
		roman_numerals.put("D", 500);
		roman_numerals.put("CD", 400);
		roman_numerals.put("C", 100);
		roman_numerals.put("XC", 90);
		roman_numerals.put("L", 50);
		roman_numerals.put("XL", 40);
		roman_numerals.put("X", 10);*/
		roman_numerals.put("IX", 9);
		roman_numerals.put("V", 5);
		roman_numerals.put("IV", 4);
		roman_numerals.put("I", 1);
		String res = "";
		for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
			int matches = Int / entry.getValue();
			res += repeat(entry.getKey(), matches);
			Int = Int % entry.getValue();
			System.out.println("Int:"+Int);
		}
		return res;
	}

	public static String repeat(String s, int n) {
		if (s == null) {
			return null;
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(s);
		}
		System.out.println("sb.toString():"+sb.toString());
		return sb.toString();
	}

}
