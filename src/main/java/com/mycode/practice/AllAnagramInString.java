package com.mycode.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/**
 * Ques- Count of total anagram substrings 
 * Input : str = “xyyx” 
 * Output : 4 {“x”, “x”}, {"y", "y"}, {“xy”, “yx”}, {“xyy”, “yyx”}
 */

//https://www.geeksforgeeks.org/count-total-anagram-substrings/
// ALSO see- https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
//Anagram - Rearrangement of words/letter
public class AllAnagramInString {
	public static void main(String[] args) {
		String s = "xyyx";
		// String s= "abc"; //yes - a a, b b, c c, ab ba, bc cb, ac ca, abc acb cab - NOTE- its not 7 its 0 here, it has to be
		// substring THINK

		allAnagram(s);

// 		Another question can be - Find All Anagrams in a String
//		Input: s: "cbaebabacd" p: "abc"
//		Output:	[0, 6]
//		Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc".
//					 The substring with start index = 6 is "bac", which is an anagram of "abc".
		String s1="abab";
		String p="ab";
		findAnagrams(s1, p);

	}

	static void allAnagram(String s) {
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				System.out.println("substring: " + s.substring(i, j + 1));
				char[] valC = s.substring(i, j + 1).toCharArray();
				Arrays.sort(valC); // sorting array
				String val = new String(valC); // note - char array to string
				// System.out.println("val: "+val);
				if (map.containsKey(val))
					map.put(val, map.get(val) + 1);
				else
					map.put(val, 1);
			}
		}
		System.out.println("map: " + map); // OR Can also count values of map greater then or equal to 2

		int anagramPairCount = 0;
		for (String key : map.keySet()) {
			int n = map.get(key);
			anagramPairCount += (n * (n - 1)) / 2;
		}
		System.out.println(anagramPairCount);
	}

	static void findAnagrams(String s, String p) {
		Vector v = new Vector();
		for (int i = 0; i <= (s.length() - p.length()); i++) {
			String sub = s.substring(i, p.length() + i);
			boolean f = isAnagram(sub, p);
			System.out.println(sub);
			System.out.println(f);
			if (f) {
				v.add(i);
			}
		}
		System.out.println(v);
	}

	private static boolean isAnagram(String sub, String p) {
		char[] s1 = sub.toCharArray();
		char[] s2 = p.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		if (Arrays.equals(s1, s2)) {
			return true;
		}
		return false;
	}
}
