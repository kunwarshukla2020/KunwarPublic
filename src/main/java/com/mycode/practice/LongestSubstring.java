package com.mycode.practice;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
	public static void main(String[] args) {
		String s = "abcabcbb"; // abc-3(length)
		// String s= "bbbbb"; //b-1
		// String s= "pwwkew"; //wke-3
		longestSubstring(s);
	}

	// Brute Force
	private static void longestSubstring(String s) {
		String longestString = "";
		String resultString = "";
		String s1 = "";
		HashSet<String> set = new HashSet();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				s1 = s.charAt(j) + "";
				if (!set.contains(s1)) {
					set.add(s1);
					longestString = longestString + s1;
					// System.out.println("longestString: "+longestString);
					 //System.out.println("set: "+set); i think longestString is not required
				} else {
					if (longestString.length() > resultString.length()) {
						resultString = longestString;
					}
					set.clear();
					longestString = "";
					// System.out.println("resultString: "+resultString);
				}

			}
		}
		System.out.println("resultString: " + resultString);
	}

}