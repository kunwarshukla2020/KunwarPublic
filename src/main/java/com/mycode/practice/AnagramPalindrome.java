package com.mycode.practice;

/**
 * Ques- Check if any anagram of a string is palindrome or not
 * OR Check if characters of a given string can be rearranged to form a palindrome
 * 
 */

//Anagram - Rearrangement of words/letter
// racecar
// ^^   ^^ -> start from beginning and mark each character an put in beginning and ending array like below
// [rac...ar]

//Approach # 1
//1) Create a count array of alphabet size which is typically 256. Initialize all values of count array as 0.
//2) Traverse the given string and increment count of every character.
//3) Traverse the count array and if the count array has more than one odd values, return false. Otherwise return true.
// O(n) time

//Approach # 2
// Can also use Set-> if set contains(word.charAt(i)) then delete it else add it and at the end if set size is more then 1 return false

//Approach # 3
//1) For every character in the string, remove the character if the (Charcter) list already contains else add to the list.
//2) If the string length is even the list is expected to be empty.
//3) Or if the string length is odd the list size is expected to be 1
//4) On the above two conditions (3) or (4) return true else return false.

//https://www.youtube.com/watch?v=_htNxx8DYZo
public class AnagramPalindrome {
	public static void main(String[] args) {
		String s = "geeksogeeks"; // yes- geeksoskeeg - length - 11, o appears once
		// String s= "geeksgeeks"; //yes- geeksskeeg or kgeesseegk - length -10 - all letter appear twice
		// String s= "racecar"; //yes
		// String s = "geeksforgeeks";//no

		if (anagramPalindrome(s)) {
			System.out.println("\nIt's a anagram palindrome: " + s);
		} else {
			System.out.println("\nIt's NOT a anagram palindrome: " + s);
		}
	}

	private static boolean anagramPalindrome(String word) {
		int oddOccur = 0;
		int[] count = new int[256]; // By default int array has all 0

		System.out.println('A' - 65); // A-0,B-1... can also create Array for 26 characters instead of 256, by minus 65
		System.out.println(word.toUpperCase().charAt(0) - 65); // G-6
		System.out.println(word.toUpperCase().charAt(1) - 65); // E-4

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			count[ch]++;
		}

		for (int cnt : count) {
			if (oddOccur > 1) {
				return false;
			}
			if (cnt % 2 == 1) {
				oddOccur++;
			}
		}
		return true;
	}
}