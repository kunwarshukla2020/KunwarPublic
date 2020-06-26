package com.mycode.practice;

import java.util.HashMap;

public class LongestPalindrome {
	public static void main(String[] args) {
		String s = "babad"; // bab
		// String s= "cbbd"; //bb
		// String s= "racecar";
		//String s = "geeksskeeg";
		longestPalindrome(s);
	}
	// ba
	// bab
	// baba
	// babad

	// ab
	// aba
	//Brute Force
	private static void longestPalindrome(String s) {
		HashMap<Integer, String> mp = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			String s1 = "";
			for (int j = i; j < s.length(); j++) {
				s1 = s1 + s.charAt(j);
				System.out.println(s1);
				if(s1.equals(new StringBuilder(s1).reverse()+"")) {
					mp.put(s1.length(), s1);
					//can use arrayList and sort it
				}
				
			}
			System.out.println();
		}
		System.out.println(mp);
	}
}