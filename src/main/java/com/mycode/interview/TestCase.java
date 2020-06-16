package com.mycode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.commons.lang3.StringUtils;

public class TestCase {
	public static void main(String[] args) {
		String[] T = { "codility1", "codility3", "codility2", "codility4b", "codility4a" };
		String[] R = { "Wrong answer", "OK", "OK", "Runtime error", "OK" };
		System.out.println("test1--->" + new TestCase().solution(T, R));
	}

	public int solution(String[] T, String[] R) {
		 if (T != null && T.length != R.length || T.length == 0) {
			return 0;
		}

		List<String> passedtestCaseList = new ArrayList<>();
		Map<String, ArrayList<String>> testGroupMap = new HashMap<>();
		for (String t : T) {
			if (Character.isDigit(t.charAt(t.length() - 1))) {
				ArrayList<String> testCases = new ArrayList<>();
				testCases.add(t);
				testGroupMap.put(t, testCases);
			} else {
				//String result = StringUtils.chop(t); StringUtils is not working
				String result =  t.substring(0, t.length() - 1);
				ArrayList<String> testCases = testGroupMap.get(result);
				if (testCases == null) {
					testCases = new ArrayList<>();
				}
				testCases.add(t);
				testGroupMap.put(result, testCases);
			}
		}
		//System.out.println("testGroupMap" + testGroupMap);
		for (int i = 0; i < R.length; i++) {
			if (R[i].equals("OK")) {
				passedtestCaseList.add(T[i]);
			}
		}
		//System.out.println("passedtestCaseList-->" + passedtestCaseList);
		boolean passed = false;
		int finalPassed = 0;
		for (ArrayList<String> testCases : testGroupMap.values()) {
			for (String r : testCases) {
				if (passedtestCaseList.contains(r)) {
					passed = true;
				} else {
					passed = false;
					break;
				}
			}
			if (passed) {
				finalPassed++;
			}
		}

		//System.out.println("finalPassed-->" + finalPassed);
		int points = (finalPassed * 100) / testGroupMap.size();
		return points;
    
    
    }

}
