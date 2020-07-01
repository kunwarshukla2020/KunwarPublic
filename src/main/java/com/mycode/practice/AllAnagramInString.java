package com.mycode.practice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Ques- Count of total anagram substrings 
 * Input : str = “xyyx” 
 * Output : 4 {“x”, “x”}, {"y", "y"}, {“xy”, “yx”}, {“xyy”,
 * “yyx”}
 */

//https://www.geeksforgeeks.org/count-total-anagram-substrings/
// ALSO see- https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
//Anagram - Rearrangement of words/letter
public class AllAnagramInString {
	public static void main(String[] args) {
		String s = "xyyx"; 
		//String s= "abc"; //yes - a a, b b, c c, ab ba, bc cb, ac ca, abc acb cab - NOTE- its not 7 its 0 here, it has to be substring THINK

		allAnagram(s);

	}

	static void allAnagram(String s) {
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				System.out.println("substring: "+s.substring(i, j + 1));
				char[] valC = s.substring(i, j + 1).toCharArray();
				Arrays.sort(valC); // sorting array
				String val = new String(valC); //note - char array to string
				//System.out.println("val: "+val);
				if (map.containsKey(val))
					map.put(val, map.get(val) + 1);
				else
					map.put(val, 1);
			}
		}
		System.out.println("map: "+map); // OR Can also count values of map greater then or equal to 2
		
		int anagramPairCount = 0;
		for (String key : map.keySet()) {
			int n = map.get(key);
			anagramPairCount += (n * (n - 1)) / 2;
		}
		System.out.println(anagramPairCount);
	}
}
