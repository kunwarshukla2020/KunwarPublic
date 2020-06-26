package com.mycode.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class ValidParenthese {
	public static void main(String[] args) {
		String str = "([]{}[])";
		//System.out.println(Test1.CheckParentesis(str));
		ValidParenthese.longestSubstring();
	}
	

	public static boolean CheckParentesis(String str) {
		if (str.isEmpty())
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == '{' || current == '(' || current == '[') {
				stack.push(current);
			}

			if (current == '}' || current == ')' || current == ']') {
				if (stack.isEmpty())
					return false;

				char last = stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
					stack.pop();
				else
					return false;
			}

		}

		return stack.isEmpty();
	}

	public static HashMap<Integer, String> longestSubstring() {
		
		String input = "aabaaacde";
		String longString = "";
		HashMap<Integer, String> resultMap = new HashMap<>();
		
		for (int j = 1; j < input.length(); j++) {
			char previousChar = input.charAt(j-1);
			char current = input.charAt(j);
			
			if(previousChar==current) {
				longString = current+"";
				System.out.println("longString-->"+longString);
			}
			else {
				longString = longString + current; 
				System.out.println("longString-->"+longString);
				resultMap.put(longString.length(), longString);
			}
		}
		System.out.println("resultMap-->"+resultMap);
		return resultMap;
	}

}
